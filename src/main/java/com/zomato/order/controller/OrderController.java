package com.zomato.order.controller;

import com.zomato.order.dto.Order;
import com.zomato.order.entity.OrderEntity;
import com.zomato.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody Order order){
        OrderEntity order1 = orderService.createOrder(order);
        return  new ResponseEntity<>(order1, HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<OrderEntity> createOrder(@RequestParam Long orderId){
        OrderEntity order1 = orderService.getOrderById(orderId);
        return  new ResponseEntity<>(order1, HttpStatus.OK);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderEntity>> getAllOrders(){
        List<OrderEntity> ordersList = orderService.getAllOrders();
        return  new ResponseEntity<>(ordersList, HttpStatus.OK);
    }
}
