package gamestore.model.bean;

public class Clients {
    private int id;
    private String username;
    private String password;
    private String name;
    private String cpf;
    private String email;

    public Clients(int id) {
        this.id = id;
    }

    public Clients(String name) {
        this.name = name;
    }

    public Clients(String username, String password, String name, String cpf, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Clients(int id, String username, String password, String name, String cpf, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", cpf=" + cpf + ", email=" + email + '}';
    }
}
