package com.example.bevss.repository;

import com.example.bevss.dto.SearchOrderDTO;
import com.example.bevss.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

//    new com.example.bevss.dto.SearchOrderDTO()
//    @Query(value = "select  order.id,user.name, user.phone FROM " +
//            " user join order on user.id = order.user_id " +
//            " where :name is null or user.phone like %:phone%  " ,nativeQuery = true)
//    SearchOrderDTO searchOrder(@Param("phone") String phone);

    @Query(value = "select new com.example.bevss.dto.SearchOrderDTO(order.id,user.username, user.phone)  FROM " +
            " UserEntity user join OrderEntity order on user.id = order.user.id " )
    List<SearchOrderDTO> listOrder();

}
