package com.zomato.order.serviceimpl;

import com.zomato.exception.ResourceNotFoundException;
import com.zomato.order.dto.Order;


import com.zomato.order.entity.OrderEntity;
import com.zomato.order.repository.OrderRepository;
import com.zomato.order.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderEntity createOrder(Order order) {
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
        return orderRepo.save(orderEntity);
    }

    @Override
    public OrderEntity getOrderById(Long orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<OrderEntity> getOrderByUserId(Long userId) {

        List<OrderEntity> orders = orderRepo.findByUserId(userId);
        if (orders.isEmpty()) {
            throw new ResourceNotFoundException("No orders found for user " + userId);
        }
        return orders;
    }
}
