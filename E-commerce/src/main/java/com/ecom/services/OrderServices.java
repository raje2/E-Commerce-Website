package com.ecom.services;

import java.util.List;

import com.ecom.exception.OrderNotFound;
import com.ecom.exception.UserNotFound;
import com.ecom.model.Order;

public interface OrderServices {
	
	public Order placeOrder(Long userId)throws UserNotFound;
    public List<Order> getOrderHistory(Long userId)throws OrderNotFound;
    public Order getOrderDetails(Long orderId)throws OrderNotFound;
    
}
