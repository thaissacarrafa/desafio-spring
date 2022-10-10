package com.meli.desafiospring.dto;

import java.math.BigDecimal;
import lombok.Data;

import com.meli.desafiospring.model.Product;


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
        this.freeShipping = product.isFreeShipping();
        this.brand = product.getBrand();
        this.price = product.getPrice();
        this.freeShipping = product.isFreeShipping();
        this.prestige = product.getPrestige();
    }
}
