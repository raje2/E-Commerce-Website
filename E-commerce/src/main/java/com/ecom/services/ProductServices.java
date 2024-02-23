package com.ecom.services;

import java.util.List;

import com.ecom.exception.ProductNotFoundException;
import com.ecom.model.Product;

public interface ProductServices {
	
	

    public Product createProduct(Product product);
    
    public List<Product> getAllProducts();
	
	public Product getProductById(Long productId) throws ProductNotFoundException;

    public Product updateProduct(Long productId, Product updatedProduct) throws ProductNotFoundException;
    
    public void deleteProduct(Long productId) throws ProductNotFoundException;
    
}
