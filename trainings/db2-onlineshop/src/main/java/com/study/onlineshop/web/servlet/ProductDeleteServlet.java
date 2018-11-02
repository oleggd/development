package com.study.onlineshop.web.servlet;

import com.study.onlineshop.entity.Product;
import com.study.onlineshop.service.ProductService;
import com.study.onlineshop.service.SecurityService;
import com.study.onlineshop.service.impl.DefaultSecurityService;
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

public class ProductDeleteServlet extends HttpServlet {
    private ProductService productService;
    private SecurityService securityService;
    private Map<String, String> activeTokens;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PageGenerator pageGenerator = PageGenerator.instance();

        /*Cookie[] cookies = req.getCookies();
        boolean isAuth = false;

        /*if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user-token")) {
                    if (activeTokens.contains(cookie.getValue())) {
                        isAuth = true;
                    }
                    break;
                }
            }
        }*/

        if (securityService.isAuthorized(securityService.getCurrentUser().getRole(),"delete")) {

            Integer productID = Integer.parseInt(req.getParameter("id"));
        System.out.println("doGet : " + productID);
            productService.removeById(productID);

            resp.sendRedirect("/");

        } else {
            String page = pageGenerator.getPage("auth_err", null);
            resp.getWriter().write(page);
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();

        if (securityService.isAuthorized(securityService.getCurrentUser().getRole(),"delete")) {

       resp.sendRedirect("/product/delete");

        } else {
            String page = pageGenerator.getPage("auth_err", null);
            resp.getWriter().write(page);
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setActiveTokens(Map<String, String> activeTokens) {
        this.activeTokens = activeTokens;
    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
}
