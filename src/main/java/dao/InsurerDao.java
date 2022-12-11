package dao;

import model.Insurance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InsurerDao {
    private static final String FIND_ALL_INSURANCE_QUERY = "SELECT * from RecruitmentExercise.insurance_offers where user__id = ?";
    public List<Insurance> findAll(Integer userId) {
        List<Insurance> allInsuranceThisVehicle = new ArrayList<>();
        try (Connection connection = DbUtil.connect()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_INSURANCE_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            {
                while (resultSet.next()) {
                    Insurance insurance = new Insurance();
                    insurance.setVehicleId(resultSet.getInt("vehicle_id"));
                    insurance.setInsurer(resultSet.getString("insurer"));
                    insurance.setPrice(resultSet.getFloat("price"));
                    insurance.setInsertTime(resultSet.getString("insert_time"));
                    allInsuranceThisVehicle.add(insurance);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allInsuranceThisVehicle;
    }
}
