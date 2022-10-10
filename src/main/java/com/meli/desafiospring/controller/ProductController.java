package com.meli.desafiospring.controller;

import com.meli.desafiospring.dto.ProductDTO;
import com.meli.desafiospring.dto.ProductPostResDTO;
import com.meli.desafiospring.model.Product;
import com.meli.desafiospring.service.IProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/articles")
public class ProductController {

    @Autowired
    private IProduct service;

    @PostMapping("/insert-articles-request")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<ProductPostResDTO>> save(@RequestBody List<Product> products) {
        return new ResponseEntity<>(service.save(products), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(
            @RequestParam(value = "category", required = false, defaultValue = "") String category,
            @RequestParam(value = "freeShipping", required = false) Boolean freeShipping,
            @RequestParam(value = "order", required = false, defaultValue = "0") Integer order,
            @RequestParam(value = "prestige", required = false, defaultValue = "") String prestige) {

        return new ResponseEntity<>(service.getAll(category, freeShipping, order, prestige), HttpStatus.OK);
    }
}
