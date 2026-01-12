package com.zomato.order.controller;

import com.zomato.order.dto.OrderDto;
import com.zomato.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zomato.order.entity.OrderEntity;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto order){
        OrderDto order1 = orderService.createOrder(order);
        return  new ResponseEntity<>(order1, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<OrderDto> createOrder(@RequestParam Long orderId){
        OrderDto order1 = orderService.getOrderById(orderId);
        return  new ResponseEntity<>(order1, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto> ordersList = orderService.getAllOrders();
        return  new ResponseEntity<>(ordersList, HttpStatus.OK);
    }
}
