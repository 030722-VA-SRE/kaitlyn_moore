package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Fruit;

public interface FruitDao {
	// create and view
	public int createFruit(Fruit f);
	public List<Fruit> getFruits();
	
	// search for an item by some criteria
	public Fruit getItemById(int id);
	public Fruit getItemByName(String username);
	public List<Fruit> getItemByWeight(double weight);
	public List<Fruit> getByNameAndWeight(String n, double w);
	
	// update or deletes
	public boolean updateFruit(Fruit item);
	public boolean deleteItemById(int id);
}
