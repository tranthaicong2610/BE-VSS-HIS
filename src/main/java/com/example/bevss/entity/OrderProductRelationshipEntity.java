package com.example.bevss.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "order_product")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductRelationshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private OrderEntity order;

}
