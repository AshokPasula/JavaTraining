package car_rental_system;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class RentalSystem {
	private static RentalService rentalService = new RentalService();
	private static Rental rental;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String carType = "Car";
		String motorCycleType = "MotorCycle";
		String bicycleType = "Bicycle";
		boolean exit = false;

		while (!exit) {
			System.out.println("Rental System");
			System.out.println("1. Add vechiles");
			System.out.println("2. List available vechiles");
			System.out.println("3. Rent a Vechile");
			System.out.println("4. Calculate rental cost");
			System.out.println("5. Return Vehicle");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\nEnter vehicle data");
				System.out.print("Please enter vechile type: ");
				String vehicleType = scanner.next();
				if (carType.equalsIgnoreCase(vehicleType)) {
					System.out.print("Enter vechile number: ");
					String numberPlate = scanner.next();
					System.out.print("Enter vechile Make: ");
					String carBrand = scanner.next();
					System.out.print("Enter vechile Model: ");
					String carModel = scanner.next();
					Car car = new Car(numberPlate, carBrand, carModel);
					rentalService.addVehicle(car);
					System.out.println("Vechile Added sucessfully\n");
				} else if (motorCycleType.equalsIgnoreCase(vehicleType)) {
					System.out.print("Enter vechile number: ");
					String numberPlate = scanner.next();
					System.out.print("Enter vechile Make: ");
					String carBrand = scanner.next();
					System.out.print("Enter vechile Model: ");
					String carModel = scanner.next();
					Motorcycle motorCycle = new Motorcycle(numberPlate, carBrand, carModel);
					rentalService.addVehicle(motorCycle);
					System.out.println("Vechile Added sucessfully\n");
				} else if (bicycleType.equalsIgnoreCase(vehicleType)) {
					System.out.print("Enter vechile number: ");
					String numberPlate = scanner.next();
					System.out.print("Enter vechile Make: ");
					String carBrand = scanner.next();
					System.out.print("Enter vechile Model: ");
					String carModel = scanner.next();
					Bicycle bicycle = new Bicycle(numberPlate, carBrand, carModel);
					rentalService.addVehicle(bicycle);
					System.out.println("Vechile Added sucessfully\n");
				} else {
					System.out.println("Vehicle type is not matched\n");
				}

				break;
			case 2:
				List<Vehicle> availableVehicles = rentalService.getAvailableVehicles();
				System.out.println("Available vehicles:");
				for (Vehicle vehicle : availableVehicles) {
					System.out
							.println(vehicle.getLicensePlate() + " - " + vehicle.getMake() + " " + vehicle.getModel());
				}
				System.out.print("\n");
				break;
			case 3:
				System.out.println("\nSelect the car which are available for Rent: ");
				String selectedCar = scanner.next();
				if (selectCar(selectedCar) != null) {
					Vehicle car = (Vehicle) selectCar(selectedCar);
					System.out.println("Create a customer for Rent a car");
					System.out.print("\nEnter customer first name: ");
					String fristName = scanner.next();
					System.out.print("Enter customer last name: ");
					String lastName = scanner.next();
					System.out.print("Enter customer ID: ");
					String customerID = scanner.next();
					Customer customer = new Customer(fristName, lastName, customerID);
					LocalDateTime startTime = LocalDateTime.now();
					System.out.print("\nHow many hours do you want a car for rent: ");
					int rentHours = scanner.nextInt();
					LocalDateTime endTime = startTime.plusHours(rentHours);
					rental = rentalService.rentVehicle(customer, car, startTime, endTime);
					if (rental != null) {
						System.out.println("Rental successful:");
						System.out.println("Vehicle: " + rental.getRentedVehicle().getLicensePlate());
						System.out.println("Customer: " + rental.getCustomer().getFirstName() + " "
								+ rental.getCustomer().getLastName());
						System.out.println("Start Time: " + rental.getStartTime());
						System.out.println("End Time: " + rental.getEndTime() + "\n");
					}
				} else {
					System.out.println("Vehicle is not available for rent.\n");
				}
				break;
			case 4:
				BigDecimal rentalCost = rentalService.calculateRentalCost(rental);
				System.out.println("Rental Cost: $" + rentalCost + "\n");
				break;
			case 5:
				boolean returned = rentalService.returnVehicle(rental);
				if (returned) {
					System.out.println("Vehicle returned successfully.");
				} else {
					System.out.println("Vehicle is not listed in rentals data");
				}
				System.out.print("\n");
				break;
			case 6:
				exit = true;
				break;
			default:
				System.out.println("Thanks for Choosing My Rental Cars and Visit again");
			}

		}
		scanner.close();
	}

	public static Vehicle selectCar(String carName) {
		List<Vehicle> availableVehicles = rentalService.getAvailableVehicles();
		for (Vehicle vehicle : availableVehicles) {
			if (vehicle.getMake().equalsIgnoreCase(carName)) {
				return vehicle;
			}
		}
		return null;
	}

}

