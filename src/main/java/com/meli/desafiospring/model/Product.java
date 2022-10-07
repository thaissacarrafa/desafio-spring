package com.meli.desafiospring.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private int productId;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private int quantity;
    private boolean freeShipping;
    private String prestige;
    private Integer Order;
}

// "productId":1,

// "name":"Serra de Bancada",

// "category":"Ferramentas",

// "brand":"FORTGPRO",

// "price":1800.00,

// "quantity":5,

// "freeShipping":true,

// "prestige":"****
