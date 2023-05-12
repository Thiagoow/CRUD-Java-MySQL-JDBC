package gamestore.model.dao;
import gamestore.model.bean.Clients;
import gamestore.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoClients {
    private final Connection c;
    
    public DaoClients() throws SQLException, ClassNotFoundException{
        this.c = new DbConnection().getConnection();
    }

    public Clients delete(Clients clEntrada) throws SQLException {
        String sql = "delete from clients WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement cli = c.prepareStatement(sql);
        // seta os valores
        cli.setInt(1,clEntrada.getId());
        // executa
        cli.execute();
        cli.close();
        cli.close();
        return clEntrada;
    }

    public Clients search(Clients clEntrada) throws SQLException {
        String sql = "select * from clients WHERE id = ?";
        PreparedStatement cli = this.c.prepareStatement(sql);
            // seta os valores
            cli.setInt(1,clEntrada.getId());
            // executa
            ResultSet rs = cli.executeQuery();
            Clients retorno = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                retorno = new Clients(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                );
            // adiciona o usu à lista de usus
            }
            cli.close();
        return retorno;

    }

    public Clients insert(Clients clEntrada) throws SQLException {
        String sql = "insert into clients" + " (username, password, name, cpf, email)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement cli = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        cli.setString(1,clEntrada.getUsername());
        cli.setString(2,clEntrada.getPassword());
        cli.setString(3,clEntrada.getName());
        cli.setString(2,clEntrada.getCpf());
        cli.setString(4,clEntrada.getEmail());

        // executa
        cli.executeUpdate();
        ResultSet rs = cli.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            clEntrada.setId(id);
        }
        cli.close();
        return clEntrada;
    }

    public Clients update(Clients clEntrada) throws SQLException {
        String sql = "UPDATE Clients SET username = ?, password = ?, name = ?, cpf = ?, email = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement cli = c.prepareStatement(sql);
        // seta os valores
        cli.setString(1,clEntrada.getUsername());
        cli.setString(2,clEntrada.getPassword());
        cli.setString(1,clEntrada.getName());
        cli.setString(2,clEntrada.getCpf());
        cli.setString(4,clEntrada.getEmail());
        cli.setInt(5,clEntrada.getId());

        // executa
        cli.execute();
        cli.close();
        return clEntrada;
    }

    public List<Clients> list(Clients clEntrada) throws SQLException {
        // usus: array armazena a lista de registros
        List<Clients> listacl = new ArrayList<>();
        
        String sql = "select * from clients where name like ?";
        PreparedStatement cli = this.c.prepareStatement(sql);
        // seta os valores
        cli.setString(1,"%" + clEntrada.getName() + "%");
        
        ResultSet rs = cli.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Clients cl = new Clients(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            // adiciona o usu à lista de usus
            listacl.add(cl);
        }
        
        rs.close();
        cli.close();
        
        return listacl;
    }

    public Clients validate(Clients cli) throws SQLException {
        // cria o select para ser executado no banco de dados
        String sql = "select * from clients WHERE username = ? AND password = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, cli.getUsername());
        stmt.setString(2, cli.getPassword());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        Clients retorno = null;
        while (rs.next()) {
            // criando o objeto Usuario
            retorno = new Clients(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
            );
            // adiciona o usu à lista de usus
        }
        stmt.close();
        assert retorno != null;
        System.out.println("Cliente: " + retorno.toString());

        return retorno;
    }
}