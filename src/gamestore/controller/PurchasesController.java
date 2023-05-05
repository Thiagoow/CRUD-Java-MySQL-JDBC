package gamestore.controller;

import java.util.List;
import java.sql.SQLException;
import gamestore.model.bean.Purchases;
import gamestore.model.dao.DaoPurchases;

public class PurchasesController {
    DaoPurchases daoCOMP = null;

    public Purchases delete(Purchases comp) throws SQLException, ClassNotFoundException {
        daoCOMP = new DaoPurchases();
        return daoCOMP.delete(comp);
    }

    public Purchases update(Purchases comp) throws SQLException, ClassNotFoundException {
        daoCOMP = new DaoPurchases();
        return daoCOMP.update(comp);
    }
    
    public List<Purchases> list(Purchases comp) throws Exception {
        daoCOMP = new DaoPurchases();
        List<Purchases> Purchases = daoCOMP.list(comp);
        
        if(Purchases == null) {
            throw new Exception("No purchases from this customer!");
        }
        return Purchases;  
    }

    public Purchases search(Purchases comp) throws SQLException, ClassNotFoundException {
        daoCOMP = new DaoPurchases();
        return daoCOMP.search(comp);
    }

    public Purchases insert(Purchases comp) throws SQLException, ClassNotFoundException {
        daoCOMP = new DaoPurchases();
        return daoCOMP.insert(comp);
    }
}
