package com.example.bevss.controller;

import com.example.bevss.entity.ProductEntity;
import com.example.bevss.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService ;

    @GetMapping("/")
    List<ProductEntity> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    ProductEntity getDetail(@RequestParam Long id){
        return productService.getDetail(id);
    }

    @PostMapping("/")
    ProductEntity createProduct(@RequestBody ProductEntity productEntity){
        return productService.createProduct(productEntity);
    }

    @PutMapping ("/")
    ProductEntity updateProduct(@RequestBody ProductEntity productEntity){
        return productService.updateProduct(productEntity);
    }

    @DeleteMapping("/{id}")
    Boolean deleteProduct(@RequestParam Long id){
        return productService.deleteProduct(id);
    }







}
