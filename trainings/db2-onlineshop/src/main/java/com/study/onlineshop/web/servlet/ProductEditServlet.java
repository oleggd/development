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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

public class ProductEditServlet extends HttpServlet {

    private ProductService productService;
    private List<String> activeTokens;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // security check
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
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME.ofPattern("yyyy-MM-dd HH:mm:ss");	//2018-11-01T11:03
            HashMap<String, Object> parameters = new HashMap<>();
            Product product = new Product();

            // get product for editing
            String currentID = req.getParameter("id");
            String name      = req.getParameter("name");
            LocalDateTime    creationDate = LocalDateTime.parse(req.getParameter("creationDate"));
            double price     = Double.parseDouble(req.getParameter("price"));

            //Product product = new Product(Integer.parseInt(currentID), name, creationDate, price);
            product.setId(Integer.parseInt(currentID));
            product.setName(name);
            //Timestamp creationDate = resultSet.getTimestamp("creation_date");
            //product.setCreationDate(creationDate.toLocalDateTime());
            product.setCreationDate(creationDate);
            product.setPrice(price);

            parameters.put("product", product);

            String page = pageGenerator.getPage("product_edit", parameters);
            resp.getWriter().write(page);

        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
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

    public void setActiveTokens(List<String> activeTokens) {
        this.activeTokens = activeTokens;
    }
}
