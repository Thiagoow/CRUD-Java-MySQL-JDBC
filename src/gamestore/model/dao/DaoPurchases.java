package gamestore.model.dao;

import gamestore.util.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import gamestore.model.bean.Purchases;

public class DaoPurchases {
    private final Connection c;

    public DaoPurchases() throws SQLException, ClassNotFoundException {
        this.c = new Connection().getConnection();
    }

    public Purchases insert(Purchases ins) throws SQLException {
        String sql = "insert into purchases (total_value, id_games, id_customers) values (?,?,?)";

        // prepared statement para inserção
        PreparedStatement COMP = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        COMP.setDouble(1, ins.getTotal_value());
        COMP.setInt(2, ins.getId_games());
        COMP.setInt(3, ins.getId_customers());

        // executa
        COMP.executeUpdate();
        ResultSet rs = COMP.getGeneratedKeys();
        if (rs.next()) {
            ins.setId(rs.getInt(1));
        }
        COMP.close();
        return ins;
    }

    public Purchases search(Purchases ins) throws SQLException {
        String sql = "select * from purchases WHERE id_purchases = ?";
        PreparedStatement COMP = this.c.prepareStatement(sql);
        // seta os valores
        COMP.setInt(1, ins.getId());
        // executa
        ResultSet rs = COMP.executeQuery();
        Purchases retorno = null;
        while (rs.next()) {
            retorno = new Purchases(
                    rs.getInt(1),
                    rs.getDouble(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5)
            );
        }
        COMP.close();
        return retorno;
    }

    public Purchases alterar(Purchases comp) throws SQLException {
        System.out.println(comp.getId());
        String sql = "UPDATE purchases SET total_value = ?, id_games = ?, id_customers = ? WHERE id_purchases = ?";
        // prepared statement para inserção
        PreparedStatement COMP = c.prepareStatement(sql);
        // seta os valores
        COMP.setDouble(1, ins.getTotal_value());
        COMP.setInt(2, ins.getId_games());
        COMP.setInt(3, ins.getId_customers());
        COMP.setInt(4, comp.getId());

        // executa
        COMP.execute();
        COMP.close();
        return comp;
    }

    public Purchases excluir(Purchases comp) throws SQLException {
        String sql = "delete from purchases WHERE id_purchases = ?";
        // prepared statement para inserção
        PreparedStatement COMP = c.prepareStatement(sql);
        // seta os valores
        COMP.setInt(1, comp.getId());
        // executa
        COMP.execute();
        COMP.close();
        c.close();
        return comp;
    }

    public List<Purchases> listar(Purchases compEntrada) throws SQLException {
        // usus: array armazena a lista de registros

        List<Purchases> listacomp = new ArrayList<>();
        
        String sql = "select * from purchases where id_customers like ?";
        PreparedStatement comp_ = this.c.prepareStatement(sql);
        // seta os valores
        comp_.setString(1,"%" + compEntrada.getId_customers()+ "%");
        
        ResultSet rs = comp_.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Purchases compr = new Purchases(
                rs.getInt(1),
                rs.getDouble(2),
                rs.getInt(3),
                rs.getInt(4), 
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            listacomp.add(compr);
        }
        
        rs.close();
        comp_.close();
        
        return listacomp;
    }
}

