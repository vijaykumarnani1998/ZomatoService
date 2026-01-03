package com.zomato.menu.entity;

import com.zomato.restaurant.entity.RestaurantEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="menu")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long menuId;
    private String itemName;
    private double price;
    private boolean veg;
    private boolean available;

    @ManyToOne //Many menu items belong to one restaurant
    @JoinColumn(name = "restaurant_id", nullable = false)
    RestaurantEntity restaurant;

}
