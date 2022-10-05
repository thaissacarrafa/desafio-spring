package com.meli.desafiospring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.desafiospring.dto.ProductDTO;
import com.meli.desafiospring.model.Product;
import com.meli.desafiospring.repository.ProductRepo;

@Service
public class ProductService implements IProduct {
    @Autowired
    private ProductRepo repository;

    @Override
    public void save(Product product) {
        repository.saveProduct(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        return repository.getAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
