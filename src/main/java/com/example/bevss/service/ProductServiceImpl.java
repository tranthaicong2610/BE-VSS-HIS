package com.example.bevss.service;

import com.example.bevss.entity.ProductEntity;
import com.example.bevss.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity getDetail(Long id) {
        ProductEntity productEntity = productRepository.getById(id);
        return productEntity == null ? null : productEntity ;
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public ProductEntity createProduct(ProductEntity productEntity) {
        if (productEntity != null){
            return productRepository.save(productEntity);
        }
        return null;
    }

    @Override
    @Transactional
    public ProductEntity updateProduct(ProductEntity productEntity) {
        if (productEntity != null){
            ProductEntity productEntityUpdate = productRepository.getById(productEntity.getId());
            if(productEntityUpdate != null) {
                productEntityUpdate.setName(productEntity.getName());
                productEntityUpdate.setType(productEntity.getType());
                productEntityUpdate.setImage(productEntity.getImage());
                productEntityUpdate.setPrice(productEntity.getPrice());
                productEntityUpdate.setQuantity(productEntity.getQuantity());
                productEntityUpdate.setCode(productEntity.getCode());
                productEntityUpdate.setDescription(productEntity.getDescription());
                return productRepository.save(productEntityUpdate);
            }
        }
        return null;
    }

    @Override
    @Transactional
    public Boolean deleteProduct(Long id) {
        ProductEntity productEntity = productRepository.getById(id);
        if(productEntity != null){
            productRepository.delete(productEntity);
            return true;
        }
        return false;
    }
}
