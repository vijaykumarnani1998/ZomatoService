package com.zomato.restaurant.controller;

import com.zomato.restaurant.dto.RestaurantDto;
import com.zomato.restaurant.entity.RestaurantEntity;
import com.zomato.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping("/create")
    public ResponseEntity<RestaurantEntity> createRestaurant(@RequestBody RestaurantDto dto) {
        RestaurantEntity restaurant = service.createRestaurant(dto);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    @GetMapping("/Id/{id}")
    public ResponseEntity<RestaurantEntity> getRestaurantById(@PathVariable Long id){
        RestaurantEntity restaurant = service.getRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RestaurantEntity>> getAllRestaurants(){
        List<RestaurantEntity> restaurantList = service.getAllRestaurants();
        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }
    @GetMapping("/city/{city}")
    public ResponseEntity<List<RestaurantEntity>> getRestaurantById(@PathVariable String city){
        List<RestaurantEntity> restaurantList = service.getRestaurantsByCity(city);
        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }
    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<List<RestaurantEntity>> getRestaurantByCuisine(@PathVariable String cuisine){
        List<RestaurantEntity> restaurantList = service.getRestaurantsByCuisine(cuisine);
        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }
    @GetMapping("/open")
    public ResponseEntity<List<RestaurantEntity>> getOpenRestaurats(){
        List<RestaurantEntity> restaurantList = service.getOpenRestaurants();
        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<RestaurantEntity> updateRestaurant(@PathVariable Long id, boolean flag) {
        RestaurantEntity restaurant = service.updateRestaurantStatus(id, flag);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

}
