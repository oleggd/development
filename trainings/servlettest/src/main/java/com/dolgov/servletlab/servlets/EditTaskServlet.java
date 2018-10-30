package com.dolgov.servletlab.servlets;

import com.dolgov.servletlab.dao.JdbcTodoDao;
import com.dolgov.servletlab.entity.Todo;
import com.dolgov.servletlab.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EditTaskServlet extends HttpServlet {

    List<Todo> todoList;
    private JdbcTodoDao jdbcTodo;

    public EditTaskServlet(List<Todo> todoList) {
        this.todoList = todoList;
    }
    public EditTaskServlet(JdbcTodoDao jdbcTodo) { this.jdbcTodo = jdbcTodo;}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentID = req.getParameter("id");
        String name = req.getParameter("name");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //convert String to LocalDate
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"), formatter);
        int priority = Integer.parseInt(req.getParameter("priority"));

        Map<String, Object> params = new HashMap<>();
        Todo todo = new Todo(Integer.parseInt(currentID), name, dueDate, priority);

        params.put("todo",todo);

        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("editTask.html", params);

        resp.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer todoID = Integer.parseInt(req.getParameter("id"));;
        String name    = req.getParameter("name");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //convert String to LocalDate
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"), formatter);
        int priority   = Integer.parseInt(req.getParameter("priority"));

        Todo updatedTodo = new Todo(todoID, name, dueDate, priority);

        jdbcTodo.set(updatedTodo);
        resp.sendRedirect("/todolist");
    }

}