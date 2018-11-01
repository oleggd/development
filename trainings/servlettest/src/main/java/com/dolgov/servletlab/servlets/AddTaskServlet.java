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
import java.util.List;

public class AddTaskServlet extends HttpServlet {

    List<Todo> todoList;
    private JdbcTodoDao jdbcTodo;

    public AddTaskServlet(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public AddTaskServlet(JdbcTodoDao jdbcTodo) {
        this.jdbcTodo = jdbcTodo;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("addTask.html", null);

        resp.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //convert String to LocalDate
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"), formatter);

        int priority = Integer.parseInt(req.getParameter("priority"));
        Todo todo = new Todo(/*todoList.size()+1,*/ name, dueDate, priority);
        jdbcTodo.add(todo);

        resp.sendRedirect("/todolist");
    }

}