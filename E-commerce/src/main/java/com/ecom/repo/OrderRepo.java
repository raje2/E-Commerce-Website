package com.ecom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{
   List<Order> findByUserId(Long userId);
}
