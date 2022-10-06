package com.meli.desafiospring.dto;

import com.meli.desafiospring.model.Product;

import lombok.*;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int quantity;
    private String category;
    private Boolean isFreeShipping;


    public ProductDTO(Product product) {
        this.id = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.category = product.getCategory();
        this.isFreeShipping = product.isFreeShipping();
    }
}
