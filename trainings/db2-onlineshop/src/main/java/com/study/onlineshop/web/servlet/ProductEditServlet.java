package com.study.onlineshop.web.servlet;

import com.study.onlineshop.entity.Product;
import com.study.onlineshop.service.ProductService;
import com.study.onlineshop.service.SecurityService;
import com.study.onlineshop.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductEditServlet extends HttpServlet {

    private ProductService productService;
    private SecurityService securityService;
    private Map<String, String> activeTokens;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PageGenerator pageGenerator = PageGenerator.instance();

        System.out.println("Edit - current user :" + securityService.getCurrentUser());
        // security check
        if (securityService.isAuthorized(securityService.getCurrentUser().getRole(),"edit")) {

            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME.ofPattern("yyyy-MM-dd HH:mm:ss");	//2018-11-01T11:03
            HashMap<String, Object> parameters = new HashMap<>();
            Product product = new Product();

            // get product for editing
            String currentID = req.getParameter("id");
            String name      = req.getParameter("name");
            LocalDateTime    creationDate = LocalDateTime.parse(req.getParameter("creationDate"));
            double price     = Double.parseDouble(req.getParameter("price"));

            product.setId(Integer.parseInt(currentID));
            product.setName(name);
            product.setCreationDate(creationDate);
            product.setPrice(price);

            parameters.put("product", product);

            String page = pageGenerator.getPage("product_edit", parameters);
            resp.getWriter().write(page);
        } else {
            String page = pageGenerator.getPage("auth_err", null);
            resp.getWriter().write(page);
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        /*Cookie[] cookies = req.getCookies();
        boolean isAuth = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user-token")) {
                    *//*if (activeTokens.contains(cookie.getValue())) {
                        isAuth = true;
                    }*//*
                    break;
                }
            }
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product product = new Product();

        // get product for editing
        String currentID = req.getParameter("id");
        String name      = req.getParameter("name");
        LocalDateTime    creationDate = LocalDateTime.parse(req.getParameter("creationDate"));
        double price     = Double.parseDouble(req.getParameter("price"));

        product.setId(Integer.parseInt(currentID));
        product.setName(name);
        product.setCreationDate(creationDate);
        product.setPrice(price);
        productService.set(product);

        resp.sendRedirect("/");
    }


    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setActiveTokens(Map<String, String> activeTokens) {
        this.activeTokens = activeTokens;
    }

    public void setSecurityService(SecurityService securityService) { this.securityService = securityService;}

}
