package gamestore.controller;

import java.util.List;
import java.sql.SQLException;
import gamestore.model.bean.Games;
import gamestore.model.dao.DaoGames;

public class GamesController {
    DaoGames daoGames;

    public Games delete(Games ins) throws SQLException, ClassNotFoundException {
        daoGames = new DaoGames();
        return daoGames.delete(ins);
    }

    public Games update(Games ins) throws SQLException, ClassNotFoundException {
        daoGames = new DaoGames();
        return daoGames.update(ins);
    }

    public List<Games> list(Games ins) throws SQLException, ClassNotFoundException {
        daoGames = new DaoGames();
        return daoGames.list(ins);
    }

    public Games search(Games ins) throws SQLException, ClassNotFoundException {
        daoGames = new DaoGames();
        return daoGames.search(ins);
    }

    public Games insert(Games ins) throws SQLException, ClassNotFoundException {
        daoGames = new DaoGames();
        return daoGames.insert(ins);
    }
}
