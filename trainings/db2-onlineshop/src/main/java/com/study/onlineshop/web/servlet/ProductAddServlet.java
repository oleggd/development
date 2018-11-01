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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class ProductAddServlet extends HttpServlet {

    private ProductService productService;
    private List<String> activeTokens;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        boolean isAuth = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user-token")) {
                    if (activeTokens.contains(cookie.getValue())) {
                        isAuth = true;
                    }
                    break;
                }
            }
        }

        if (isAuth) {
            PageGenerator pageGenerator = PageGenerator.instance();
            String page = pageGenerator.getPage("product_add", null);

            resp.getWriter().write(page);

        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
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

    public void setActiveTokens(List<String> activeTokens) {
        this.activeTokens = activeTokens;
    }
}
