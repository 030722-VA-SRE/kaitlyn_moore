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
	public FruitService (FruitRepository fr) {
		super();
		this.fr = fr;
	}
	
	public List<Fruit> getAll(){
		return fr.findAll(); 
	}
	
	public Fruit getFruitById(int id) throws FruitNotFoundException{
		Fruit f = fr.findById(id).orElseThrow(FruitNotFoundException::new); 
		return f; 
	}
	
	public Fruit getFruitByName(String name) throws FruitNotFoundException{
		Fruit fruit = fr.findFruitByName(name); 
		return fruit;
	}
	
	@Transactional
	public Fruit createFruit(Fruit newFruit) {
		return fr.save(newFruit); 
	}
	
	@Transactional
	public Fruit updateFruit(int id, Fruit fruit) throws FruitNotFoundException{
		return fr.save(fruit); 
	}
	 
	@Transactional 
	public boolean deleteFruit(int id) throws FruitNotFoundException{
		getFruitById(id); 
		fr.deleteById(id);
		return true; 
	}
}
