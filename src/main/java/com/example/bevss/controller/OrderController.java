package com.example.bevss.controller;

import com.example.bevss.dto.SearchOrderDTO;
import com.example.bevss.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @GetMapping("/search")
    SearchOrderDTO searchOrder(@RequestParam String name){
        return orderService.searchOrder(name);
    }
}
