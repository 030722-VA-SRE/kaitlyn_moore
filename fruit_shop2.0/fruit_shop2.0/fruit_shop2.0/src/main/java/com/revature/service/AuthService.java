package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDTO;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
@Service
public class AuthService {

	private UserRepository ur;

	@Autowired
	public AuthService(UserRepository ur) {
		super();
		this.ur = ur;
	} 
	
	public UserDTO login(String username, String password) {
		User principal = ur.findUserByUsername(username); 
		
		if(principal == null || !password.equals(principal.getPassword())) {
			return null; 
		}
		return new UserDTO(principal);
	}
	
	public String generateToken(UserDTO principal) {
		return principal.getId()+":"+principal.getUsername();
	}
	
}
