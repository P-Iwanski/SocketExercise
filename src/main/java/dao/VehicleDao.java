package dao;

import model.User;
import model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private static final String FIND_ALL_VEHICLES_QUERY = "SELECT * from RecruitmentExercise.vehicles where user_id = ?";
    public List<Vehicle> findAll(Integer userID) {
        List<Vehicle> allVehiclesThisId = new ArrayList<>();
        InsurerDao insurerDao = new InsurerDao();

        try (Connection connection = DbUtil.connect()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_VEHICLES_QUERY);
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            {
                while (resultSet.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(resultSet.getInt("id"));
                    vehicle.setBrand(resultSet.getString("brand"));
                    vehicle.setUserId(resultSet.getInt("user_id"));
                    vehicle.setUserLogin(resultSet.getString("user_login"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setInsertTime(resultSet.getString("insert_time"));
                    allVehiclesThisId.add(vehicle);
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return allVehiclesThisId;
    }
}
