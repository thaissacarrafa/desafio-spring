package com.meli.desafiospring.service;

import com.meli.desafiospring.dto.ProductDTO;
import com.meli.desafiospring.model.Product;

import java.util.List;

public interface IProduct {
    List<ProductDTO> getAll(String category, Boolean freeShipping, Integer order);

    void save(Product product);
}
