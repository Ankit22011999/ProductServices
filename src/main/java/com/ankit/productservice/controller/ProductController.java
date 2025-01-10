package com.ankit.productservice.controller;
import com.ankit.productservice.dto.CreateProductRequestDTO;
import com.ankit.productservice.dto.ErrorDtos;
import com.ankit.productservice.exception.ProductNotFoundException;
import com.ankit.productservice.model.Product;
import com.ankit.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final View error;
    public ProductService productService;

    public ProductController(ProductService productService, View error) {
        this.productService = productService;
        this.error = error;
    }
    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products =productService.getAllProducts();
        return products;
    }


    @GetMapping("/products/category/{category}")
    public List<Product> getCategoryProduct(@PathVariable("category") String category) {
        return productService.getCategory(category);
    }


    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
       return productService.getSingleProduct(id);
    }


    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO) {
        return productService.createProduct(
                                            createProductRequestDTO.getTittle(),
                                            createProductRequestDTO.getDescription(),
                                            createProductRequestDTO.getPrice(),
                                            createProductRequestDTO.getImageUrl());
    }
//
//@ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDtos> handleProductNotFoundExpection(ProductNotFoundException productNotFoundException) {
//        ErrorDtos errorDtos = new ErrorDtos();
//        errorDtos.setMessage(productNotFoundException.getMessage());
//        ResponseEntity<ErrorDtos> responseEntity = new ResponseEntity<>(errorDtos, HttpStatus.NOT_FOUND);
//
//        return  responseEntity;
//    }

}
