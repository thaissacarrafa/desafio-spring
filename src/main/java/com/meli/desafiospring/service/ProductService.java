package com.meli.desafiospring.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.desafiospring.dto.ProductDTO;
import com.meli.desafiospring.dto.ProductPostResDTO;
import com.meli.desafiospring.model.Product;
import com.meli.desafiospring.repository.ProductRepo;

@Service
public class ProductService implements IProduct {
    @Autowired
    private ProductRepo repository;

    @Override
    public List<ProductPostResDTO> save(List<Product> products) {
        return repository.saveProducts(products);
    }

    public List<ProductDTO> getAll(String category, Boolean freeShipping, Integer order, String prestige) {
        return repository.getAll(category, freeShipping, order, prestige).stream().map(ProductDTO::new)
                .collect(Collectors.toList());

    }
}
