package managerDB;

import connection.Connect;
import entity.Parameters;
import manager.ParametersManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DBFridgeParameterManager extends ParametersManager {
    private static final String INSERT = "INSERT INTO fridgeparameters (fridgeID, tFridge, tFreezer, defrost, power) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE fridgeparameters SET tFridge=?, tFreezer=?, defrost=?, power=? WHERE fridgeID=?";
    private static final String SELECT_PARAMETERS = "SELECT * FROM fridgeparameters";

    Connect connect = new Connect();

    Parameters parameters = new Parameters();

    public void add(int fridgeID, int tFridge, int tFreezer, int defrost, int power) {

        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(INSERT)) {

            preparedStatement.setInt(1, fridgeID);
            preparedStatement.setInt(2, tFridge);
            preparedStatement.setInt(3, tFreezer);
            preparedStatement.setInt(4, defrost);
            preparedStatement.setInt(5, power);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }

        System.out.println("INSERT");
    }

    public void edit(int fridgeID, int tFridge, int tFreezer, int defrost, int power) {
        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(UPDATE)) {

            preparedStatement.setInt(1, tFridge);
            preparedStatement.setInt(2, tFreezer);
            preparedStatement.setInt(3, defrost);
            preparedStatement.setInt(4, power);
            preparedStatement.setInt(5, fridgeID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

        System.out.println("UPDATE");
    }

    public Collection<Parameters> getAllParameters() {
        try(ResultSet result = connect.getConnection().createStatement().executeQuery(SELECT_PARAMETERS)){

            while (result.next()) {
                parameters.setFridgeID(result.getInt("fridgeID"));
                parameters.settFridge(result.getInt("tFridge"));
                parameters.settFreezer(result.getInt("tFreezer"));
                parameters.setDefrost(result.getInt("defrost"));
                parameters.setPower(result.getInt("power"));

                //System.out.println(parameters);

                setUser(parameters.getFridgeID(), parameters.gettFridge(), parameters.gettFreezer(),
                        parameters.getDefrost(), parameters.getPower());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return getList();
    }

    public void removeByFridgeID(Integer fridgeID) {
        try (Statement statement = connect.getConnection().createStatement()) {
            statement.execute("DELETE FROM fridge WHERE login" + fridgeID);

            System.out.println("Fridge - id - " + fridgeID + " is removed");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}