package com.study.onlineshop.dao;

import com.study.onlineshop.entity.User;

public interface UserDao {

    User getCurrentUser();

    void clearCurrentUser();

    User getUser(String name);

    public boolean isAuthenticated(String login, String password);

    boolean isAuthorized(String user, String object);

}
