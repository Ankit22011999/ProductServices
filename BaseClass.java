package com.ankit.productservice.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.Id;
import jdk.jfr.Registered;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.MappedSuperclass;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseClass {
    @Id
    private int id;
    private  String created_at;
    private  String updated_at;
    private  String created_by;
    private  String updated_by;
    private  String deleted_at;
}
