package com.ankit.productservice.service;
import com.ankit.productservice.dto.FakeStoreProductDto;
import com.ankit.productservice.exception.ProductNotFoundException;
import com.ankit.productservice.model.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private  final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Product> getAllProducts() {
       ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoArrayEntity =  restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
//        return Arrays.stream(fakeStoreProductDtoArray)
//                .map(FakeStoreProductDto::toProduct)
//                .collect(Collectors.toList());
        FakeStoreProductDto[] fakeStoreProductDtos = fakeStoreProductDtoArrayEntity.getBody();
        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            Product p = fakeStoreProductDto.toProduct();
            products.add(p);
        }
        return products;
    }

    public List<Product> getCategory(String category){
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDto = restTemplate.getForEntity(
                                                                "https://fakestoreapi.com/products/category/"+category ,
                                                                     FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        FakeStoreProductDto[] fakeStoreProductDtos = fakeStoreProductDto.getBody();
        for(FakeStoreProductDto  fakestoreProductDto : fakeStoreProductDtos ){
            Product p = fakestoreProductDto.toProduct();
            products.add(p);
        }
        return products;
    }
    public Product getSingleProduct(long id)  {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =restTemplate.getForEntity
                                        ("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("produt with this id "+id+" not found , please check with the valid id ");
        }


        return fakeStoreProductDto.toProduct();
    }

    public Product createProduct(String title,
                                 String description,
                                 double price,
//                                 Rating rating ,
                                 String imageUrl) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
//        fakeStoreProductDto.setRating(rating);
        fakeStoreProductDto.setImage(imageUrl);
        FakeStoreProductDto fakeStoreProductDto1 =restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
        return fakeStoreProductDto1.toProduct();
    }

}
