
public class Main {
	public static void main(String[] args) {
		
		CarList cars = new CarList("c:/files/cars.txt");
		
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
		//cars.showStatistics();
		System.out.println(cars.isComponentInAllCars("GPS"));
		System.out.println("--DONE--");
		
	}
}
