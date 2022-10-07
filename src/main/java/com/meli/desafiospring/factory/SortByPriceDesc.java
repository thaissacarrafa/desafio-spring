package com.meli.desafiospring.factory;

import com.meli.desafiospring.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByPriceDesc {

    public static List<Product> sort(List<Product> products, Integer order){
        if (order == 3) {
            return products
                    .stream()
                    .sorted(Comparator.comparing(Product::getPrice).reversed())
                    .collect(Collectors.toList());
        }

        return products;
    }
}
