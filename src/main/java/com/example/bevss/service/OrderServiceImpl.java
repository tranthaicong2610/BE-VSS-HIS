package com.example.bevss.service;

import com.example.bevss.dto.SearchOrderDTO;
import com.example.bevss.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public SearchOrderDTO searchOrder(String name) {
        return orderRepository.searchOrder(name);
    }
}
