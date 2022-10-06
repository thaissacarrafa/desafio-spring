package com.meli.desafiospring.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.desafiospring.model.Product;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class ProductRepo {
    private final String linkFile = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();

        public List<Product> getAll(String category, Boolean freeShipping, Integer order){
            List<Product> productsFiltered = new ArrayList<>();

            try {
                List<Product> products = null;
                products = Arrays.asList(mapper.readValue(new File(linkFile), Product[].class));

              //  products.stream().filter(product -> product.getCategory().equals(category) );

                if (category != null && !category.isEmpty()) {
                    for (int i = 0; i < products.size(); i++) {
                        Product product = products.get(i);

                        if (category.equals(product.getCategory())) {
                            productsFiltered.add(product);
                        }
                    }


                } else {
                    productsFiltered = products;
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            return productsFiltered;
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
