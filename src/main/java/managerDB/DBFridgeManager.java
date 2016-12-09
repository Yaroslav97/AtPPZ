package managerDB;

import connection.Connect;
import entity.Fridge;
import manager.FridgeManager;
import util.Password;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DBFridgeManager extends FridgeManager{
    private static final String INSERT_INTO_FRIDGES = "INSERT INTO fridges (idFridge, fullName, login, email, password) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_FRIDGES = "UPDATE fridges SET idFridge=?, fullName=?, login=?, email=?, password=? WHERE idFridge=?";
    private static final String UPDATE_PROFILE = "UPDATE fridges SET fullName=?, email=?, password=? WHERE login=?";
    private static final String UPDATE_PASSWORD = "UPDATE fridges SET password=? WHERE login=? AND email=?";
    private static final String SELECT_FRIDGES = "SELECT * FROM fridges";

    Connect connect = new Connect();

    Fridge fridge = new Fridge();

    public void add(int idFridge, String fullName, String login, String email, String password) {

        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(INSERT_INTO_FRIDGES)) {

            preparedStatement.setInt(1, idFridge);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void edit(int idFridge, String fullName, String login, String email, String password) {
        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(UPDATE_FRIDGES)) {

            preparedStatement.setInt(1, idFridge);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.setInt(6, idFridge);

            preparedStatement.executeUpdate();

            System.out.println("update");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editPassword(String password, String login, String email) {
        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(UPDATE_PASSWORD)) {

            preparedStatement.setString(1, Password.encodePassword(password));
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, email);

            preparedStatement.executeUpdate();

            System.out.println("update password");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editProfile(String login, String fullName, String email, String password) {
        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(UPDATE_PROFILE)) {

            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, Password.encodePassword(password));
            preparedStatement.setString(4, login);

            preparedStatement.executeUpdate();

            System.out.println("update profile");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Collection<Fridge> getAllList() {

        Statement statement = null;
        try {
            statement = connect.getConnection().createStatement();

            ResultSet result = statement.executeQuery(SELECT_FRIDGES);

            while (result.next()) {
                fridge.setIdFridge(result.getInt("idFridge"));
                fridge.setFullName(result.getString("fullName"));
                fridge.setLogin(result.getString("login"));
                fridge.setEmail(result.getString("email"));
                fridge.setPassword(result.getString("password"));

                System.out.println(fridge);

                setUser(fridge.getIdFridge(), fridge.getFullName(), fridge.getLogin(), fridge.getEmail(), fridge.getPassword());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return getList();
    }

    public void getByLogin(String login) {

        String query = "select * from fridges WHERE login='" + login + "';";

        try {
            Statement statement = connect.getConnection().createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                fridge.setIdFridge(result.getInt(2));
                fridge.setFullName(result.getString("fullName"));
                fridge.setLogin(result.getString("login"));
                fridge.setEmail(result.getString("getEmail"));
                fridge.setPassword(result.getString("password"));

                System.out.println(fridge);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeByLogin(String login) {
        try (Statement preparedStatement = connect.getConnection().createStatement()) {
            preparedStatement.execute("DELETE FROM fridge WHERE login='" + login + "'");

            System.out.println("Smart - login - " + login + " is removed");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}