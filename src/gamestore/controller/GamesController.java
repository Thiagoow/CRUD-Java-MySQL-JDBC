package gamestore.controller;

import java.util.List;
import java.sql.SQLException;
import gamestore.model.bean.Games;
import gamestore.model.dao.DaoGames;

public class GamesController {
    DaoGames daoIns = null;

    public Games delete(Games ins) throws SQLException, ClassNotFoundException {
        daoIns = new DaoGames();
        return daoIns.delete(ins);
    }

    public Games update(Games ins) throws SQLException, ClassNotFoundException {
        daoIns = new DaoGames();
        return daoIns.update(ins);
    }

    public List<Games> list(Games ins) throws SQLException, ClassNotFoundException {
        daoIns = new DaoGames();
        return daoIns.list(ins);
    }

    public Games search(Games ins) throws SQLException, ClassNotFoundException {
        daoIns = new DaoGames();
        return daoIns.search(ins);
    }

    public Games insert(Games ins) throws SQLException, ClassNotFoundException {
        daoIns = new DaoGames();
        return daoIns.insert(ins);
    }
}
