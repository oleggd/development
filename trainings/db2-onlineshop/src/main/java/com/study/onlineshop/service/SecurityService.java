package com.study.onlineshop.service;

import com.study.onlineshop.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public interface SecurityService {

   void clearCurrentUser();

   User getCurrentUser();

   User getCurrentUserByToken(String userName, String userToken);

   User getCurrentUser(HttpServletRequest req);

   User getUser(String name);

   String getToken (Cookie[] cookies, String tokenName);

   boolean isAuthenticated(String login, String password);

   boolean isAuthorized(String user, String object);

}
