package gamestore.controller;

import java.util.List;
import java.sql.SQLException;
import gamestore.model.bean.Clients;
import gamestore.model.dao.DaoClients;

public class ClientsController {
    DaoClients daoCli = null;

    public Clients delete(Clients cl) throws SQLException, ClassNotFoundException {
        daoCli = new DaoClients();
        return daoCli.delete(cl);
    }

    public Clients update(Clients cl) throws SQLException, ClassNotFoundException {
        daoCli = new DaoClients();
        return daoCli.update(cl);
    }

    public List<Clients> list(Clients cl) throws Exception {
        daoCli = new DaoClients();
        List<Clients> clientes = daoCli.list(cl);
        
        if(clientes == null) {
            throw new Exception("Não tem clientes cadastrados!");
        }
        return clientes;  
    }

    public Clients search(Clients cl) throws SQLException, ClassNotFoundException {
        daoCli = new DaoClients();
        return daoCli.search(cl);
    }

    public Clients insert(Clients cl) throws SQLException, ClassNotFoundException {
        daoCli = new DaoClients();
        return daoCli.insert(cl);
    }

    public boolean validate(Clients usuEntrada) throws SQLException, ClassNotFoundException {
        boolean validated = false;
        daoCli = new DaoClients();
        Clients cliSaida = daoCli.validate(usuEntrada);
        if (usuEntrada.getUsername().equals(cliSaida.getUsername())) {
            if (usuEntrada.getPassword().equals(cliSaida.getPassword())) {
                validated = true;
            }
        }
        return validated;
    }
}
