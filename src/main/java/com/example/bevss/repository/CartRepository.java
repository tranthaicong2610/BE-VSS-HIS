package com.example.bevss.repository;

import com.example.bevss.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    @Query(value = "select COUNT(*) FROM cart", nativeQuery = true)
    int getRowCart();

}
