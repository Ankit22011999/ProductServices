package com.ankit.productservice.service;

import com.ankit.productservice.dto.CreateProductRequestDTO;
import com.ankit.productservice.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    public  Product getSingleProduct(long id);

//    Product createProduct(String title,String description,double price,String imageUrl,String category);

    Product createProduct(CreateProductRequestDTO createProductRequestDTO);
}
