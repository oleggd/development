package com.dolgov.servletlab.servlets;

import com.dolgov.servletlab.dao.JdbcTodoDao;
import com.dolgov.servletlab.entity.Todo;
import com.dolgov.servletlab.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class DeleteTaskServlet extends HttpServlet {

    private List<Todo>  todoList;
    private Todo        currentTodo;
    private JdbcTodoDao jdbcTodo;

    public DeleteTaskServlet(List<Todo> todoList) {
        this.todoList = todoList;
    }
    public DeleteTaskServlet(JdbcTodoDao jdbcTodo) { this.jdbcTodo = jdbcTodo;}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentID = req.getParameter("id");

        Integer todoID = Integer.parseInt(currentID);
        /*Iterator<Todo> iterator = todoList.iterator();

        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if ( todoID.equals(todo.getId())) {
                iterator.remove();
                //todoList.remove(todoID);//currentTodo = todo;//
                break;
            }
        }*/
        jdbcTodo.removeById(todoID);
        resp.sendRedirect("/todolist");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        todoList.remove(currentTodo);

        resp.sendRedirect("/todolist");
    }

}