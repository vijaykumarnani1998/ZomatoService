package com.zomato.dto;

import com.zomato.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    private String userId;

    private String restaurantId;

    private Double totalAmount;

    private OrderStatus status;


}
