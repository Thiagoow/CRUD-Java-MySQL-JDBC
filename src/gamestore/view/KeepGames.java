package gamestore.view;

import javax.swing.JOptionPane;
import gamestore.controller.GamesController;
import java.sql.SQLException;
import java.util.List;
import gamestore.model.bean.Games;

public class KeepGames {

    static GamesController gamesControl;

    public static void insert() throws SQLException, ClassNotFoundException {   
        String name = JOptionPane.showInputDialog("Nome");
        String value = JOptionPane.showInputDialog("Valor");
        String type = JOptionPane.showInputDialog("Tipo");
        Games gameEntry = new Games(name, value, type);

        gamesControl = new GamesController();
        Games gameOutput = gamesControl.insert(gameEntry);
        JOptionPane.showMessageDialog(null, gameOutput.toString());
    }

    public static void update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Nome");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
        String type = JOptionPane.showInputDialog("Tipo");
        Games gameEntry = new Games(id, nome, valor, type);

        gamesControl = new GamesController();
        Games gameOutput = gamesControl.update(gameEntry);
        JOptionPane.showMessageDialog(null, gameOutput.toString());
    }

    public static void search() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Games gameEntry = new Games(id);

        gamesControl = new GamesController();
        Games gameOutput = gamesControl.search(gameEntry);
        JOptionPane.showMessageDialog(null, gameOutput.toString());
    }

    public static void listar() throws SQLException, ClassNotFoundException {
        String name = JOptionPane.showInputDialog(null, "Bome");
        Games gameEntry = new Games(name);

        gamesControl = new GamesController();
        List<Games> listOutput = gamesControl.listar(gameEntry);
        for (Games ins : listOutput) {
            JOptionPane.showMessageDialog(null, ins.toString());
        }
    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Games gameEntry = new Games(id);
        
        gamesControl = new GamesController();
        Games gameOutput = gamesControl.excluir(gameEntry);
        JOptionPane.showMessageDialog(null, gameOutput.toString());
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        int option = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
        switch (option) {
            case 0:
               int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
               System.out.println("Se sim, escolha: " + sair);
               if(sair > 0) menu();
               break;
            case 1:
               insert();
               break;
           case 2:
               update();
               break;
           case 3:
               delete();
               break;
           case 4:
               search();
               break;
           case 5:
               list();
               break;
           default:
               JOptionPane.showMessageDialog(null,"Error - Invalid option");
               menu();
               break;
        }
    }
}
