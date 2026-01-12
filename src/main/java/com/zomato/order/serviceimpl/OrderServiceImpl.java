package com.zomato.order.serviceimpl;

import com.zomato.exception.ResourceNotFoundException;
import com.zomato.order.dto.OrderDto;


import com.zomato.order.entity.OrderEntity;
import com.zomato.order.repository.OrderRepository;
import com.zomato.order.service.OrderService;
import com.zomato.restaurant.entity.RestaurantEntity;
import com.zomato.restaurant.repository.RestaurantRepository;
import com.zomato.user.entity.UserEntity;
import com.zomato.user.repository.UserRepository;
import com.zomato.util.CommonUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    CommonUtil commonUtil;

    @Override
    public OrderDto createOrder(OrderDto order) {
        UserEntity user = userRepository.findById(order.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        RestaurantEntity restaurant = restaurantRepository.findById(order.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        // 2️⃣ To perform save operation we need entity
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(user);
        orderEntity.setRestaurant(restaurant);
        orderEntity.setTotalAmount(order.getTotalAmount());
        orderEntity.setStatus(order.getStatus());

        // 3️⃣ Save
        OrderEntity savedEntity = orderRepo.save(orderEntity);

        // 4️⃣ Convert Entity → DTO
        return commonUtil.mapEntityToDto(savedEntity);

    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        OrderEntity entity = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        return commonUtil.mapEntityToDto(entity);
    }

    @Override
    public List<OrderDto> getAllOrders() {

        List<OrderEntity> entities = orderRepo.findAll();
        List<OrderDto> list = new ArrayList<>();

        for (OrderEntity entity : entities) {
            OrderDto orderDto = commonUtil.mapEntityToDto(entity);
            list.add(orderDto);
        }

        return list;
    }

    @Override
    public List<OrderDto> getOrderByUserId(Long userId) {
        List<OrderEntity> entityList = orderRepo.findByUser_UserId(userId);

        if (entityList.isEmpty()) {
            throw new ResourceNotFoundException("No orders found for user " + userId);
        }

        List<OrderDto> list = new ArrayList<>();
        for (OrderEntity entity : entityList) {
            OrderDto orderDto = commonUtil.mapEntityToDto(entity);
            list.add(orderDto);
        }

        return list;
    }
}
