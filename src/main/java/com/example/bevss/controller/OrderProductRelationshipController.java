package com.example.bevss.controller;

import com.example.bevss.entity.OrderProductRelationshipEntity;
import com.example.bevss.service.OrderProductRelationshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-product")
@RequiredArgsConstructor
public class OrderProductRelationshipController {

    private final OrderProductRelationshipService orderProductRelationshipService;

    @PostMapping("/")
    OrderProductRelationshipEntity createOrderProductRelationship(@RequestBody OrderProductRelationshipEntity orderProductRelationshipEntity){
        return orderProductRelationshipService.createOrderProductRelationship(orderProductRelationshipEntity);
    }

}
