package gamestore.controller;

import java.util.List;
import java.sql.SQLException;
import gamestore.model.bean.Clientes;
import gamestore.model.dao.DaoClients;

public class ClientsController {
    DaoClients daoCli = null;

    public Clientes delete(Clientes cl) throws SQLException, ClassNotFoundException {
        daoCli = new DaoClients();
        return daoCli.delete(cl);
    }

    public Clientes update(Clientes cl) throws SQLException, ClassNotFoundException {
        daoCli = new DaoClients();
        return daoCli.update(cl);
    }

    public List<Clientes> list(Clientes cl) throws SQLException, ClassNotFoundException, Exception {
        daoCli = new DaoClients();
        List<Clientes> clientes = daoCli.list(cl);
        
        if(clientes == null) {
            throw new Exception("Não tem clientes cadastrados!");
        }
        return clientes;  
    }

    public Clientes search(Clientes cl) throws SQLException, ClassNotFoundException {
        daoCli = new DaoClients();
        return daoCli.search(cl);
    }

    public Clientes insert(Clientes cl) throws SQLException, ClassNotFoundException {
        daoCli = new DaoClients();
        return daoCli.insert(cl);
    }

}
