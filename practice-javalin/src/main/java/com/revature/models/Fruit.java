package com.revature.models;

public class Fruit {

	private int vin; 
	private String name; 
	private String description; 
	private float weight;
	
	public Fruit() {
		
	}
	
	public Fruit(int vin, String name, String desc, float weight) {
		this.vin = vin; 
		this.name = name; 
		this.description = desc;
		this.weight = weight; 
	}
	
	public int getVin() {
		return vin; 
	}
	
	public String getName() {
		return name; 
	}
	
	public String getDescription() {
		return description; 
	}
	
	public void setVin(int vin) {
		this.vin = vin;
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public float getWeight() {
		return weight; 
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Fruit [vin: " + vin + "/nname: " + name + "/ndescription" + description + "]";
	}
}
