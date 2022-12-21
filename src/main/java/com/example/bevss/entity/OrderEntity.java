package com.example.bevss.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Table(name = "order")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_pay")
    private Boolean isPay;

    @Column(name = "payment_method") // phuong thuc thanh toan (true : tien mat | false : tai khoan)
    private Boolean paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<OrderProductRelationshipEntity> orderProductRelationshipEntities;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserEntity user;

}
