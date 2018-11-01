package com.study.onlineshop.web.servlet;

import com.study.onlineshop.entity.Product;
import com.study.onlineshop.service.ProductService;
import com.study.onlineshop.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ProductDeleteServlet extends HttpServlet {
    private ProductService productService;
    private List<String> activeTokens;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
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

        //if (isAuth) {
            Integer productID = Integer.parseInt(req.getParameter("id"));
        System.out.println("doGet : " + productID);
            productService.removeById(productID);

            resp.sendRedirect("/");

        /*} else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }*/


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost : /product/delete" );

       resp.sendRedirect("/product/delete");
    }
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setActiveTokens(List<String> activeTokens) {
        this.activeTokens = activeTokens;
    }
}
