package com.ecom.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.exception.UserNotFound;
import com.ecom.model.User;
import com.ecom.repo.UserRepo;
import com.ecom.services.UserServices;


@Service
public class UserServiceImpl implements UserServices{
	
	@Autowired
	private UserRepo aRepo;
	
	@Override
	public User registerUser(User user) throws UserNotFound {
		return aRepo.save(user);
	}


	@Override
	public User findUserById(Long id) throws UserNotFound {
		
		return aRepo.findById(id).orElseThrow(()->new UserNotFound("Account does not found with id: "+id));
		
	}



	

}
