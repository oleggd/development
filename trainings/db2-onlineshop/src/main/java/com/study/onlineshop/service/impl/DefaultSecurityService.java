package com.study.onlineshop.service.impl;

import com.study.onlineshop.dao.UserDao;
import com.study.onlineshop.entity.User;
import com.study.onlineshop.service.SecurityService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class DefaultSecurityService implements SecurityService {
    private UserDao userDao;
    private User user;

    private Map<String,String> activeTokens;
    private SecurityService securityService;
    List<User> activeUserList;

    public void setActiveUserInfo(Map<String, String> activeTokens, List<User> activeUserList) {
        this.activeTokens = activeTokens;
        this.activeUserList = activeUserList;
    }

    public DefaultSecurityService(UserDao UserDao) {
        this.userDao = UserDao;
    }

    @Override
    public void clearCurrentUser() {
        userDao.clearCurrentUser();
    }

    @Override
    public User getCurrentUser() {
        return userDao.getCurrentUser();
    }

    @Override
    public User getCurrentUserByToken(String userName, String userToken) {

        if (activeTokens.containsKey(userName) && activeTokens.containsValue(userToken)) {
            for (User activeUser : activeUserList) {
                if (activeUser.getName() == userName) {
                    return activeUser;
                }
            }
        }
        return null;
    }

    @Override
    public User getCurrentUser(HttpServletRequest req) {
        // get cookies
        Cookie[] cookies = req.getCookies();
        String userName = getToken(cookies,"user-name");
        String userToken = getToken(cookies,"user-token");

        if (activeTokens.containsKey(userName) && activeTokens.containsValue(userToken)) {
            for (User activeUser : activeUserList) {
                if (activeUser.getName().equals(userName)) {
                    return activeUser;
                }
            }
        }
        return null;
    }

    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
    }

    public String getToken (Cookie[] cookies, String tokenName) {

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(tokenName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isAuthenticated(String login, String password) {
        return userDao.isAuthenticated(login, password);
    }

    @Override
    public boolean isAuthorized(String login, String password) {
        return userDao.isAuthorized(login, password);
    }

    //@Override
    /*public boolean isAuthorized(User user, String object) {
        return userDao.isAuthorized(user, object);
    }*/
}
