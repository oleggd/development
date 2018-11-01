package com.dolgov.servletlab.dao;

import com.dolgov.servletlab.entity.Todo;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JdbcTodoDao {

    private String url = "jdbc:postgresql://localhost:5432/mydb";
    private String user = "postgres";
    private String password = "1234";

    private static final String ADD_TODO_SQL_PREFIX = "INSERT INTO todo_list (name, dueDate, priority)  VALUES ";
    private static final String GET_ALL_SQL = "SELECT id, name, due_date, priority FROM  todo_list ORDER BY id;";

    private static final String ADD_TODO_SQL = "INSERT INTO todo_list (id, name, due_date, priority)  VALUES (nextval('public.todo_list_id_seq'),?, ?, ?);";
    private static final String SET_TODO_SQL = "UPDATE todo_list SET name = ?, due_date = ?, priority = ?  WHERE id = ?;";
    private static final String REMOVE_TODO_SQL = "DELETE FROM todo_list WHERE id = ?;";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<Todo> getAll() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);) {

            List<Todo> todos = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int priority = resultSet.getInt("priority");
                String dueDateTimestamp = resultSet.getString("due_date");
                LocalDate dueDate = LocalDate.parse(dueDateTimestamp, DATE_TIME_FORMATTER);


                Todo todo = new Todo(id, name, dueDate, priority);
                todos.add(todo);

            }
            return todos;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

//    void add(Todo todo) {
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement();) {
//            String sql = ADD_TODO_SQL_PREFIX + "( '" + todo.getName() + "', '" + todo.getDueDate() + "', " + todo.getPriority() + ");";
//            System.out.println("executing sql: " + sql);
//            statement.executeUpdate(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }

    //  "INSERT INTO todo_list (name, dueDate, priority)  VALUES (?, ?, ?);";
    public void add(Todo todo) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_TODO_SQL);) {

            statement.setString(1, todo.getName());
            statement.setObject(2, Date.valueOf(todo.getDueDate()));
            statement.setInt(3, todo.getPriority());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // "UPDATE todo_list SET name = ?, due_date = ?, priority = ?  WHERE id = ?;"
    public void set(Todo todo) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SET_TODO_SQL);) {
            statement.setString(1, todo.getName());
            statement.setObject(2, Date.valueOf(todo.getDueDate()));
            statement.setInt(3, todo.getPriority());
            statement.setInt(4, todo.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //"DELETE FROM todo_list WHERE id = ?;"
    public void removeById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_TODO_SQL);) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {

        //String url = "jdbc:postgresql://localhost:5432/mydb";
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }
}