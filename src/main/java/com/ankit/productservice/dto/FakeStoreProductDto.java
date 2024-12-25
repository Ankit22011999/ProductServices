package com.ankit.productservice.dto;

import com.ankit.productservice.model.Category;
import com.ankit.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public Product toProduct(){
        System.out.println("hlwllifsjkdhfjkasd");
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        Category category1 = new Category();
        category1.setTitle(category);
        product.setImageUrl(image);

        return product;
    }
}
