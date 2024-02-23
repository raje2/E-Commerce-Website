package com.ecom.services;

import java.util.List;

import com.ecom.exception.CartItemsNotFound;
import com.ecom.model.CartItem;

public interface CartItemServices {
	
	public List<CartItem> getAllCartItems();
    public CartItem getCartItemById(Long cartItemId)throws CartItemsNotFound;
    public CartItem createCartItem(CartItem cartItem);
    public CartItem updateCartItem(Long cartItemId, CartItem updatedCartItem)throws CartItemsNotFound;
    public void deleteCartItem(Long cartItemId)throws CartItemsNotFound;
}
