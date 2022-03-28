package com.skilldistillery.foodtruck.entities;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		FoodTruck[] listOfTrucks = new FoodTruck[5];
		int rating = 0;


		boolean keepGoing = true;
		int count = 0;

		System.out.println("Please enter up to 5 food trucks!");
		System.out.println();
		
		while (keepGoing && count < listOfTrucks.length) {

 			System.out.println("To view menu, enter \"quit\" in truck names");
 			System.out.println();
			System.out.print("Please enter food truck name: ");
			String truckName = kb.nextLine();

			if (truckName.equalsIgnoreCase("Quit")) {
				keepGoing = false;
				break;
			}
			
			
			System.out.print("Please enter the trucks food type: ");
			String foodType = kb.nextLine();

			System.out.print("What's the rating for the truck? Please choose a number 1-5: ");
			rating = kb.nextInt();
			kb.nextLine(); 

			while (rating <= 0 || rating > 5) {
				System.out.println();
				System.out.println("Rating must be between 1-5");
				System.out.print("Please enter a vaild rating: ");
				rating = kb.nextInt();
				kb.nextLine(); 
			}

			for (int i = count; i == count; i++) {
				if (listOfTrucks[i] == null) {
					listOfTrucks[i] = new FoodTruck(truckName, foodType, rating);
				}
			}

			count++;
			System.out.println();
		}
		
		keepGoing = true;
		FoodTruckApp app = new FoodTruckApp();
		
		while (keepGoing) {
			
			System.out.println("**********Menu************");
			System.out.println("1. List all food trucks");
			System.out.println("2. See average rating of all food trucks");
			System.out.println("3. Highest rated food truck");
			System.out.println("4. Quit");
			
			String choice;
			
			do {
				choice = kb.next();
				switch (choice) {
				case "1":
				case "all":
					app.listAllTrucks(listOfTrucks);
					break;
				case "2":
				case "average": 
					Double average = app.averageRating(listOfTrucks);
					System.out.println("Average Rating: " + average);
					break;
				case "3":
				case "highest-rated":
					FoodTruck highest = app.highestRated(listOfTrucks);
					System.out.println("Highest rated: " + highest.toString());
					break;
				case "4":
				case "quit":
				case "Quit":
					keepGoing = false;
					break;
				default:
					System.out.println("Please enter a vaild choice");
					choice = null;
				}
				
			} while (choice == null);
			System.out.println();
		}

		
		kb.close();
	}
	
	public FoodTruck highestRated(FoodTruck[] listOfTrucks) {
		FoodTruck highest = listOfTrucks[0];
		for (int i = 0; i < listOfTrucks.length; i++) {
			if (listOfTrucks[i] != null) {
				if (listOfTrucks[i].getRating() > highest.getRating()) {
					highest = listOfTrucks[i];
					
				}
			}

		}
		return highest;
	}
	
	
	public Double averageRating(FoodTruck[] listOfTrucks) {
		double average = 0;
		int numTrucks = 0;
		for (int i = 0; i < listOfTrucks.length; i++) {
			if (listOfTrucks[i] == null) {
				continue;
			}
			average += listOfTrucks[i].getRating();
			numTrucks++;
		}
		average = average / numTrucks;
		return average;

	}
	
	public void listAllTrucks(FoodTruck[] listOfTrucks) {

		for (int i = 0; i < listOfTrucks.length; i++) {
			if (listOfTrucks[i] != null) {
				System.out.println(listOfTrucks[i].toString());
			}
		}

	}

}