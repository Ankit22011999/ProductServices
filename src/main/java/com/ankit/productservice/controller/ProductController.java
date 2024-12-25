package com.ankit.productservice.controller;
import com.ankit.productservice.dto.CreateProductRequestDTO;
import com.ankit.productservice.model.Product;
import com.ankit.productservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products =productService.getAllProducts();
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
       return productService.getSingleProduct(id);
    }
    @PostMapping
    public Product createProduct(CreateProductRequestDTO createProductRequestDTO) {
        return productService.createProduct(createProductRequestDTO);
    }

}
