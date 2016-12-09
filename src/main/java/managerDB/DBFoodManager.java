package managerDB;

import connection.Connect;
import entity.Food;
import manager.FoodManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DBFoodManager extends FoodManager{

    private static final String INSERT_INTO_FOOD = "INSERT INTO foods (nameFood, currentlyDate, endDate, note) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_FOOD = "UPDATE foods SET nameFood=?, currentlyDate=?, endDate=?, note=? WHERE nameFood=?";
    private static final String SELECT_FOOD = "SELECT * FROM foods;";

    Connect connect = new Connect();

    Food food = new Food();

    public void add(String nameFood, String currentlyDate, String endDate, String note) {

        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(INSERT_INTO_FOOD)) {

            preparedStatement.setString(1, nameFood);
            preparedStatement.setString(2, currentlyDate);
            preparedStatement.setString(3, endDate);
            preparedStatement.setString(4, note);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void edit(String fullName, String login, String email, String password) {
        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(UPDATE_FOOD)) {

            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, login);

            preparedStatement.executeUpdate();

            System.out.println("update");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Collection<Food> getAllList() {

        Statement statement = null;
        try {
            statement = connect.getConnection().createStatement();

            ResultSet result = statement.executeQuery(SELECT_FOOD);

            while (result.next()) {
                food.setFoodName(result.getString("nameFood"));
                food.setCurrentlyDate(result.getString("currentlyDate"));
                food.setEndDate(result.getString("endDate"));
                food.setNote(result.getString("note"));

                System.out.println(food);

                setUser(food.getFoodName(), food.getCurrentlyDate(), food.getEndDate(), food.getNote());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return getList();
    }

    public void getByLogin(String nameFood) {

        String query = "select * from foods WHERE login='" + nameFood + "';";

        try {
            Statement statement = connect.getConnection().createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                food.setFoodName(result.getString(2));
                food.setCurrentlyDate(result.getString("currentlyDate"));
                food.setEndDate(result.getString("endDate"));
                food.setNote(result.getString("note"));
                System.out.println(food);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeByLogin(String foodName) {
        try (Statement preparedStatement = connect.getConnection().createStatement();) {
            preparedStatement.execute("DELETE FROM fridge WHERE login='" + foodName + "'");

            System.out.println("Smart - login - " + foodName + " is removed");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
