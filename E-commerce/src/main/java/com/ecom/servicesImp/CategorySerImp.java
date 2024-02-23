package com.ecom.servicesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exception.CategoryNotFound;
import com.ecom.model.Category;
import com.ecom.repo.CategoryRepo;
import com.ecom.services.CategoryServices;

@Service
public class CategorySerImp implements CategoryServices{
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(Long categoryId) throws CategoryNotFound {
		
		Optional<Category> find = categoryRepo.findById(categoryId);
		
		if(find.isPresent()) {
			return find.get();
		}else {
			throw new CategoryNotFound("Category not found with ID :"+categoryId);
		}
	}

	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Long categoryId, Category updatedCategory) throws CategoryNotFound {
		
        Category find = getCategoryById(categoryId);
		
		if(find!=null) {
			find.setName(updatedCategory.getName());
            // Additional fields can be updated
            return categoryRepo.save(find);
		}else {
			throw new CategoryNotFound("Category not found with ID :"+categoryId);
		}
	}

	@Override
	public void deleteCategory(Long categoryId) throws CategoryNotFound {
		
        Category find = getCategoryById(categoryId);
		
		if(find!=null) {
			categoryRepo.deleteById(categoryId);
		}else {
			throw new CategoryNotFound("Category not found with ID :"+categoryId);
		}
	}

}
