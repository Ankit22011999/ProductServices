package com.ankit.productservice.service;

import com.ankit.productservice.dto.CreateProductRequestDTO;
import com.ankit.productservice.exception.ProductNotFoundException;
import com.ankit.productservice.model.Product;
import com.ankit.productservice.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    public  Product getSingleProduct(long id) throws ProductNotFoundException;

//    Product createProduct(String title,String description,double price,String imageUrl,String category);

    Product createProduct(
                          String title,
                          String description,
                          double price ,
//                          Rating rating,
                          String imageUrl
    );
//    @GetMapping("/products/Category"
    List<Product> getCategory(String category);
}
