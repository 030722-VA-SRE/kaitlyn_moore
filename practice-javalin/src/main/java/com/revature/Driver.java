package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Fruit;

import io.javalin.Javalin;

public class Driver {

	private static List<Fruit> fruits = new ArrayList<>();
	
		public static void main(String[] args) {
			Javalin app = Javalin.create( (config) -> {
				
			});

			app.start();
			
			Fruit f1 = new Fruit(111, "Apple", "Red Crisp"); 
			Fruit f2 = new Fruit(222, "Grapes", "Green Grapes");
			Fruit f3 = new Fruit(111, "Apple", "Red Crisp");

			fruits.add(f1);
			fruits.add(f2);
			fruits.add(f3);
			
			app.get("fruit", (ctx)->{
				ctx.result("These are our fruits");
			});
		}
}
