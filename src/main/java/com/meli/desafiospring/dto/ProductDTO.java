package com.meli.desafiospring.dto;

import com.meli.desafiospring.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int quantity;

    private String category;

    private String brand;

    private BigDecimal price;

    private boolean freeShipping;

    private String prestige;

    public ProductDTO(Product product) {
        this.id = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.category = product.getCategory();
        this.brand = product.getBrand();
        this.price = product.getPrice();
        this.freeShipping = product.isFreeShipping();
        this.prestige = product.getPrestige();


    }

}
