package com.meli.desafiospring.dto;

import lombok.Data;

import com.meli.desafiospring.model.Product;

@Data
public class ProductPostResDTO {
    private int id;
    private String name;
    private int quantity;

    public ProductPostResDTO(Product product) {
        this.id = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }
}
