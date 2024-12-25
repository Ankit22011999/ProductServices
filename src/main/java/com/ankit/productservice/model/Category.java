package com.ankit.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private long id;
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }
}
