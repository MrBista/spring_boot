package com.exercie.exercies.controller;

import com.exercie.exercies.dto.response.CommonResponse;
import com.exercie.exercies.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllProduct(){

        return CommonResponse
                .generateResponse(productService.getAllProduct(),
                        "Successfully get all data",
                        HttpStatus.OK
                );
    }
}
