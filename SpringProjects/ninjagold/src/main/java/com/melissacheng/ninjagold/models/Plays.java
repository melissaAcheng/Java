package com.melissacheng.ninjagold.models;

import java.util.Date;

public class Plays {
	
	// Member Variables
	private int gold;
	private String location;
	private Date date;
	
	public static int totalGold = 0;
	
	
	// Constructor
	public Plays(int gold, String location) {
		this.gold = gold;
		this.location = location;
		this.date = new Date();
		
		totalGold += gold;
	}
	
	// Getters and Setters
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	} 
	
	public static int goldCount() {
		return totalGold;
	}
	
}
