package com.ecom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Long>{
	List<CartItem> findByUserId(Long userId);

}
