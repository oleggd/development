package com.study.onlineshop;

import com.study.onlineshop.dao.jdbc.JdbcProductDao;
import com.study.onlineshop.service.impl.DefaultProductService;
import com.study.onlineshop.web.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) throws Exception {
        // configure daos
        JdbcProductDao jdbcProductDao = new JdbcProductDao();

        // configure services
        DefaultProductService defaultProductService = new DefaultProductService(jdbcProductDao);

        // store
        List<String> activeTokens = new ArrayList<>();

        // servlets
        ProductsServlet      productsServlet      = new ProductsServlet();
        ProductEditServlet   productEditServlet   = new ProductEditServlet();
        ProductAddServlet    productAddServlet    = new ProductAddServlet();
        ProductDeleteServlet productDeleteServlet = new ProductDeleteServlet();

        productsServlet.setProductService(defaultProductService);
        productsServlet.setActiveTokens(activeTokens);
        ProductsApiServlet productsApiServlet = new ProductsApiServlet(defaultProductService);
        productEditServlet.setProductService(defaultProductService);
        productEditServlet.setActiveTokens(activeTokens);
        productAddServlet.setProductService(defaultProductService);
        productAddServlet.setActiveTokens(activeTokens);
        productDeleteServlet.setProductService(defaultProductService);
        productDeleteServlet.setActiveTokens(activeTokens);

        // config web server
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //login
        //servletContextHandler.addServlet(new ServletHolder(productsApiServlet), "/api/v1/products");
        servletContextHandler.addServlet(new ServletHolder(new LoginServlet(activeTokens)), "/login");
        //other
        servletContextHandler.addServlet(new ServletHolder(productsServlet), "/products");
        servletContextHandler.addServlet(new ServletHolder(productsServlet), "/");
        servletContextHandler.addServlet(new ServletHolder(productEditServlet), "/product/edit");
        servletContextHandler.addServlet(new ServletHolder(productAddServlet), "/product/add");
        servletContextHandler.addServlet(new ServletHolder(productDeleteServlet), "/product/delete");

        Server server = new Server(8081);
        server.setHandler(servletContextHandler);
        server.start();
    }
}
