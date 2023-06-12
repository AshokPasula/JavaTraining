package car_rental_system;

import java.time.LocalDateTime;

public class Rental {
	private Vehicle rentedVehicle;
    private Customer customer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Rental(Vehicle rentedVehicle, Customer customer, LocalDateTime startTime, LocalDateTime endTime) {
        this.rentedVehicle = rentedVehicle;
        this.customer = customer;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
