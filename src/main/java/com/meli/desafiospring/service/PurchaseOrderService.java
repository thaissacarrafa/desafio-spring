package com.meli.desafiospring.service;

import com.meli.desafiospring.exeption.ProductNotExistsException;
import com.meli.desafiospring.exeption.QuantityProductInsufficientException;
import com.meli.desafiospring.model.Product;
import com.meli.desafiospring.model.PurchaseOrder;
import com.meli.desafiospring.model.Ticket;
import com.meli.desafiospring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderService implements IPurchaseOrder {

    @Autowired
    ProductRepo productRepo;

    @Override
    public Ticket createPurchaseOrder(List<PurchaseOrder> purchaseOrderList) throws ProductNotExistsException, QuantityProductInsufficientException {
        Set<Product> productSet = new HashSet<>();
        BigDecimal totalPrice = BigDecimal.valueOf(0.0);

        for(PurchaseOrder p: purchaseOrderList){
            Product product = this.productRepo.getProductById(p.getPurchaseId());
            if(product.getQuantity() < p.getPurchaseQuantity()){
                throw new QuantityProductInsufficientException("Estoque insuficiente!");
            }
            else{
                productSet.add(product);
                totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(p.getPurchaseQuantity())));

            }
        }

        Ticket newTicket = new Ticket(productSet.stream().collect(Collectors.toList()), totalPrice);

        return newTicket;
    }

}
