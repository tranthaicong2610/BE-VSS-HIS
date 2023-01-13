package com.example.bevss.repository;

import com.example.bevss.entity.OrderProductRelationshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRelationshipRepository extends JpaRepository<OrderProductRelationshipEntity,Long> {
}
