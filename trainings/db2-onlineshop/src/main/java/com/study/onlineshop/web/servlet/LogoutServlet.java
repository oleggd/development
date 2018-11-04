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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LogoutServlet extends HttpServlet {
    private Map<String,String> activeTokens;
    private SecurityService securityService;
    private List<User> activeUserList;

    public LogoutServlet(Map<String, String> activeTokens, SecurityService securityService, List<User> activeUserList) {
        this.activeTokens = activeTokens;
        this.securityService = securityService;
        this.activeUserList = activeUserList;
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

            // get cookies
            Cookie[] cookies = req.getCookies();
            String userName = securityService.getToken(cookies,"user-name");
            String userToken = securityService.getToken(cookies,"user-token");

            if (userName != null && userToken != null) {
                // remove it from activeTokens and userList
                activeTokens.remove(userName,userToken);
                activeUserList.remove(securityService.getUser(userName));
            }

            // clear cookies
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
        resp.sendRedirect("/login");
    }
}
