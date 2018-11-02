package com.study.onlineshop.service;

import com.study.onlineshop.entity.User;

public interface SecurityService {

   void clearCurrentUser();

   User getCurrentUser();

   User getCurrentUserByToken();

   User getUser(String name);

   boolean isAuthenticated(String login, String password);

   boolean isAuthorized(String user, String object);

}
