package com.dolgov.servletlab.servlets;

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

    List<Todo> todoList;
    Todo       currentTodo;

    public DeleteTaskServlet(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentID = req.getParameter("id");

        Integer todoID = Integer.parseInt(currentID);
        Iterator<Todo> iterator = todoList.iterator();

        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if ( todoID.equals(todo.getId())) {
                iterator.remove();
                //todoList.remove(todoID);//currentTodo = todo;//
                break;
            }
        }
        resp.sendRedirect("/todolist");
        //resp.setStatus(202);//getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        todoList.remove(currentTodo);

        resp.sendRedirect("/todolist");
    }

}