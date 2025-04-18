package org.example;

import org.example.config.AppConfig;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        ProductService productService = context.getBean(ProductService.class);

        context.close();
    }
}