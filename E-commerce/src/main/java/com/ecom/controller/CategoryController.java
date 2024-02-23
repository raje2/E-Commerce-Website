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

import com.ecom.exception.CategoryNotFound;
import com.ecom.model.Category;
import com.ecom.services.CategoryServices;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	    @Autowired
	    private CategoryServices categoryService;

	    @GetMapping
	    public List<Category> getAllCategories() {
	        return categoryService.getAllCategories();
	    }

	    @GetMapping("/{categoryId}")
	    public Category getCategoryById(@PathVariable Long categoryId) throws CategoryNotFound {
	        return categoryService.getCategoryById(categoryId);
	    }

	    @PostMapping
	    public Category createCategory(@RequestBody Category category) {
	        return categoryService.createCategory(category);
	    }

	    @PutMapping("/{categoryId}")
	    public Category updateCategory(@PathVariable Long categoryId, @RequestBody Category updatedCategory) throws CategoryNotFound {
	        return categoryService.updateCategory(categoryId, updatedCategory);
	    }

	    @DeleteMapping("/{categoryId}")
	    public void deleteCategory(@PathVariable Long categoryId) throws CategoryNotFound {
	        categoryService.deleteCategory(categoryId);
	    }

}
