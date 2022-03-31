package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.FruitRepository;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository ur;
	private FruitRepository fr;
	
	@Autowired
	public UserService(UserRepository ur, FruitRepository fr) {
		super();
		this.ur = ur;
		this.fr = fr;
	} 
	
	public UserDTO getUserById(int id) throws UserNotFoundException{
		User user = ur.findById(id).orElseThrow(UserNotFoundException::new);
		return new UserDTO(user);
	}
	

	@Transactional
	public User createUser(User newUser) {
		return ur.save(newUser); 
	}
	
	public List<User> getAll(){
		return ur.findAll();
	}
	
	@Transactional 
	public User updateUser(int id, User user) {
		return ur.save(user);
	}
	
	@Transactional
	public void deleteUser(int id) throws UserNotFoundException{
		getUserById(id); 
		ur.deleteById(id);
	}
}