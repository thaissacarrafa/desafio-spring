package com.meli.desafiospring.exeption;

public class QuantityProductInsufficientException extends Exception{
    public QuantityProductInsufficientException(String message) {
        super(message);
    }
}
