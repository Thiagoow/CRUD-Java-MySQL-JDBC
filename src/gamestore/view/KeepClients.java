package gamestore.view;

import gamestore.controller.ClientsController;
import gamestore.model.bean.Clients;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class KeepClients {
    static ClientsController clientControl;
    
    public static void delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Clients entry = new Clients(id);
        clientControl = new ClientsController();
        Clients clientEntry = clientControl.delete(entry);
        JOptionPane.showMessageDialog(null, clientEntry.toString());
    }

    public static void update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String username = JOptionPane.showInputDialog("Username");
        String password = JOptionPane.showInputDialog("Senha");
        String name = JOptionPane.showInputDialog("Nome");
        String cpf = JOptionPane.showInputDialog("Cpf");
        String email = JOptionPane.showInputDialog("Email");
        Clients entry = new Clients(id, username, password, name, cpf, email);
        clientControl = new ClientsController();
        Clients output = clientControl.update(entry);
        JOptionPane.showMessageDialog(null, output.toString());
    }

    public static void list() throws SQLException, ClassNotFoundException {
        try {
            String nome = JOptionPane.showInputDialog("Nome");
            Clients entry = new Clients(nome);
            clientControl = new ClientsController();
            List<Clients> output = clientControl.list(entry);

            for(Clients cl : output) {
                JOptionPane.showMessageDialog(null, cl.toString());
            }
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void search() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Clients pfEntrada = new Clients(id);
        clientControl = new ClientsController();
        Clients clSaida = clientControl.search(pfEntrada);
        JOptionPane.showMessageDialog(null, clSaida.toString());
    }

    public static void insert() throws SQLException, ClassNotFoundException {
        String username = JOptionPane.showInputDialog("Username");
        String password = JOptionPane.showInputDialog("Senha");    
        String name = JOptionPane.showInputDialog("Nome");
        String cpf = JOptionPane.showInputDialog("Cpf");
        String email = JOptionPane.showInputDialog("Email");
        Clients clientEntry = new Clients(username,password,name,cpf,email );

        clientControl = new ClientsController();
        Clients clientOutput = clientControl.insert(clientEntry);
        JOptionPane.showMessageDialog(null, clientOutput.toString());
    }
    
    public static boolean validate() throws SQLException, ClassNotFoundException {
        boolean validatedUser;
        String username = JOptionPane.showInputDialog("Username");
        String password = JOptionPane.showInputDialog("Senha");
        Clients userEntry = new Clients(username, password);

        clientControl = new ClientsController();
        validatedUser = clientControl.validate(userEntry);
        JOptionPane.showMessageDialog(null, "Cliente: " + validatedUser);
        return validatedUser;
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        int option = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
        switch (option) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");
                System.out.println("Se sim, escolha: " + sair);
                if (sair > 0) menu();
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
                JOptionPane.showMessageDialog(null, "Error - Invalid option");
                menu();
                break;
        }
    }
}