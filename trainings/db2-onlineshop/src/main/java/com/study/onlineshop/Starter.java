package com.study.onlineshop;

import com.study.onlineshop.dao.jdbc.JdbcProductDao;
import com.study.onlineshop.dao.jdbc.JdbcUserDao;
import com.study.onlineshop.entity.User;
import com.study.onlineshop.service.impl.DefaultProductService;
import com.study.onlineshop.service.impl.DefaultSecurityService;
import com.study.onlineshop.web.filters.AdminSecurityFilter;
import com.study.onlineshop.web.filters.ProductSecurityFilter;
import com.study.onlineshop.web.filters.UserSecurityFilter;
import com.study.onlineshop.web.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.io.FileInputStream;
import java.util.*;

public class Starter {
    public static void main(String[] args) throws Exception {
        // configure daos
        JdbcProductDao jdbcProductDao = new JdbcProductDao();
        JdbcUserDao    jdbcUserDao    = new JdbcUserDao();

        String filename = "app.properties";
        Properties appProps = new Properties();
        //appProps.load(Starter.class.getClass().getClassLoader().getResourceAsStream(filename));
        appProps.load(Starter.class.getClassLoader().getResourceAsStream(filename));
        jdbcUserDao.setConnectionParameters(appProps);

        // configure services
        DefaultProductService defaultProductService = new DefaultProductService(jdbcProductDao);
        DefaultSecurityService defaultSecurityService = new DefaultSecurityService(jdbcUserDao);

        // store user-name + user-token
        List<User> activeUserList = new ArrayList<>();
        Map<String,String> activeTokens = new HashMap<>();

        // servlets
        LoginServlet         loginServlet         = new LoginServlet(activeTokens, defaultSecurityService, activeUserList);
        LogoutServlet        logoutServlet        = new LogoutServlet(activeTokens, defaultSecurityService, activeUserList);
        ProductsServlet      productsServlet      = new ProductsServlet();
        ProductEditServlet   productEditServlet   = new ProductEditServlet();
        ProductAddServlet    productAddServlet    = new ProductAddServlet();
        ProductDeleteServlet productDeleteServlet = new ProductDeleteServlet();

        //
        //defaultSecurityService.setActiveUserInfo(activeTokens,activeUserList);
        //
        productsServlet.setProductService(defaultProductService);
        productsServlet.setSecurityService(defaultSecurityService);
        //ProductsApiServlet productsApiServlet = new ProductsApiServlet(defaultProductService);
        productEditServlet.setProductService(defaultProductService);
        productAddServlet.setProductService(defaultProductService);
        productDeleteServlet.setProductService(defaultProductService);

        // config web server
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //login
        //servletContextHandler.addServlet(new ServletHolder(productsApiServlet), "/api/v1/products");
        servletContextHandler.addServlet(new ServletHolder(loginServlet), "/login");
        FilterHolder userHolder = new FilterHolder(new UserSecurityFilter(defaultSecurityService));
        servletContextHandler.addFilter(userHolder, "/logout",EnumSet.of(DispatcherType.REQUEST));
        servletContextHandler.addServlet(new ServletHolder(logoutServlet), "/logout");
        //other
        FilterHolder productHolder = new FilterHolder(new ProductSecurityFilter(defaultSecurityService));
        servletContextHandler.addFilter(productHolder, "/products",EnumSet.of(DispatcherType.REQUEST));
        servletContextHandler.addServlet(new ServletHolder(productsServlet), "/products");
        //servletContextHandler.addServlet(new ServletHolder(productsServlet), "/");
        FilterHolder adminHolder = new FilterHolder(new AdminSecurityFilter(defaultSecurityService));
        //servletContextHandler.addFilter(adminHolder, "/products",EnumSet.of(DispatcherType.REQUEST));
        servletContextHandler.addFilter(adminHolder, "/product/edit",EnumSet.of(DispatcherType.REQUEST));
        servletContextHandler.addFilter(adminHolder, "/product/add",EnumSet.of(DispatcherType.REQUEST));
        servletContextHandler.addFilter(adminHolder, "/product/delete",EnumSet.of(DispatcherType.REQUEST));
        servletContextHandler.addServlet(new ServletHolder(productEditServlet), "/product/edit");
        servletContextHandler.addServlet(new ServletHolder(productAddServlet), "/product/add");
        servletContextHandler.addServlet(new ServletHolder(productDeleteServlet), "/product/delete");

        Server server = new Server(8081);
        server.setHandler(servletContextHandler);
        server.start();
    }
}
