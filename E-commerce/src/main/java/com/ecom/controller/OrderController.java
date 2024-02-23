package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exception.OrderNotFound;
import com.ecom.exception.UserNotFound;
import com.ecom.model.Order;
import com.ecom.services.OrderServices;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderServices orderService;

    @PostMapping("/place-order/{userId}")
    public Order placeOrder(@PathVariable Long userId) throws UserNotFound {
        return orderService.placeOrder(userId);
    }

    @GetMapping("/order-history/{userId}")
    public List<Order> getOrderHistory(@PathVariable Long userId) throws OrderNotFound {
        return orderService.getOrderHistory(userId);
    }

    @GetMapping("/{orderId}")
    public Order getOrderDetails(@PathVariable Long orderId) throws OrderNotFound {
        return orderService.getOrderDetails(orderId);
    }

    
   
//    @DeleteMapping("/{orderId}")
//    public void deleteOrder(@PathVariable Long orderId) {
//        orderService.deleteOrder(orderId);
//    }
}
