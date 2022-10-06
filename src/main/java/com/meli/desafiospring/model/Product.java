package com.meli.desafiospring.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.*;

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

}

// "productId":1,

// "name":"Serra de Bancada",

// "category":"Ferramentas",

// "brand":"FORTGPRO",

// "price":1800.00,

// "quantity":5,

// "freeShipping":true,

// "prestige":"****
