package com.ecom.servicesImp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecom.repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo uRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Optional<com.ecom.model.User> findUser = uRepo.findByUsername(username);
		 
		 com.ecom.model.User find = findUser.get();
		
		if(username.equals(find.getUsername())) {
			return new User(find.getUsername(), find.getPassword(), new ArrayList<>());
		}
		else
			throw new UsernameNotFoundException("User not found");
	}

	

}
