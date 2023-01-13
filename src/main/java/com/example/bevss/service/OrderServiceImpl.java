package com.example.bevss.service;

import com.example.bevss.dto.SearchOrderDTO;
import com.example.bevss.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

//    @Override
//    public SearchOrderDTO searchOrder(String phone) {
//        return orderRepository.searchOrder(phone);
//    }

    @Override
    public List<SearchOrderDTO> listOrder() {
        return orderRepository.listOrder();
    }


}
