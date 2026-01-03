package com.zomato.order.service;

import com.zomato.order.dto.Order;
import com.zomato.order.entity.OrderEntity;


import java.util.List;

public interface OrderService {

    public OrderEntity createOrder(Order order);

    public OrderEntity getOrderById(Long orderId);

    public List<OrderEntity> getAllOrders();

    public List<OrderEntity> getOrderByUserId(Long userId);

}
