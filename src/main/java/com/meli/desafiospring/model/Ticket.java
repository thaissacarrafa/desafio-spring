package com.meli.desafiospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    static Integer ticketId = 0;
    private int quantity;
    private BigDecimal totalPrice;
    List<Product> productList;

    public Ticket(List<Product> productList, BigDecimal valorTotal) {
        this.productList = productList;
        this.totalPrice = valorTotal;
        this.ticketId = ++ticketId;
    }
}
