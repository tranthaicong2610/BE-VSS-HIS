package com.example.bevss.service;

import com.example.bevss.entity.CartEntity;
import com.example.bevss.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository  cartRepository;
    @Override
    public int getRowCart() {
        return cartRepository.getRowCart();
    }

    @Override
    public CartEntity createCart(CartEntity cartEntity) {
        return cartRepository.save(cartEntity);
    }

}
