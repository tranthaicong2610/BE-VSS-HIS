package com.example.bevss.repository;

import com.example.bevss.dto.SearchOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<> {

    @Query(value = "select product.name , product.price, product.image , order_product.quantity  FROM " +
            " user join order on user.id = order.user_id " +
            " join order_product on order.id =  order_product.order_id " +
            " join product on order_product.product_id = product.id " +
            " where :name is null or user.name like %:name%  ", nativeQuery = true)
    SearchOrderDTO searchOrder(@Param("name") String name);

}
