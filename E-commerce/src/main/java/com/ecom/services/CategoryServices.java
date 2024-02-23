package com.ecom.services;

import java.util.List;

import com.ecom.exception.CategoryNotFound;
import com.ecom.model.Category;

public interface CategoryServices {
	
	public List<Category> getAllCategories();
    public Category getCategoryById(Long categoryId)throws CategoryNotFound;
    public Category createCategory(Category category);

    public Category updateCategory(Long categoryId, Category updatedCategory)throws CategoryNotFound;

    public void deleteCategory(Long categoryId)throws CategoryNotFound;
}
