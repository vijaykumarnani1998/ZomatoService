package com.zomato.order.service;

import com.zomato.order.dto.OrderDto;
import com.zomato.order.entity.OrderEntity;


import java.util.List;

public interface OrderService {

    public OrderDto createOrder(OrderDto order);

    public OrderDto getOrderById(Long orderId);

    public List<OrderDto> getAllOrders();

    public List<OrderDto> getOrderByUserId(Long userId);

}
