package com.meli.desafiospring.factory;

import com.meli.desafiospring.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class SortByPrestige {

    public  static  List<Product> sort(List<Product> products, String prestige) {
        if (prestige != null && !prestige.isEmpty() ) {
            return products.stream()
                    .filter(Product -> Product.getPrestige().equals(prestige))
                    .collect(Collectors.toList());
        };
        return products;
    }
}
