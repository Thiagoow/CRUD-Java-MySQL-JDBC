package gamestore.model.bean;

public class Games {
    private int id;
    private String name;
    private double value;
    private String type;

    public Games(int id) {
        this.id = id;
    }
    
    public Games(String name) {
        this.name = name;
    }

    public Games(String name, double value, String type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public Games(int id, String name, double value, String type) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public Games(int aInt, String string, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", name=" + name + ", value=" + value + ", type=" + type + '}';
    }

    public String getLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
