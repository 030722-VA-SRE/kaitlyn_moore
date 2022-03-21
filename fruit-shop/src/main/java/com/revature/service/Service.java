package com.revature.service;

import java.util.List;

import com.revature.daos.FruitDao;
import com.revature.daos.FruitPostgres;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.Fruit;


public class Service {


	private FruitDao cd; 
	public Service () {
		cd = new FruitPostgres(); 
	}
	
	public List<Fruit> getFruits() throws ItemNotFoundException {
		List<Fruit> fruits = cd.getFruits();
		if(fruits == null) {
			throw new ItemNotFoundException();
		}
		return cd.getFruits();
	}
	
	public Fruit getById(int id) throws ItemNotFoundException {
		Fruit f = cd.getItemById(id);
		
		if(f == null) {
			throw new ItemNotFoundException();
		}
		return f;
	}
	
	public Fruit getByName(String name) throws ItemNotFoundException {
		Fruit f = cd.getItemByName(name); 
		if(f == null) {
			throw new ItemNotFoundException();
		}
		return f;
	}
	
	public List<Fruit> getByWeight(double weight) throws ItemNotFoundException {
		List<Fruit> w = cd.getItemByWeight(weight);
		if(w == null) {
			throw new ItemNotFoundException();
		}
		return cd.getItemByWeight(weight);
	}
	
	public List<Fruit> getByNameAndWeight(String n, double w){
		
		return cd.getByNameAndWeight(n, w);
	}
	
	public boolean createFruit(Fruit f) {
		int id = f.getVin(); 
		if(id == f.getVin()) {
			cd.createFruit(f);
		}
		return false;
	}
	public boolean updateFruit(Fruit f) {
		return cd.updateFruit(f);
	}
}
