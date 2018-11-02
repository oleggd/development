package com.study.onlineshop.service.impl;

import com.study.onlineshop.dao.UserDao;
import com.study.onlineshop.entity.User;
import com.study.onlineshop.service.SecurityService;

public class DefaultSecurityService implements SecurityService {
    private UserDao userDao;
    private User user;

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
    public User getCurrentUserByToken() {
        return null;
    }

    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
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
