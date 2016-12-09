package entity;

public class Fridge {
    private int id;
    private int idFridge;
    private String fullName;
    private String login;
    private String email;
    private String password;

    public Fridge() {
    }

    public Fridge(int id, int idFridge, String fullName, String login, String email, String password) {
        this.id = id;
        this.idFridge = idFridge;
        this.fullName = fullName;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Fridge(int idFridge, String fullName, String login, String email, String password) {
        this.idFridge = idFridge;
        this.fullName = fullName;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public int getIdFridge() {
        return idFridge;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdFridge(int idFridge) {
        this.idFridge = idFridge;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Smart{" +
                "idFridge=" + idFridge +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}