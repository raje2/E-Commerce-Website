package com.ecom.servicesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exception.ProductNotFoundException;
import com.ecom.model.Product;
import com.ecom.repo.ProductRepo;
import com.ecom.services.ProductServices;

@Service
public class ProductSerImp implements ProductServices{
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long productId) throws ProductNotFoundException {
		
		Optional<Product> find =  productRepo.findById(productId);
		
		if(find.isPresent()) {
			return find.get();
		}
		else {
	        throw new ProductNotFoundException("Product not found with ID: " + productId);
	    }
	}

	@Override
	public Product updateProduct(Long productId, Product updatedProduct) throws ProductNotFoundException {
		
		 Product existingProduct = getProductById(productId);
	        if (existingProduct != null) {
	            existingProduct.setTitle(updatedProduct.getTitle());
	            existingProduct.setPrice(updatedProduct.getPrice());
	            existingProduct.setDescription(updatedProduct.getDescription());
	            existingProduct.setAvailability(updatedProduct.isAvailability());
	            existingProduct.setCategory(updatedProduct.getCategory());
	            return productRepo.save(existingProduct);
	        }else {
		        throw new ProductNotFoundException("Product not found with ID: " + productId);
		    }
		
	}

	@Override
	public void deleteProduct(Long productId) throws ProductNotFoundException {
		
      Optional<Product> find =  productRepo.findById(productId);
		
		if(find.isPresent()) {
			productRepo.deleteById(productId);;
		}
		else {
	        throw new ProductNotFoundException("Product not found with ID: " + productId);
	    }
		
	}
	
	

}
