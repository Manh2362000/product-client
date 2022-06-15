package com.example.productclient.service;

import com.example.productclient.entity.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductService {
    @GET("/api/product")
    public Call<List<Product>> getlist();

    @POST("/api/product")
    public Call<Product> add(@Body Product product);

    @GET("/api/product/{id}")
    public Call<Product> detail(@Path("id") int id);

    @PUT("/api/product/{id}")
    public Call<Product> update(@Path("id")int id,@Body Product product);
}