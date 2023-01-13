package com.example.bevss.service.impl;

import com.example.bevss.entity.ProductEntity;
import com.example.bevss.repository.ProductRepository;
import com.example.bevss.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceimpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity add(ProductEntity product) {
        if( product != null){
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public ProductEntity update(ProductEntity productUpdate) {
        if (productUpdate != null ){
            ProductEntity product = productRepository.findById(productUpdate.getId()).get();
            if (product != null){
                product.setName(productUpdate.getName());
                product.setCode(productUpdate.getCode());
                product.setImage(productUpdate.getImage());
                product.setPrice(productUpdate.getPrice());
                product.setDescription(productUpdate.getDescription());
                product.setQuantity(productUpdate.getQuantity());
                return productRepository.save(product);
            }


        }


        return null;
    }

    @Override
    public ProductEntity getDetail(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        ProductEntity product  = productRepository.findById(id).get();
        if(product != null)
        {
            productRepository.delete(product);
            return true;
        }
        return false;
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

}
