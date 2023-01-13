package com.example.bevss.service;


import com.example.bevss.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity getDetail(Long id);

    List<ProductEntity> getAll();

    ProductEntity createProduct(ProductEntity productEntity);

    ProductEntity updateProduct(ProductEntity productEntity);

    Boolean deleteProduct(Long id);
}
