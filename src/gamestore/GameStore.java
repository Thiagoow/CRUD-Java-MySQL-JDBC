package gamestore;

import gamestore.view.KeepClients; 
import gamestore.view.KeepPurchases; 
import gamestore.view.KeepGames; 
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GameStore {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (KeepClients.validate()) {
            menu();
        } else {
            System.out.println("INVALID USER");
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        int option = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Cliente \n 2 - Games \n 3 - Compras"));
        switch (option) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");
                if (sair > 0) {
                    menu();
                }
                System.out.println("Se sim, escolha: " + sair);
                break;
            case 1: 
                KeepClients.menu();
                break;
            case 2:
                KeepGames.menu();
                break;
            case 3:
                KeepPurchases.menu();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error - Invalid option");
                menu();
                break;
        }
    }
}
