package com.dolgov.servletlab.servlets;

import com.dolgov.servletlab.entity.Todo;
import com.dolgov.servletlab.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddTaskServlet extends HttpServlet {

    List<Todo> todoList;
    int nextId = 1;

    public AddTaskServlet(List<Todo> todoList) {
        this.todoList = todoList;
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
        Todo todo = new Todo(todoList.size()+1, name, dueDate, priority);
        todoList.add(todo);

        resp.sendRedirect("/todolist");
    }

}