package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

		private UserService us;
		private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

		
		@Autowired
		public UserController(UserService us) {
			super();
			this.us = us;
		} 
		
		
		@GetMapping
		public ResponseEntity<List<UserDTO>> getAll(){
			MDC.put("requestId", UUID.randomUUID().toString());
			
			List<User> users = us.getAll();
			List<UserDTO> protectedUsers = new ArrayList<>();
			for(User user : users) {
				protectedUsers.add(new UserDTO(user));
			}
			
			LOG.info("all users retrieved.");
			return new ResponseEntity<>(protectedUsers, HttpStatus.OK);
			
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<UserDTO> getById(@PathVariable("id") int id, @RequestHeader("Authorization") String token) throws UserNotFoundException {

			// this just checks if the token is null, not if it has the right value
			if (token == null) {
				LOG.info("Cannot log in, must enter a username & password. ");
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
			LOG.info("user by id: " + id + "retrieved.");
			return new ResponseEntity<>(us.getUserById(id), HttpStatus.OK);

		}

		@PostMapping
		public ResponseEntity<String> createUser(@RequestBody User user) {
			User u = us.createUser(user);
			LOG.info("new user by id: "+ u.getId() + " created." );
			return new ResponseEntity<>("User " + u.getUsername() + " has been created.", HttpStatus.CREATED);
		}

		@PutMapping("/{id}")
		public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") int id) {
			LOG.info("user by id: " + user.getId() + " has been updated. ");
			return new ResponseEntity<>(us.updateUser(id, user), HttpStatus.CREATED);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<String> DeleteById(@PathVariable("id") int id) throws UserNotFoundException {
			us.deleteUser(id);
			LOG.info("user by id: " + id + " has been deleted.");
			return new ResponseEntity<>("User was deleted", HttpStatus.OK);
		}
		
		
		
}
