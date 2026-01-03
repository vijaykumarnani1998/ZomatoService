package com.zomato.restaurant.service;

import com.zomato.restaurant.dto.RestaurantDto;
import com.zomato.restaurant.entity.RestaurantEntity;

import java.util.List;

public interface RestaurantService {

    public RestaurantEntity createRestaurant(RestaurantDto dto);

    public List<RestaurantEntity> getRestaurantsByCity(String city);

    public List<RestaurantEntity> getRestaurantsByCuisine(String cuisine);

    public List<RestaurantEntity> getOpenRestaurants();

    public  RestaurantEntity updateRestaurantStatus(Long id, boolean isOpen);


    public RestaurantEntity getRestaurantById(Long id);
    public List<RestaurantEntity> getAllRestaurants();
    public String deleteRestaurant(Long id);
    public RestaurantEntity updateRestaurant(Long id,RestaurantDto dto);
}
