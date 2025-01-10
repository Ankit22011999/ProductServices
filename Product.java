package com.ankit.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends  BaseClass {
//    private long id;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;
    private String description;
    private double price;
//    private Rating rating;
    private String imageUrl;
    private String category;
}
