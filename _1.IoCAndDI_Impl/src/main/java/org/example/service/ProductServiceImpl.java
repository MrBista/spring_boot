package org.example.service;

import org.example.model.Product;
import org.example.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product){
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

    public Product updateProduct(Product product){
        productRepository.update(product);
        return product;
    }

}
