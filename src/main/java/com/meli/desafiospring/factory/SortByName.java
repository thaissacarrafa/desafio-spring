package com.meli.desafiospring.factory;

import com.meli.desafiospring.enuns.OrderEnum;
import com.meli.desafiospring.model.Product;

import java.util.Comparator;
import java.util.List;

public class SortByName {

    public static void sort(List< ? extends Product> products, OrderEnum order){
        Comparator<Product> comparator;

        comparator = Comparator.comparing(Product::getName);

        if (order.equals(OrderEnum.ALFABETICO_DECRESCENTE)) {
            comparator = Comparator.comparing(Product::getName).reversed();
        }
        products.sort(comparator);
    }
}
