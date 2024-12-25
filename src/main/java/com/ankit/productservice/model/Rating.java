package com.ankit.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    public int rate;
    public int count;

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public int getRate() {
        return this.rate;
    }

    public int getCount() {
        return this.count;
    }
}
