package com.study.onlineshop.web.servlet;

import com.study.onlineshop.entity.Cart;
import com.study.onlineshop.entity.Product;
import com.study.onlineshop.entity.Session;
import com.study.onlineshop.service.ProductService;
import com.study.onlineshop.service.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

public class CartDeleteServlet extends HttpServlet {
    private SecurityService securityService;
    //private ProductService  productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int productID = Integer.parseInt(req.getParameter("id"));
        //Product product = productService.getProduct(productID);

        Cookie[] cookies = req.getCookies();
        Session session = securityService.getSession(cookies,"user-token");

        Cart cart = session.getCart();
        if ( cart == null) {
            cart = new Cart();
        }
        Iterator iterator = cart.getProducts().iterator();
        Product product = null;
        while (iterator.hasNext()) {
            product = (Product) iterator.next();
            if (product.getId() == productID) {
                iterator.remove();
            }
        }
        session.setCart(cart);

        System.out.println("cartDelete doGet : " + productID);

        resp.sendRedirect("/cart");
    }

    //public void setProductService(ProductService productService) {
    //    this.productService = productService;
    //}

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
}
