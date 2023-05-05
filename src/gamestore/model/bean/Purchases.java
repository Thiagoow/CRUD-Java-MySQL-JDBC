package gamestore.model.bean;

public class Purchases {
    private int id;
    private double total_value;
    private int id_games;
    private int id_customers;
    
    public Purchases(int id) {
        this.id = id;
    }

    public Purchases(double total_value, int id_games, int id_customers) {
        this.total_value = total_value;
        this.id_games = id_games;
        this.id_customers = id_customers;
    }

    public Purchases(int id, double total_value, int id_games, int id_customers) {
        this.id = id;
        this.total_value = total_value;
        this.id_games = id_games;
        this.id_customers = id_customers;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getTotal_value() {
        return total_value;
    }
    public void setTotal_value(double total_value) {
        this.total_value = total_value;
    }

    public int getId_games() {
        return id_games;
    }
    public void setId_games(int id_games) {
        this.id_games = id_games;
    }

    public int getId_customers() {
        return id_customers;
    }
    public void setId_customers(int id_customers) {
        this.id_customers = id_customers;
    }

    @Override
    public String toString() {
        return "Purchases{" + "id=" + id + ", total_value=" + total_value + ", id_games=" + id_games + ", id_customers=" + id_customers}';
    }
}
