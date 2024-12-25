package com.ankit.productservice.dto;

import com.ankit.productservice.model.Product;
import com.ankit.productservice.model.Rating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private String title;
    private String description;
    private String image;
    private Rating rating;
    private double price;
    private int id;

    public Product toProduct(){
//        System.out.println("hlwllifsjkdhfjkasd");
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setId(id);

        if (rating != null) {
            Rating newRating = new Rating();
            newRating.setRate(rating.getRate());
            newRating.setCount(rating.getCount());
            product.setRating(newRating);
        }

        product.setImageUrl(image);

        return product;
    }
}
