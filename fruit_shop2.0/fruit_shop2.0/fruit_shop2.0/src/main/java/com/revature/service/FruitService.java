package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.FruitNotFoundException;
import com.revature.models.Fruit;
import com.revature.repositories.FruitRepository;
import com.revature.repositories.UserRepository;

@Service
public class FruitService {

	@Autowired
	private UserRepository ur;
	private FruitRepository fr;
	public FruitService(UserRepository ur, FruitRepository fr) {
		super();
		this.ur = ur;
		this.fr = fr;
	}
	
	public List<Fruit> getAll(){
		return fr.findAll(); 
	}
	
	public Fruit getFruitById(int id) throws FruitNotFoundException{
		Fruit f = fr.findById(id).orElseThrow(FruitNotFoundException::new); 
		return f; 
	}
	
	public Fruit getFruitByName(String name){
		Fruit fruit = fr.findFruitByName(name); 
		return fruit;
	}
	
	
	
	@Transactional
	public Fruit createFruit(Fruit newFruit) {
		return fr.save(newFruit); 
	}
	
	@Transactional
	public Fruit updateFruit(int id, Fruit fruit) {
		return fr.save(fruit); 
	}
	 
	@Transactional 
	public void deleteFruit(int id) throws FruitNotFoundException{
		getFruitById(id); 
		fr.deleteById(id);
	}
	
	
	
	
	
	
}
