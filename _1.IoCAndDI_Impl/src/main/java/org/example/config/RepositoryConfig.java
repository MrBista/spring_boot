package org.example.config;

import org.example.repository.ProductRepository;
import org.example.repository.ProductRepositoryImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    @Bean
    public ProductRepository productRepository(DataSource dataSource){
        return new ProductRepositoryImp(dataSource);
    }
}
