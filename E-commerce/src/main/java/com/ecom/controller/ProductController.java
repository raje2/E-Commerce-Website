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

import com.ecom.exception.ProductNotFoundException;
import com.ecom.model.Product;
import com.ecom.services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
    private ProductServices productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) throws ProductNotFoundException {
        return productService.getProductById(productId);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) throws ProductNotFoundException {
        return productService.updateProduct(productId, updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) throws ProductNotFoundException {
        productService.deleteProduct(productId);
    }


}
