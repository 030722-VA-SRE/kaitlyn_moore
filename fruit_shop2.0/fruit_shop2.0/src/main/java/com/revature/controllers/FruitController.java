package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.FruitNotFoundException;
import com.revature.models.Fruit;
import com.revature.service.FruitService;

@RestController
@RequestMapping("/fruit")

public class FruitController {

	private FruitService fs;
	private static final Logger LOG = LoggerFactory.getLogger(FruitController.class);

	@Autowired
	public FruitController(FruitService fs) {
		super();
		this.fs = fs; 
	} 
	
	@GetMapping
	public ResponseEntity<List<Fruit>> getAll(@RequestParam(name = "name", required = false) String name){
		
		if (name != null) {
			List<Fruit> fruits = new ArrayList<>();
			fruits.add(fs.getFruitByName(name));
			return new ResponseEntity<>(fruits, HttpStatus.OK);
		}
		return new ResponseEntity<>(fs.getAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fruit> getById(@PathVariable int id) throws FruitNotFoundException{
		return new ResponseEntity<>(fs.getFruitById(id), HttpStatus.OK); 
	}
	
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody Fruit fruit){
		Fruit f = fs.createFruit(fruit);
		return new ResponseEntity<>("Fruit " + f.getName() + " has been created. ", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit, @PathVariable("id") int id){
		return new ResponseEntity<>(fs.updateFruit(id, fruit), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) throws FruitNotFoundException{
		fs.deleteFruit(id);
		return new ResponseEntity<>("User by Id #:  " + id + "was deleted.", HttpStatus.OK);
	}
}
