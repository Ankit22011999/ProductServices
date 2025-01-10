package com.ankit.productservice.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating extends  BaseClass{
    public int rate;
    public int count;
}
