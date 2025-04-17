package org.example.config;

import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ServiceConfig {

    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new ProductServiceImpl(productRepository);
    }
}
