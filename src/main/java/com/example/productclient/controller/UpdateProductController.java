package com.example.productclient.controller;

import com.example.productclient.entity.Product;
import com.example.productclient.retrofit.RetrofitGenerator;
import com.example.productclient.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProductController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductService productService = RetrofitGenerator.createService(ProductService.class);
        Product p = productService.detail(id).execute().body();
        req.setAttribute("d", p);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("Id"));
        String Name = req.getParameter("Name");
        double Price = Double.parseDouble(req.getParameter("Price"));
        int Quantity = Integer.parseInt(req.getParameter("Quantity"));
        ProductService productService = RetrofitGenerator.createService(ProductService.class);
        productService.update(id,new Product(id,Name,Price,Quantity)).execute();
        resp.sendRedirect("/Liste");
    }

}