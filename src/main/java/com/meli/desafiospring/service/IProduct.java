package com.meli.desafiospring.service;

import java.util.List;

import com.meli.desafiospring.dto.ProductDTO;
import com.meli.desafiospring.model.Product;

public interface IProduct {
    List<ProductDTO> getAll(String category);

    void save(Product product);
}
