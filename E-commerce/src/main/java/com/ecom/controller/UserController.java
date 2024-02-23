package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exception.UserNotFound;
import com.ecom.model.User;
import com.ecom.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserServices userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerAdmin(@RequestBody User user) throws UserNotFound {
		
		User saveAdmin = userService.registerUser(user);
		
		return new ResponseEntity<User>(saveAdmin,HttpStatus.CREATED);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> findAdminById(@PathVariable("id") Long id) throws UserNotFound{
		User user = userService.findUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
}
