package com.exercie.exercies.mapper;

import com.exercie.exercies.dto.request.ProductDtoReq;
import com.exercie.exercies.dto.response.ProductDtoRes;
import com.exercie.exercies.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDtoRes toDto(Product product){
        ProductDtoRes productDtoRes = new ProductDtoRes();
        productDtoRes.setId(product.getId());
        productDtoRes.setName(product.getName());
        productDtoRes.setStock(product.getStock());
        productDtoRes.setPrice(product.getPrice());
        productDtoRes.setCategoryId(product.getCategoryId());
        productDtoRes.setCreatedAt(product.getCreatedAt());
        return productDtoRes;
    }

    public Product toEntity(ProductDtoReq productDtoReq){
        Product product = new Product();
        product.setName(productDtoReq.getName());
        product.setDescription(productDtoReq.getDescription());
        product.setCategoryId(productDtoReq.getCategoryId());
        product.setPrice(productDtoReq.getPrice());
        product.setStock(product.getStock());
        return product;
    }


}
