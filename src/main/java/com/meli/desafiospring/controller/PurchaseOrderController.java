package com.meli.desafiospring.controller;

import com.meli.desafiospring.exeption.ProductNotExistsException;
import com.meli.desafiospring.exeption.QuantityProductInsufficientException;
import com.meli.desafiospring.model.PurchaseOrder;
import com.meli.desafiospring.model.Ticket;
import com.meli.desafiospring.service.IPurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ap1/v1/purchase-request")
public class PurchaseOrderController {

    @Autowired
    private IPurchaseOrder service;

    @PostMapping
    public ResponseEntity<Ticket> purchaseRequest (@RequestBody List<PurchaseOrder> purchaseOrderList)
            throws ProductNotExistsException, QuantityProductInsufficientException {
        Ticket ticket = this.service.createPurchaseOrder(purchaseOrderList);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
