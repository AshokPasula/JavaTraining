package car_rental_system;

import java.math.BigDecimal;

public interface RentalCostCalculator {
	BigDecimal calculateRentalCost(Rental rental);
}
