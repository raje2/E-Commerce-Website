package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
