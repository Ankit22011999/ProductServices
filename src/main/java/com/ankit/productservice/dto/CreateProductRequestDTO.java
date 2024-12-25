package com.ankit.productservice.dto;

import com.ankit.productservice.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private long id;
    private String tittle;
    private String description;
    private double price;
    private Category category;
    private String imageUrl;
}
