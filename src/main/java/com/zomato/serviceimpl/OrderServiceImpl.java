package com.zomato.serviceimpl;

import com.zomato.dto.Order;
import com.zomato.entity.OrderEntity;
import com.zomato.repository.OrderRepository;
import com.zomato.service.OrderService;
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
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }
}
