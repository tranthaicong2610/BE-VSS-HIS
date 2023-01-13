package com.example.bevss.service;

import com.example.bevss.entity.OrderProductRelationshipEntity;
import com.example.bevss.repository.OrderProductRelationshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProductRelationshipServiceImpl implements OrderProductRelationshipService{

    private OrderProductRelationshipRepository orderProductRelationshipRepository;

    @Override
    public OrderProductRelationshipEntity createOrderProductRelationship(OrderProductRelationshipEntity orderProductRelationshipEntity) {
        if (orderProductRelationshipEntity != null
                && orderProductRelationshipEntity.getOrder() != null
                && orderProductRelationshipEntity.getProduct() != null
        ){
            return orderProductRelationshipRepository.save(orderProductRelationshipEntity);
        }
        return null;

    }
}
