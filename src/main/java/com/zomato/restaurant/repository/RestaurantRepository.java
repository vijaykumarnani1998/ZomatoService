package com.zomato.restaurant.repository;

import com.zomato.restaurant.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Long> {

    List<RestaurantEntity> findByAddress_City(String city);

    List<RestaurantEntity> findByCuisine(String cuisine);

    List<RestaurantEntity> findByOpenTrue();

}
