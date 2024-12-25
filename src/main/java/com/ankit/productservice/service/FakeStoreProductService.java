package com.ankit.productservice.service;
import com.ankit.productservice.dto.CreateProductRequestDTO;
import com.ankit.productservice.dto.FakeStoreProductDto;
import com.ankit.productservice.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakeStoreProductService implements ProductService{
    private  RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtoArray =  restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        return Arrays.stream(fakeStoreProductDtoArray)
                .map(FakeStoreProductDto::toProduct)
                .collect(Collectors.toList());
    }
    public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto =restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    public Product createProduct(CreateProductRequestDTO createProductRequestDTO) {
        return null;
    }

}
