package com.zomato.menu.repository;

import com.zomato.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity,Long> {



        @Query("SELECT m FROM MenuEntity m WHERE m.restaurant.restaurantId = :restaurantId")
        List<MenuEntity> findByRestaurant_RestaurantId(@Param("restaurantId") Long restaurantId);
        @Query("SELECT m FROM MenuEntity m WHERE m.veg= true")
        List<MenuEntity> findByVegTrue();     // Veg items
        @Query("SELECT m FROM MenuEntity m WHERE m.veg= false")
        List<MenuEntity> findByVegFalse();    // 🔥 Non-Veg items
        @Query("SELECT m FROM MenuEntity m WHERE m.available= true")
        List<MenuEntity> findByAvailableTrue();

}
