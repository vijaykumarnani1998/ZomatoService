package com.zomato.service;

import com.zomato.dto.Order;
import com.zomato.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    public OrderEntity createOrder(Order order);

    public OrderEntity getOrderById(Long orderId);

    public List<OrderEntity> getAllOrders();

}
