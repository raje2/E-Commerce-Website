package com.ecom.servicesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exception.CartItemsNotFound;
import com.ecom.model.CartItem;
import com.ecom.repo.CartItemRepo;
import com.ecom.services.CartItemServices;

@Service
public class CartItemSerImp implements CartItemServices{
	
	@Autowired
	private CartItemRepo cartItemRepo;

	@Override
	public List<CartItem> getAllCartItems() {
		// TODO Auto-generated method stub
		return cartItemRepo.findAll();
	}

	@Override
	public CartItem getCartItemById(Long cartItemId) throws CartItemsNotFound {
		Optional<CartItem> find = cartItemRepo.findById(cartItemId);
		if(find.isPresent()) {
			return find.get();
		}else {
			throw new CartItemsNotFound("Cart items not found with ID :"+cartItemId);
		}
	}

	@Override
	public CartItem createCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartItemRepo.save(cartItem);
	}

	@Override
	public CartItem updateCartItem(Long cartItemId, CartItem updatedCartItem) throws CartItemsNotFound {
		CartItem existingCartItem = getCartItemById(cartItemId);
		
		if(existingCartItem != null) {
			existingCartItem.setProduct(updatedCartItem.getProduct());
            existingCartItem.setQuantity(updatedCartItem.getQuantity());
            existingCartItem.setOrder(updatedCartItem.getOrder());
            existingCartItem.setUser(updatedCartItem.getUser());
            
            return cartItemRepo.save(existingCartItem);
		}else {
			throw new CartItemsNotFound("Cart items not found with ID :"+cartItemId);
		}
	}

	@Override
	public void deleteCartItem(Long cartItemId) throws CartItemsNotFound {
		
        CartItem existingCartItem = getCartItemById(cartItemId);
		
		if(existingCartItem != null) {
			cartItemRepo.deleteById(cartItemId);
		}else {
			throw new CartItemsNotFound("Cart items not found with ID :"+cartItemId);
		}
	}
	
	

}
