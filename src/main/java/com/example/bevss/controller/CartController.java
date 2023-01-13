package com.example.bevss.controller;

import com.example.bevss.entity.CartEntity;
import com.example.bevss.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/row")
    int getRowCart(){
        return cartService.getRowCart();
    }

    @PostMapping("/")
    CartEntity createCart(CartEntity cartEntity){
        return cartService.createCart(cartEntity);
    }
}
