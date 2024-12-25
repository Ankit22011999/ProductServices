package com.ankit.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;
    private String title;
    private String description;
    private double price;
    private Rating rating;
    private String imageUrl;

    public void setRate(int rate) {
        this.rating.rate = rate;
    }

    public void setCount(int count) {
        this.rating.count = count;
    }

    public int getRate() {
        return rating != null ? rating.getRate() : 0; // Return 0 if rating is null
    }

    public int getCount() {
        return rating != null ? rating.getCount() : 0; // Return 0 if rating is null
    }

}
