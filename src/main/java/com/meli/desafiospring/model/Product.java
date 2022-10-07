package com.meli.desafiospring.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Product {
    private Integer productId;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private int quantity;
    private boolean freeShipping;
    private String prestige;
    private Integer Order;
}
