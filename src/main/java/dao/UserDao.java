package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static final String READ_USER_QUERY = "SELECT * from RecruitmentExercise.users where id = ?";

    public User read(Integer userId) {
        User user = new User();
        try (Connection connection = DbUtil.connect()) {
            PreparedStatement statement = connection.prepareStatement(READ_USER_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setNick(resultSet.getString("nick"));
                    user.setPassword(resultSet.getString("password"));
                    user.setLogin(resultSet.getString("login"));
                    user.setInsertTime(resultSet.getString("insert_time"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    public String checkPassword(Integer id) {
        try (Connection connection = DbUtil.connect()) {
            PreparedStatement statement = connection.prepareStatement(READ_USER_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                return password;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
