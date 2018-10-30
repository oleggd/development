package com.dolgov.servletlab.servlets;

import com.dolgov.servletlab.dao.JdbcTodoDao;
import com.dolgov.servletlab.entity.Todo;
import com.dolgov.servletlab.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoListServlet extends HttpServlet {

    private List<Todo> todoList;
    private JdbcTodoDao jdbcTodo;


    public TodoListServlet(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public TodoListServlet(JdbcTodoDao jdbcTodo) {
        this.jdbcTodo = jdbcTodo;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        Map<String, Object> params = new HashMap<>();
        //params.put("todoList", todoList);
        params.put("todoList", jdbcTodo.getAll());

        String page = pageGenerator.getPage("todoList.html", params);
        System.out.println("sending page: " + page);
        resp.getWriter().write(page);
    }

}
