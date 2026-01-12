package com.zomato.util;

import com.zomato.order.dto.OrderDto;
import com.zomato.order.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

    public  OrderDto mapEntityToDto(OrderEntity entity) {

        OrderDto dto = new OrderDto();
        dto.setOrderId(entity.getOrderId());
        dto.setUserId(entity.getUser().getUserId());
        dto.setRestaurantId(entity.getRestaurant().getRestaurantId());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setStatus(entity.getStatus());

        return dto;
    }
}
