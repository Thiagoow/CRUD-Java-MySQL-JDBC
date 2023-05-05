package gamestore.view;

import javax.swing.JOptionPane;
import gamestore.controller.PurchasesController;
import java.sql.SQLException;
import java.util.List;
import gamestore.model.bean.Purchases;

public class KeepPurchases {

    static PurchasesController purchasesControl;

    public static void insert() throws SQLException, ClassNotFoundException {
        double total_value = Double.parseDouble(JOptionPane.showInputDialog("Valor Total"));
        int id_games = Integer.parseInt(JOptionPane.showInputDialog("ID Games"));
        int id_customers = Integer.parseInt(JOptionPane.showInputDialog("ID Clientes"));
        Purchases purchaseEntry = new Purchases(total_value, id_games, id_customers);

        purchasesControl = new PurchasesController();
        Purchases purchaseOutput = purchasesControl.insert(purchaseEntry);
        JOptionPane.showMessageDialog(null, purchaseOutput.toString());
    }

    public static void update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        double total_value = Double.parseDouble(JOptionPane.showInputDialog("Valor Total"));
        int id_games = Integer.parseInt(JOptionPane.showInputDialog("ID Instrumentos"));
        int id_customers = Integer.parseInt(JOptionPane.showInputDialog("ID Clientes"));
        Purchases purchaseEntry = new Purchases(id, total_value, id_games, id_customers);
        
        purchasesControl = new PurchasesController();
        Purchases purchaseOutput = purchasesControl.update(purchaseEntry);
        JOptionPane.showMessageDialog(null, purchaseOutput.toString());
    }
    
    public static void list() throws SQLException, ClassNotFoundException {
        try {
        String idClients = JOptionPane.showInputDialog("Id cliente");
        Purchases purchaseEntry = new Purchases(idClients);
        purchasesControl = new PurchasesController();

        List<Purchases> purchaseOutput = purchasesControl.list(purchaseEntry);
        for(Purchases comp_ : purchaseOutput) {
            JOptionPane.showMessageDialog(null, comp_.toString());
        }
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void search() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Purchases purchaseEntry = new Purchases(id);
        purchasesControl = new PurchasesController();
        Purchases purchaseOutput = purchasesControl.search(purchaseEntry);
        JOptionPane.showMessageDialog(null, purchaseOutput.toString());
    }

    public static void delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Purchases purchaseEntry = new Purchases(id);
        purchasesControl = new PurchasesController();
        Purchases aceSaida = purchasesControl.delete(purchaseEntry);
        JOptionPane.showMessageDialog(null, aceSaida.toString());
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        int option = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
        switch (option) {
            case 0 -> {
                int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");
                System.out.println("Se sim, escolha: " + sair);
                if (sair > 0) menu();
            }
            case 1 -> insert();
            case 2 -> update();
            case 3 -> delete();
            case 4 -> search();
            case 5 -> list();
            default -> {
                JOptionPane.showMessageDialog(null, "Error - Invalid option");
                menu();
            }
        }
    }
}
