package com.meli.desafiospring.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Integer productId;
    private String name;
    private String category;
    private String brand;
    private float price;
    private Integer quantity;
    private Boolean freeShipping;
    private String prestige;
}
