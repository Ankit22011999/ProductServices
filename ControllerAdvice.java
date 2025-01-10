package com.ankit.productservice.advice;

import com.ankit.productservice.dto.ErrorDtos;
import com.ankit.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDtos> handleProductNotFoundExpection(ProductNotFoundException productNotFoundException) {
        ErrorDtos errorDtos = new ErrorDtos();
        errorDtos.setMessage(productNotFoundException.getMessage());
        ResponseEntity<ErrorDtos> responseEntity = new ResponseEntity<>(errorDtos, HttpStatus.NOT_FOUND);

        return  responseEntity;
    }
}
