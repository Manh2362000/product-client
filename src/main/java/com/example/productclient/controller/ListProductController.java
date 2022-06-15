package com.example.productclient.controller;

import com.example.productclient.entity.Product;
import com.example.productclient.retrofit.RetrofitGenerator;
import com.example.productclient.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("liste");
        ProductService productService = RetrofitGenerator.createService(ProductService.class);
        List<Product> liste = productService.getlist().execute().body();
        req.setAttribute("l", liste);
        req.getRequestDispatcher("/liste.jsp").forward(req,resp);
    }
}