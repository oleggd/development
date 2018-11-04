package com.study.onlineshop.web.servlet;

import com.study.onlineshop.entity.Product;
import com.study.onlineshop.entity.User;
import com.study.onlineshop.service.ProductService;
import com.study.onlineshop.service.SecurityService;
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

public class ProductsServlet extends HttpServlet {
    private ProductService productService;
    private SecurityService securityService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User currentUser = securityService.getCurrentUser(req);

        PageGenerator pageGenerator = PageGenerator.instance();

        if (currentUser != null && securityService.isAuthorized(currentUser.getRole(),"products")) {
            List<Product> products = productService.getAll();

            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("products", products);

            String page = pageGenerator.getPage("products", parameters);
            resp.getWriter().write(page);
        } else {
            String page = pageGenerator.getPage("auth_err", null);
            resp.getWriter().write(page);
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

}
