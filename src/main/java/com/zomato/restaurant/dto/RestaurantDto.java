package com.zomato.restaurant.dto;

import com.zomato.restaurant.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private Long restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private String cuisine;   // food type :Indian/Chinese
    private boolean open;     // open or close
    private double rating;    // user rating
    private Long ownerId;     // owner user id
    private Address address;
}
