package com.ankit.productservice.dto;

import com.ankit.productservice.model.Rating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private long id;
    private String tittle;
    private String description;
    private double price;
    private Rating rating;
    private String imageUrl;
}
