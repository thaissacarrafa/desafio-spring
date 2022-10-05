package com.meli.desafiospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    
    System.out.println("save product called!");
  }

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getAll() {
    System.out.println("getAll products called!");

    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }
}
