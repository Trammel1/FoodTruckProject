package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int lastID = 41;
	private int uniqueID;
	private String truckName;
	private String foodType;
	private int rating;

	{
		uniqueID = lastID + 1;
		lastID = uniqueID;
	}

	public FoodTruck() {
	}

	public FoodTruck(String truckName, String foodType, int rating) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String toString() {
		String truckInfo = "Truck ID: " + uniqueID + "  Name: " + truckName + "  Food type: " + foodType + "  Rating: "
				+ rating + "\n";
		return truckInfo;
	}

}