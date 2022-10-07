package com.meli.desafiospring.exeption;

public class ProductNotExistsException extends Exception{
    public ProductNotExistsException(String message) {
        super(message);
    }
}
