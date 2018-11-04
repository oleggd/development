package com.study.onlineshop.web.servlet;

import com.study.onlineshop.entity.User;
import com.study.onlineshop.service.SecurityService;
import com.study.onlineshop.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class LoginServlet extends HttpServlet {
    private Map<String,String> activeTokens;
    private SecurityService securityService;
    List<User> activeUserList;


    public LoginServlet(Map<String, String> activeTokens, SecurityService securityService, List<User> activeUserList) {
        this.activeTokens = activeTokens;
        this.securityService = securityService;
        this.activeUserList = activeUserList;
    }

    public LoginServlet(Map<String,String> activeTokens) {
        this.activeTokens = activeTokens;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        HashMap<String, Object> parameters = new HashMap<>();

        String page = pageGenerator.getPage("login", parameters);
        resp.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        System.out.println(login + " : " + password);

        // if user is valid
        if (securityService.isAuthenticated(login, password)) {

            Cookie cookie = new Cookie("user-name", login);
            resp.addCookie(cookie);

            String userToken = UUID.randomUUID().toString();
            cookie = new Cookie("user-token", userToken);
            resp.addCookie(cookie);

            activeTokens.put(login, userToken);
            activeUserList.add(securityService.getUser(login));

            resp.sendRedirect("/");
        } else {

            resp.sendRedirect("/login");
        }
    }
}
