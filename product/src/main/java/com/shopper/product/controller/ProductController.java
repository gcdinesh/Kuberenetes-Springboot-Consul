package com.shopper.product.controller;

import com.shopper.product.model.CheckRequestBody;
import com.shopper.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/checkIfExist")
    protected String login(@RequestBody final CheckRequestBody checkRequestBody) {
        return productService.checkIfExist(checkRequestBody);
    }
}
