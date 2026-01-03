package com.zomato.restaurant.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;        // address number
    private String city;    // city name
    private String area;    // area / locality
    private String pincode; // postal code
}
