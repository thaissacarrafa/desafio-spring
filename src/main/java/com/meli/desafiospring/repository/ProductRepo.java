package com.meli.desafiospring.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import com.meli.desafiospring.exeption.ProductNotExistsException;

import com.meli.desafiospring.factory.SortByNameAsc;
import com.meli.desafiospring.factory.SortByNameDesc;
import com.meli.desafiospring.factory.SortByPriceAsc;
import com.meli.desafiospring.factory.SortByPriceDesc;
import com.meli.desafiospring.model.Product;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.meli.desafiospring.model.Product;
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

            products = SortByNameAsc.sort(products, order);

            products = SortByNameDesc.sort(products, order);

            products = SortByPriceAsc.sort(products, order);

            products = SortByPriceDesc.sort(products, order);


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

    public Product getProductById(Integer productId) throws ProductNotExistsException {
        File storeFile = new File(linkFile);
        List<Product> products = null;
        try{
            products = Arrays.asList(mapper.readValue(storeFile, Product[].class));
        } catch (Exception e){

        }
        Optional<Product> optionalProduct = products.stream()
                .filter(product -> product.getProductId()
                        .equals(productId))
                .findFirst();
        if (optionalProduct.isEmpty()){
            throw new ProductNotExistsException("Produto " +productId+ " não existente!");
        }
      
        return optionalProduct.get();
    }
}
