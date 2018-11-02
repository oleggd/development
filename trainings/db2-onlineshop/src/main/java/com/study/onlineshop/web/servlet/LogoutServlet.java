package com.study.onlineshop.web.servlet;

import com.study.onlineshop.service.SecurityService;
import com.study.onlineshop.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LogoutServlet extends HttpServlet {
    private Map<String,String> activeTokens;
    private SecurityService securityService;

    public LogoutServlet(Map<String, String> activeTokens, SecurityService securityService) {
        this.activeTokens = activeTokens;
        this.securityService = securityService;
    }

    public LogoutServlet(Map<String,String> activeTokens) {
        this.activeTokens = activeTokens;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();

        if (securityService.isAuthorized(securityService.getCurrentUser().getRole(),"logout")) {

            resp.sendRedirect("/login");
            securityService.clearCurrentUser();
            activeTokens.clear();

            Cookie cookie = new Cookie("user-name", "");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);

            cookie = new Cookie("user-token", "");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);

        } else {
            String page = pageGenerator.getPage("auth_err", null);
            resp.getWriter().write(page);
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        System.out.println(login + " : " + password);

        // if user is valid
        if (securityService.isAuthenticated(login, password)) {

            Cookie cookie = new Cookie("user-name", login);
            activeTokens.put("user-name", login);
            resp.addCookie(cookie);

            // if user is valid
            String userToken = UUID.randomUUID().toString();
            cookie = new Cookie("user-token", userToken);
            activeTokens.put("user_token", userToken);

            resp.addCookie(cookie);
            resp.sendRedirect("/");
        } else {

            resp.sendRedirect("/login");
        }
    }
}
