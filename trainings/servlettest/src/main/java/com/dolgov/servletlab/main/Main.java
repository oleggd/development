package com.dolgov.servletlab.main;

import com.dolgov.servletlab.entity.Todo;
import com.dolgov.servletlab.servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        /*AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");
        context.addServlet(new ServletHolder(homePageServlet), "/index.html");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();*/

        // config store
        List<Todo> todoList = new ArrayList<>();
        todoList.add(new Todo(1, "Read documentation", LocalDate.of(2018, 10, 29), 5));
        todoList.add(new Todo(2, "Do home work", LocalDate.of(2018, 10, 30), 7));
        todoList.add(new Todo(3, "Test scripts", LocalDate.of(2018, 11, 01), 3));

        // config servlets
        TodoListServlet todoListServlet = new TodoListServlet(todoList);
        AddTaskServlet addTaskServlet = new AddTaskServlet(todoList);
        EditTaskServlet editTaskServlet = new EditTaskServlet(todoList);
        DeleteTaskServlet deleteTaskServlet = new DeleteTaskServlet(todoList);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(todoListServlet), "/todolist");
        context.addServlet(new ServletHolder(addTaskServlet), "/todolist/add");
        context.addServlet(new ServletHolder(editTaskServlet), "/todolist/edit");
        context.addServlet(new ServletHolder(deleteTaskServlet), "/todolist/delete");

        Server server = new Server(8081);
        server.setHandler(context);

        server.start();
    }
}
