package com.example.bevss.service;

import com.example.bevss.entity.CartEntity;

public interface CartService {
    int getRowCart();
    CartEntity createCart(CartEntity cartEntity);
}
