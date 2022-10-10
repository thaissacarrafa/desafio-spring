package com.meli.desafiospring.service;

import com.meli.desafiospring.exeption.ProductNotExistsException;
import com.meli.desafiospring.exeption.QuantityProductInsufficientException;
import com.meli.desafiospring.model.PurchaseOrder;
import com.meli.desafiospring.model.Ticket;

import java.util.List;

public interface IPurchaseOrder {
    public Ticket createPurchaseOrder(List<PurchaseOrder> purchaseOrderList)
            throws ProductNotExistsException, QuantityProductInsufficientException;
}
