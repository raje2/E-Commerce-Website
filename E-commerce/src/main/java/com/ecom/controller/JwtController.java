package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.healper.JwtUtil;
import com.ecom.model.JwtResponse;
import com.ecom.model.UserLoginDTO;
import com.ecom.servicesImp.CustomUserDetailsService;

@RestController
@RequestMapping("/api/auth")
public class JwtController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private CustomUserDetailsService cUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	

	@PostMapping(value = "/token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody UserLoginDTO userDTO) throws Exception{
		
		System.out.println(userDTO);
		
		try {
			//for authentication 
			authManager
			.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("invaild username/password");
		}
		
		UserDetails userDetails =  cUserDetailsService.loadUserByUsername(userDTO.getUsername());
		
		//generate token
		String token  = jwtUtil.generateToken(userDetails);
		System.out.println("JWT"+token);
		
		//{"token":"value"} return json format
		JwtResponse t = new JwtResponse(token);
		return new ResponseEntity<JwtResponse>(t,HttpStatus.OK);
		
	}
	
}
