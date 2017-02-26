package com.pawlak.main;
import com.pawlak.classes.CarList;

public class Main {
	public static void main(String[] args) {
		
		CarList cars = new CarList("c:/files/cars.txt");
		//METHODS TESTING
		//SORTING - OK
		//cars.sortByModel();
		//cars.sortByPrice();
		//cars.sortByEngineCapacity();
		//cars.sortByMileage();
		//cars.sortByNumberOfComponents();
		
		//REDUCE
		//cars.reducedCarsWitMileagehMoreThan(10000.0).forEach(System.out::println);
		
		//MODEL-MILEAGE
		//cars.getModelAndMileage().forEach(System.out::println);;
		
		//STATS
		//cars.showStatistics();
		
		//MAX PRICE USING OPTIONAL
		//cars.getMaxPrice();
		
		//CHECK COMPONENTS
		//cars.isComponentInAllCars("KLIMATYZACJA");
		
		
		//COMPONENTS SORTING
		//cars.sortedComponents();

		
	}
}
