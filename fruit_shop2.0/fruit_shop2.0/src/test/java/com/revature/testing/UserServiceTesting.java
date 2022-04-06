package com.revature.testing;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTesting {

	static UserRepository userRepo; 
	static UserService userService; 
	static List<User> users = new ArrayList<>(); 	
	static User u1; 
	static User u2; 
	static User u3; 
	
	@BeforeAll
	public static void set() {
		userRepo = mock(UserRepository.class); 
		userService = new UserService(userRepo); 
		//u1 = new User(1, "", " ", "ADMIN");
	}
	
	@Test 
	public void getAllUserTest() {
		
	}
	
	@Test 
	public void getUserByIdTest() {
		
	}
	
	@Test
	public void createNewUserTest() {
		
	}
	
	@Test
	public void updateUserTest() {
		
	}
	
	@Test void deleteUserTest() {
		
	}
}
