package com.ecom.services;

import com.ecom.exception.UserNotFound;
import com.ecom.model.User;

public interface UserServices {
	public User registerUser(User user) throws UserNotFound;
	public User findUserById(Long id) throws UserNotFound;
}
