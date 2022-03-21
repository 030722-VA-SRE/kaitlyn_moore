package com.revature.models;

import java.util.Objects;

public class Fruit {
	private int vin; 
	private String name; 
	private String description; 
	private double weight;
	
	

	public Fruit() {
		
	}
	
	public Fruit(int vin, String name, String desc, double weight) {
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
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name, vin, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name) && vin == other.vin
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	@Override
	public String toString() {
		return "Fruit [vin=" + vin + ", name=" + name + ", description=" + description + ", weight=" + weight + "]";
	}
	
	
}
