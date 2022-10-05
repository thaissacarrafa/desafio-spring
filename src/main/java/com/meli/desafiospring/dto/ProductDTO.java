package com.meli.desafiospring.dto;

import com.meli.desafiospring.model.Product;

import lombok.*;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int quantity;

    public ProductDTO(Product product) {
        this.id = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }
}
