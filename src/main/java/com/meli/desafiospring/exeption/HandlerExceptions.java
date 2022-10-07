package com.meli.desafiospring.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDetails> handlerProductNotExistsException(ProductNotExistsException e){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Produto não existente!")
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (QuantityProductInsufficientException.class)
    public ResponseEntity<ExceptionDetails> handlerQuantityProductInsufficientException(QuantityProductInsufficientException e){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Quantidade do produto é insuficiente!")
                .message(e.getMessage())
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler (NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException e){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Produto não encontrado!")
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }
}
