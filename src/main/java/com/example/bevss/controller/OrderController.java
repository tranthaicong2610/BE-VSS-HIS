package com.example.bevss.controller;

import com.example.bevss.dto.SearchOrderDTO;
import com.example.bevss.repository.OrderRepository;
import com.example.bevss.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping("/")
    List<SearchOrderDTO> listOrder(){
        return orderRepository.listOrder();
    }

//    @GetMapping("/search")
//    SearchOrderDTO searchOrder(@RequestParam String phone){
//        return orderService.searchOrder(phone);
//    }


}
