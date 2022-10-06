package com.meli.desafiospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.meli.desafiospring.dto.ProductDTO;
import com.meli.desafiospring.model.Product;
import com.meli.desafiospring.service.IProduct;

import java.util.List;

@Controller
@RequestMapping("/api/v1/articles")
public class ProductController {

    @Autowired
    private IProduct service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Product product) {
        service.save(product);
    }



    @GetMapping(params={"category","freeShipping", "prestige"})
    public ResponseEntity<List<ProductDTO>> getAllByCategoryAndShippingController(@RequestParam(value = "category") String category, @RequestParam Boolean freeShipping, @RequestParam( value="prestige", defaultValue = "") String prestige ) {
        return new ResponseEntity<>(service.getAllByCategoryAndShippingService( category, freeShipping, prestige), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(@RequestParam(value = "category", defaultValue = "") String category) {
        System.out.println("getAll products called!");

        return new ResponseEntity<>(service.getAll(category), HttpStatus.OK);
    }
}
