package com.meli.desafiospring.factory;

import com.meli.desafiospring.enuns.OrderEnum;
import com.meli.desafiospring.model.Product;

import java.util.Comparator;
import java.util.List;

public class SortByPrice {

    public static void sort(List< ? extends Product> products,OrderEnum order){
        Comparator<Product> comparator;

        comparator = Comparator.comparing(Product::getPrice);

        if (order.equals(OrderEnum.MAIOR_MENOR)) {
            comparator = Comparator.comparing(Product::getPrice).reversed(); }

        products.sort(comparator);
    }
}

