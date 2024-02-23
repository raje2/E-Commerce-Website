package com.ecom.servicesImp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exception.OrderNotFound;
import com.ecom.exception.UserNotFound;
import com.ecom.model.CartItem;
import com.ecom.model.Order;
import com.ecom.repo.CartItemRepo;
import com.ecom.repo.OrderRepo;
import com.ecom.repo.UserRepo;
import com.ecom.services.OrderServices;

@Service
public class OrderSerImp implements OrderServices{
	
	@Autowired
    private OrderRepo orderRepository;

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private UserRepo userRepo;

    public Order placeOrder(Long userId) throws UserNotFound {
        // Fetch the user's cart items
        List<CartItem> cartItems = cartItemRepo.findByUserId(userId);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cannot place an order with an empty cart");
        }

        // Create a new order
        Order order = new Order();
        order.setUser(userRepo.findById(userId)
                .orElseThrow(() -> new UserNotFound("User not found with ID: " + userId)));
        order.setOrderDate(new Date());
        order.setCartItems(cartItems);
        order.setTotalAmount(calculateTotalAmount(cartItems)); 
        
        orderRepository.save(order);

        // Clear the user's cart after placing the order
        cartItemRepo.deleteAll(cartItems);

        return order;
    }

    public List<Order> getOrderHistory(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order getOrderDetails(Long orderId) throws OrderNotFound {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFound("Order not found with ID: " + orderId));
    }


    private Double calculateTotalAmount(List<CartItem> cartItems) {
        // calculate the total amount based on cart items
        return cartItems.stream()
                .mapToDouble(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity())
                .sum();
    }

}
