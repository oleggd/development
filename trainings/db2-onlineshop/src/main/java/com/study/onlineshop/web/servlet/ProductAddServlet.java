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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAddServlet extends HttpServlet {

    private ProductService productService;
    private SecurityService securityService;
    private Map<String,String> activeTokens;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Cookie[] cookies = req.getCookies();
        boolean isAuth = false;
        PageGenerator pageGenerator = PageGenerator.instance();

        if (securityService.isAuthorized(securityService.getCurrentUser().getRole(),"add")) {
            String page = pageGenerator.getPage("product_add", null);
            resp.getWriter().write(page);
        } else {
            String page = pageGenerator.getPage("auth_err", null);
            resp.getWriter().write(page);
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        /*if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user-name")) {
                    if (activeTokens.containsKey(cookie.getName())) {
                        isAuth = true;//securityService.isAllowed(cookie.getValue(),"add");
                    }
                    break;
                }
            }
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product product = new Product();

        // get product for editing
        String name      = req.getParameter("name");
        LocalDateTime creationDate = LocalDateTime.parse(req.getParameter("creationDate"));
        double price     = Double.parseDouble(req.getParameter("price"));

        product.setName(name);
        product.setCreationDate(creationDate);
        product.setPrice(price);
        productService.add(product);

        resp.sendRedirect("/");
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setSecurityService(SecurityService securityService) { this.securityService = securityService; }

    public void setActiveTokens(Map<String,String> activeTokens) {
        this.activeTokens = activeTokens;
    }
}
