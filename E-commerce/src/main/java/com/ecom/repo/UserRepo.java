package com.ecom.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
