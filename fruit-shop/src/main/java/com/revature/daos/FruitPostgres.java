package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Fruit;
import com.revature.util.ConnectionUtil;

public class FruitPostgres implements FruitDao{
	
	// get all items(fruits)
	public List<Fruit> getFruits() {
		String sql = "select * from fruit;";
		List<Fruit> cList = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			
			Statement s = c.createStatement(); 
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Fruit newFruit = new Fruit(); 
				newFruit.setVin(rs.getInt("vin")); 
				newFruit.setName(rs.getString("name"));
				newFruit.setDescription(rs.getString("description"));
				newFruit.setWeight(rs.getDouble("weight")); 
				cList.add(newFruit);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cList;
	}
	
	// create a new customer
	public Customer createNewCustomer(String name) {
		String sql = "select * from users where id = " + name + ";";
		
		return null;
	}
	
	// view an item by id(called it vin #)
	public Fruit getItemById(int id) {

		// ? is placeholder
		String sql = "select * from fruit where vin = ?;";
		Fruit f = null;
		
	// retrieve connection from db from ConnectionUtil
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			
			// ps is like a query passing sql statement to database
			PreparedStatement ps = c.prepareStatement(sql);
			// parameterizing the sql statement with id we are looking for 
			ps.setInt(1, id); 
			
			// execute the query from ps, & assigning the db's query result to rs
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				f = new Fruit();
				f.setVin(rs.getInt("vin"));
				f.setName(rs.getString("name"));
				f.setDescription(rs.getString("description"));
				f.setWeight(rs.getDouble("weight")); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}
	// search for an item by weight
		public List<Fruit> getItemByWeight(double weight) {
			String sql = "select * from fruit where weight = ?;"; 
			
			List<Fruit> fruit = new ArrayList<>(); 
			Fruit f = null; 
			try(Connection c = ConnectionUtil.getConnectionFromEnv()){
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setDouble(1, weight); 
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					f = new Fruit();
					f.setVin(rs.getInt("vin"));
					f.setName(rs.getString("name"));
					f.setDescription(rs.getString("description"));
					f.setWeight(rs.getDouble("weight")); 
					fruit.add(f); 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return fruit;
			
		}

	// search for an item by name
	public Fruit getItemByName(String name) {
		
		String sql = "select * from fruit where name = ?;"; 
		Fruit f = null; 
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name); 
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				f = new Fruit();
				f.setVin(rs.getInt("vin"));
				f.setName(rs.getString("name"));
				f.setDescription(rs.getString("description"));
				f.setWeight(rs.getDouble("weight")); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;	
		}

	// add a new item
		 public int createFruit(Fruit f) {
			int id = -1;
			String sql = "insert into fruit(name, description, weight) values (?, ?, ?) returning vin;";
			
			try(Connection c = ConnectionUtil.getConnectionFromEnv()){
				
				PreparedStatement ps = c.prepareStatement(sql);
			
					ps.setString(1, f.getName());
					ps.setString(2, f.getDescription());
					ps.setDouble(3, f.getWeight());	
					
					ResultSet rs = ps.executeQuery(); 

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return id;
			
		}	
	
	// update an item
		public boolean updateFruit(Fruit f) {
			String sql = "update fruit set name = ?, description = ?, weight = ? where vin = ?;";
			int rows = -1;
			try(Connection c = ConnectionUtil.getConnectionFromEnv()){
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(4, f.getVin());
				ps.setString(1, f.getName());
				ps.setString(2, f.getDescription());
				ps.setDouble(3, f.getWeight());
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if(rows == 0) {
				return false;
			}
			return true;
			
			
		}
	
	// delete an item by id
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Fruit> getByNameAndWeight(String name, double w) {
		String sql = "select * from fruit where name = ? and weight = ?;"; 
		Fruit f = null; 
		List<Fruit> fruitList = new ArrayList<>(); 
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name); 
			ps.setDouble(2, w);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				f = new Fruit();
				f.setVin(rs.getInt("vin"));
				f.setName(rs.getString("name"));
				f.setDescription(rs.getString("description"));
				f.setWeight(rs.getDouble("weight")); 
				fruitList.add(f); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fruitList;
	}
	
	

	

}
