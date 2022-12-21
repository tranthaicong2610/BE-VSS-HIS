package com.example.bevss.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "cart_product_relationship")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CartProductRelationshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CartEntity cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ProductEntity product;

}
