package com.pawlak.classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class CarList {
	private List<Car> cars;

	public CarList(String fileName) {
		List<Car> carsFromFile = new ArrayList<>();

		File file = new File(fileName);

		try {
			Scanner scanner = new Scanner(file);
			List<String> tempList = new ArrayList<>();
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				tempList.add(line);
			}

			for (String s : tempList) {
				Object[] elements = s.split(" ");
				String model = (String) elements[0];
				double price = Double.parseDouble((String) elements[1]);
				double engineCapacity = Double.parseDouble((String) elements[2]);
				double mileage = Double.parseDouble((String) elements[3]);
				String components = (String) elements[4];
				String[] componentsTemp = components.split(";");
				List<String> carComponents = new ArrayList<>(Arrays.asList(componentsTemp));
				Car car = new Car(model, price, engineCapacity, mileage, carComponents);
				carsFromFile.add(car);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cars = carsFromFile;

	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarList other = (CarList) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car list " + cars;
	}

	public List<Car> sortByModel() {
		List<Car> sortedCars = this.cars.stream().sorted((e1, e2) -> {
			return e1.getModel().compareTo(e2.getModel());
		}).collect(Collectors.toList());

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("c:/files/output/sortByModel.txt"))) {
			int index = 0;
			for (Car c : sortedCars) {
				String car = sortedCars.get(index).toString();
				writer.write(car + System.lineSeparator());
				index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sortedCars;
	}

	public List<Car> sortByPrice() {

		List<Car> sortedCars = cars.stream().sorted((e1, e2) -> {
			return Double.compare(e1.getPrice(), e2.getPrice());
		}).collect(Collectors.toList());

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("c:/files/output/sortByPrice2.txt"))) {
			int index = 0;
			for (Car c : sortedCars) {
				String car = sortedCars.get(index).toString();
				writer.write(car + System.lineSeparator());
				index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sortedCars;
	}

	public List<Car> sortByEngineCapacity() {
		List<Car> sortedCars = this.cars.stream().sorted((e1, e2) -> {
			return Double.compare(e1.getEngineCapacity(), e2.getEngineCapacity());
		}).collect(Collectors.toList());

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("c:/files/output/sortByEngineCapacity.txt"))) {
			int index = 0;
			for (Car c : sortedCars) {
				String car = sortedCars.get(index).toString();
				writer.write(car + System.lineSeparator());
				index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sortedCars;
	}

	public List<Car> sortByMileage() {
		List<Car> sortedCars = this.cars.stream().sorted((e1, e2) -> {
			return Double.compare(e1.getMileage(), e2.getMileage());
		}).collect(Collectors.toList());

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("c:/files/output/sortByMileage.txt"))) {
			int index = 0;
			for (Car c : sortedCars) {
				String car = sortedCars.get(index).toString();
				writer.write(car + System.lineSeparator());
				index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sortedCars;
	}

	public List<Car> sortByNumberOfComponents() {
		List<Car> sortedCars = this.cars.stream().sorted((e1, e2) -> {
			return Integer.compare(e1.getComponents().size(), e2.getComponents().size());
		}).collect(Collectors.toList());

		try (BufferedWriter writer = Files
				.newBufferedWriter(Paths.get("c:/files/output/sortByNumberOfComponents.txt"))) {
			int index = 0;
			for (Car c : sortedCars) {
				String car = sortedCars.get(index).toString();
				writer.write(car + System.lineSeparator());
				index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sortedCars;
	}

	public List<Car> reducedCarsWitMileagehHigherThan(double mileage) {
		List<Car> reducedCars = this.cars.stream().filter((e) -> e.getMileage() > mileage).collect(Collectors.toList());

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("c:/files/output/reducedCarsByMileage.txt"))) {
			int index = 0;
			for (Car c : reducedCars) {
				String car = reducedCars.get(index).toString();
				writer.write(car + System.lineSeparator());
				index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reducedCars;
	}

	public List<String> getModelAndMileage() {
		List<String> modelAndMileageCars = this.cars.stream().map((e) -> e.getModel() + "-" + e.getMileage())
				.collect(Collectors.toList());

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("c:/files/output/getModelAndMileage.txt"))) {
			int index = 0;
			for (String s : modelAndMileageCars) {
				String car = modelAndMileageCars.get(index).toString();
				writer.write(car + System.lineSeparator());
				index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelAndMileageCars;
	}

	public void showStatistics() {
		System.out.println("::Price statitstics:");
		double avaragePrice = this.cars.stream().collect(Collectors.averagingDouble(e -> e.getPrice()));
		System.out.println(":Avarage: " + avaragePrice);
		double minPrice = this.cars.stream().collect(Collectors.summarizingDouble(e -> e.getPrice())).getMin();
		System.out.println(":Minimum " + minPrice);
		double maxPrice = this.cars.stream().collect(Collectors.summarizingDouble(e -> e.getPrice())).getMax();
		System.out.println(":Maximum: " + maxPrice + "\n");

		System.out.println("::Mileage statitstics:");
		double avarageMileage = this.cars.stream().collect(Collectors.averagingDouble(e -> e.getMileage()));
		System.out.println(":Avarage: " + avarageMileage);
		double minMileage = this.cars.stream().collect(Collectors.summarizingDouble(e -> e.getMileage())).getMin();
		System.out.println(":Minimum: " + minMileage);
		double maxMileage = this.cars.stream().collect(Collectors.summarizingDouble(e -> e.getMileage())).getMax();
		System.out.println(":Maximum: " + maxMileage + "\n");

		System.out.println("::Engine capacity statitstics:");
		double avarageEngineCapacity = this.cars.stream()
				.collect(Collectors.averagingDouble(e -> e.getEngineCapacity()));
		System.out.println(":Avarage: " + avarageEngineCapacity);
		double minEngineCapacity = this.cars.stream().collect(Collectors.summarizingDouble(e -> e.getEngineCapacity()))
				.getMin();
		System.out.println(":Minimum: " + minEngineCapacity);
		double maxEngineCapacity = this.cars.stream().collect(Collectors.summarizingDouble(e -> e.getEngineCapacity()))
				.getMax();
		System.out.println(":Maximum: " + maxEngineCapacity);
	}

	public double getMaxPrice() {
		Stream<Car> carsList = cars.stream();

		Optional<Car> max = carsList.max((e1, e2) -> Double.compare(e1.getPrice(), e2.getPrice()));

		if (max.isPresent()) {
			System.out.println(max.get().getModel() + ":" + max.get().getPrice());
		}

		return max.get().getPrice();
	}

	public void isComponentInAllCars(String component) {
		List<Car> carsWithComponent = cars;
		for (Car c : carsWithComponent) {
			List<String> temp = c.getComponents().stream().filter(e -> e.equalsIgnoreCase(component))
					.collect(Collectors.toList());
			c.setComponents(temp);
		}
		carsWithComponent.forEach(System.out::println);

	}

	public List<Car> sortedComponents() {
		for (Car c : cars) {
			List<String> sorted = c.getComponents().stream().sorted((c1, c2) -> {
				return c1.compareTo(c2);
			}).collect(Collectors.toList());
			c.setComponents(sorted);
		}

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("c:/files/output/sortedComponents.txt"))) {
			int index = 0;
			for (Car c : cars) {
				String car = cars.get(index).toString();
				writer.write(car + System.lineSeparator());
				index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;

	}

}
