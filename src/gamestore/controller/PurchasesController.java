package gamestore.controller;

import java.util.List;
import java.sql.SQLException;
import gamestore.model.bean.Purchases;
import gamestore.model.dao.DaoPurchases;

public class PurchasesController {
    DaoPurchases daoPurchases;

    public Purchases delete(Purchases comp) throws SQLException, ClassNotFoundException {
        daoPurchases = new DaoPurchases();
        return daoPurchases.delete(comp);
    }

    public Purchases update(Purchases comp) throws SQLException, ClassNotFoundException {
        daoPurchases = new DaoPurchases();
        return daoPurchases.update(comp);
    }
    
    public List<Purchases> list(Purchases comp) throws Exception {
        daoPurchases = new DaoPurchases();
        List<Purchases> Purchases = daoPurchases.list(comp);
        
        if(Purchases == null) {
            throw new Exception("No purchases from this customer!");
        }
        return Purchases;  
    }

    public Purchases search(Purchases comp) throws SQLException, ClassNotFoundException {
        daoPurchases = new DaoPurchases();
        return daoPurchases.search(comp);
    }

    public Purchases insert(Purchases comp) throws SQLException, ClassNotFoundException {
        daoPurchases = new DaoPurchases();
        return daoPurchases.insert(comp);
    }
}
