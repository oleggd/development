package com.study.onlineshop.dao.jdbc;

import com.study.onlineshop.dao.UserDao;
import com.study.onlineshop.dao.jdbc.mapper.UserRowMapper;
import com.study.onlineshop.entity.User;

import java.sql.*;
import java.util.Properties;

public class JdbcUserDao implements UserDao {

    String url = "";//"jdbc:postgresql://localhost/db2_onlineshop";
    String name = "";//"postgres";
    String password = "";//"1234";

    private User user;

    private static final String GET_USER_SQL = "SELECT id, name, creation_date, role FROM users WHERE name = ?";
    private static final String GET_LOGIN_SQL = "SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END is_authorized FROM users WHERE name = ? AND password = ?";
    private static final String GET_PERMISSION_SQL = "SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END is_allowed FROM permissions WHERE role = ? AND object = ?;";

    private static final UserRowMapper USER_ROW_MAPPER = new UserRowMapper();

    public void setConnectionParameters(Properties properties) {
        this.url = properties.getProperty("url");
        this.name = properties.getProperty("user");
        this.password = properties.getProperty("password");
    }

    public User getCurrentUser(){
        return user;
    }

    @Override //"SELECT id, name, creation_date, role FROM user WHERE name = ?"
    public User getUser(String name) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER_SQL);
            ) {
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            user = new User();
            while (resultSet.next()) {
                user = USER_ROW_MAPPER.mapRow(resultSet);
            }

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Override //"SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END is_authorized FROM user WHERE user = ? AND password = ?";
    public boolean isAuthenticated(String login, String password) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_LOGIN_SQL);
        ) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString("is_authorized").equals("Y")) {
                    user = getUser(login);
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override //"SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END IS_ALLOWED FROM PERMISSIONS WHERE ROLE = ? AND OBJECT = ?;";
    public boolean isAuthorized(String role, String object) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PERMISSION_SQL);
            ) {
            statement.setString(1, role);
            statement.setString(2, object);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString("is_allowed").equals("Y")) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }
}
