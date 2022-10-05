package com.meli.desafiospring.service;

import java.util.List;

import com.meli.desafiospring.dto.ProductDTO;
import com.meli.desafiospring.model.Product;

public interface IProduct {
    List<ProductDTO> getAll();

    void save(Product product);
}
