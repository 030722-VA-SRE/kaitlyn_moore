package com.revature;

import java.sql.SQLException;
import java.util.List;

import com.revature.daos.FruitPostgres;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.Fruit;
import com.revature.service.Service;
import com.revature.util.ConnectionUtil;

import io.javalin.Javalin;



public class Driver {

	// private static List<Fruit> fruits = new ArrayList<>();
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionUtil.getConnectionFromEnv();
		FruitPostgres ct = new FruitPostgres();
		Service is = new Service(); 
		
		Javalin app = Javalin.create( (config) -> {
		});

		app.start();

		// view all items
		app.get("fruit", (ctx)->{
			String name = ctx.queryParam("name");
			String weight = ctx.queryParam("weight");
			
			try {
			if(name == null && weight == null) {
				ctx.json(ct.getFruits());
				}
			else if(name != null && weight == null) {
				ctx.json(is.getByName(name));
			}
			else if(name == null && weight != null) {
				double w = Double.parseDouble(weight);
				List<Fruit> f = is.getByWeight(w); 
				ctx.json(f);
			}
			else {
				double w = Double.parseDouble(weight);
				List<Fruit> f = is.getByNameAndWeight(name, w);
				ctx.json(f);
			}
			} catch(ItemNotFoundException e) {
				ctx.status(404);
				ctx.result("Item was not found.");
			}
			
			
		});
		
		// get items by id 
		app.get("fruit/{vin}", (ctx) ->{
			int id = Integer.parseInt(ctx.pathParam("vin"));
			try {
			Fruit fruit = is.getById(id);
			ctx.json(fruit);
			ctx.status(200);
			} catch(ItemNotFoundException e) {
				ctx.status(404);
				ctx.result("Item of id: " + id + " was not found."); 
				// logging, log this to file
			}
			
		});

		// add fruit to database,
		app.post("fruit", (ctx) ->{
				Fruit newFruit = ctx.bodyAsClass(Fruit.class);
				Service s = new Service(); 
				s.createFruit(newFruit);
				ctx.result("Created a new item: " + newFruit);
		}); 
		
		// update a fruit
		app.put("fruit", ctx->{
			Fruit updatedF = ctx.bodyAsClass(Fruit.class);
			Service s = new Service(); 
			s.updateFruit(updatedF); 
			ctx.result("Updated Fruit");
			
		});
			
		
		
		
		
	}
	
}
