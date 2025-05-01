package com.exercie.exercies.service;

import com.exercie.exercies.dao.ProductDao;
import com.exercie.exercies.dao.ProductDaoImpl;
import com.exercie.exercies.dto.request.ProductDtoReq;
import com.exercie.exercies.dto.response.ProductDtoRes;
import com.exercie.exercies.exception.ResourceNotFoundException;
import com.exercie.exercies.mapper.ProductMapper;
import com.exercie.exercies.model.Category;
import com.exercie.exercies.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductDao productDao;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductDaoImpl productDao, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productDao = productDao;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDtoRes> getAllProduct(){
        return productDao
                .findAll()
                .stream()
                .map((product -> {
                    ProductDtoRes toProductDto = productMapper.toDto(product);


                    categoryRepository
                            .findById(product.getCategoryId())
                            .ifPresent(toProductDto::addDetailCategory);

                    return toProductDto;
                }))
                .toList();
    }

    @Transactional
    public ProductService saveProduct(ProductDtoReq productDtoReq){
        // 1. cari categorynya dulu
        // 2. kalau ga ada throw
        // 3. kalau ada insert
        categoryRepository
                .findById(productDtoReq.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));



        return null;
    }
}
