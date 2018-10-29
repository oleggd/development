package com.dolgov.servletlab.servlets;

import com.dolgov.servletlab.entity.Todo;
import com.dolgov.servletlab.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class EditTaskServlet extends HttpServlet {

    List<Todo> todoList;
    int nextId = 1;

    public EditTaskServlet(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentID = req.getParameter("id");
        String name = req.getParameter("name");
        int priority = Integer.parseInt(req.getParameter("priority"));

        Map<String, Object> params = new HashMap<>();
        Todo todo = new Todo(Integer.parseInt(currentID), name, LocalDate.now().plusDays(1), priority);

        params.put("todo",todo);

        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("editTask.html", params);

        resp.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer todoID = Integer.parseInt(req.getParameter("id"));;
        String name    = req.getParameter("name");
        int priority   = Integer.parseInt(req.getParameter("priority"));


        Todo updatedTodo = new Todo(todoID, name, LocalDate.now().plusDays(1), priority);
        //ListIterator<String> iterator = list.listIterator();
        ListIterator<Todo> iterator = todoList.listIterator();

        while (iterator.hasNext()) {
            Todo currentTodo = iterator.next();
            if ( todoID.equals(currentTodo.getId())) {
                iterator.set(updatedTodo);
                //todoList.remove(todoID);//currentTodo = todo;//
                break;
            }
        }

        resp.sendRedirect("/todolist");
    }

}