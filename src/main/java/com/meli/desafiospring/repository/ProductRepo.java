package com.meli.desafiospring.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.desafiospring.model.Product;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ProductRepo {
    private final String linkFile = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();

        public List<Product> getAll(String category, Boolean freeShipping, Integer order){

            try {
                List<Product> products = Arrays.asList(mapper.readValue(new File(linkFile), Product[].class));

                if (category != null && !category.isEmpty()) {
                    products = products
                            .stream()
                            .filter(product -> product.getCategory().equals(category))
                            .collect(Collectors.toList());
                }

                if (freeShipping != null ) {
                    products = products
                            .stream()
                            .filter(product -> product.isFreeShipping() == freeShipping)
                            .collect(Collectors.toList());
                }

                if (order == 0) {
                    products = products
                            .stream()
                            .sorted(Comparator.comparing(Product::getName))
                            .collect(Collectors.toList());
                }

                if (order == 1) {
                    products = products
                            .stream()
                            .sorted(Comparator.comparing(Product::getName).reversed())
                            .collect(Collectors.toList());
                }

                if (order == 2) {
                    products = products
                            .stream()
                            .sorted(Comparator.comparing(Product::getPrice))
                            .collect(Collectors.toList());
                }

                if (order == 3) {
                    products = products
                            .stream()
                            .sorted(Comparator.comparing(Product::getPrice).reversed())
                            .collect(Collectors.toList());
                }

                return products;

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            return new ArrayList<>();
        }

    public void saveProduct(Product newProduct) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Product> products = getAll(null ,null, null);

        products = new ArrayList<>(products);

        products.add(newProduct);

        try {
            writer.writeValue(new File(linkFile), products);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
