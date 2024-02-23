package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exception.CartItemsNotFound;
import com.ecom.model.CartItem;
import com.ecom.services.CartItemServices;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {
	
    @Autowired
    private CartItemServices cartItemService;

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/{cartItemId}")
    public CartItem getCartItemById(@PathVariable Long cartItemId) throws CartItemsNotFound {
        return cartItemService.getCartItemById(cartItemId);
    }

    @PostMapping
    public CartItem createCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.createCartItem(cartItem);
    }

    @PutMapping("/{cartItemId}")
    public CartItem updateCartItem(@PathVariable Long cartItemId, @RequestBody CartItem updatedCartItem) throws CartItemsNotFound {
        return cartItemService.updateCartItem(cartItemId, updatedCartItem);
    }

    @DeleteMapping("/{cartItemId}")
    public void deleteCategory(@PathVariable Long cartItemId) throws CartItemsNotFound {
        cartItemService.deleteCartItem(cartItemId);
    }

}
