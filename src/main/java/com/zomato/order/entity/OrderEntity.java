package com.zomato.order.entity;

import com.zomato.enums.OrderStatus;
import com.zomato.restaurant.entity.RestaurantEntity;
import com.zomato.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "orders")
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_fk")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id_fk")
    private RestaurantEntity restaurant;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}
