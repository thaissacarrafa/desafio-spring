package com.meli.desafiospring.service;


import com.meli.desafiospring.dto.ProductDTO;
import com.meli.desafiospring.exeption.NotFoundException;
import com.meli.desafiospring.exeption.ProductNotExistsException;
import com.meli.desafiospring.model.Product;
import com.meli.desafiospring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
//    @Override
//    public Product getProductById(int productId) throws NotFoundException {
//
}
