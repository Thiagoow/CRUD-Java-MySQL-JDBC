package gamestore.model.dao;
import gamestore.model.bean.Games;
import gamestore.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class DaoGames {
    private final Connection c;

    public DaoGames() throws SQLException, ClassNotFoundException {
        this.c = new DbConnection().getConnection();
    }

    public Games insert(Games ins) throws SQLException {
        String sql = "insert into games (name, value, type) values (?,?,?)";

        // prepared statement para inserção
        PreparedStatement instru = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        instru.setString(1, ins.getName());
        instru.setDouble(2, ins.getValue());
        instru.setString(3, ins.getType());

        // executa
        instru.executeUpdate();
        ResultSet rs = instru.getGeneratedKeys();
        if (rs.next()) {
            ins.setId(rs.getInt(1));
        }
        instru.close();
        return ins;
    }

    public Games search(Games ins) throws SQLException {
        String sql = "select * from games WHERE id = ?";
        PreparedStatement instru = this.c.prepareStatement(sql);
        // seta os valores
        instru.setInt(1, ins.getId());
        // executa
        ResultSet rs = instru.executeQuery();
        Games retorno = null;
        while (rs.next()) {
            // criando o objeto Usuario
            retorno = new Games(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
        }
        instru.close();
        return retorno;
    }

    public Games update(Games ins) throws SQLException {
        String sql = "UPDATE Games SET name = ?, value = ?, type = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement instru = c.prepareStatement(sql);
        // seta os valores
        instru.setString(1, ins.getName());
        instru.setDouble(2, ins.getValue());
        instru.setString(3, ins.getType());
        instru.setInt(4, ins.getId());

        // executa
        instru.execute();
        instru.close();
        return ins;
    }

    public Games delete(Games ins) throws SQLException {
        String sql = "delete from games WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement instru = c.prepareStatement(sql);
        // seta os valores
        instru.setInt(1, ins.getId());
        // executa
        instru.execute();
        instru.close();
        c.close();
        return ins;
    }

    public List<Games> list(Games insEnt) throws SQLException {
        // usus: array armazena a lista de registros
        //Trocar usuarios para Games
        List<Games> inst = new ArrayList<>();

        String sql = "select * from games where name like ?";
        PreparedStatement instru = this.c.prepareStatement(sql);
        // seta os valores
        //Nome para Games
        instru.setString(1, "%" + insEnt.getName() + "%");

        ResultSet rs = instru.executeQuery();

        while (rs.next()) {

            Games ins = new Games(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4)
            );
            // adiciona o usu à lista de usus
            inst.add(ins);
        }

        rs.close();
        instru.close();
        return inst;
    }
}
