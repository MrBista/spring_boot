package org.example.repository;

import org.example.model.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    List<Product> findAll();
    Product findById(Long id);
    void update(Product product);
    void delete(Product product);
}
