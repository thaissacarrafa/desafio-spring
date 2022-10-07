package com.meli.desafiospring.service;

import com.meli.desafiospring.dto.ProductDTO;
import com.meli.desafiospring.exeption.NotFoundException;
import com.meli.desafiospring.exeption.ProductNotExistsException;
import com.meli.desafiospring.exeption.QuantityProductInsufficientException;
import com.meli.desafiospring.model.Product;
import com.meli.desafiospring.model.PurchaseOrder;
import com.meli.desafiospring.model.Ticket;

import java.util.List;

public interface IProduct {
    List<ProductDTO> getAll(String category, Boolean freeShipping, Integer order, String prestige);

    void save(Product product);

}
