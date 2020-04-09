package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

	@Test
	public void should_return_parking_ticket_when_give_car() {
		ParkingLot parkingLot = new ParkingLot();
		ParkingTicket parkingTicket = parkingLot.park(new Car());

		Assert.assertNotNull(parkingTicket);
	}

	@Test
	public void should_return_correct_car_when_give_ticket() {
		ParkingLot parkingLot = new ParkingLot();
		Car car = new Car();
		ParkingTicket parkingTicket = parkingLot.park(car);
		Car fetchedCar = parkingLot.fetch(parkingTicket);

		Assert.assertEquals(car, fetchedCar);
	}

	@Test
	public void should_return_null_when_give_wrong_ticket() {
		ParkingLot parkingLot = new ParkingLot();
		Car car = new Car();
		ParkingTicket parkingTicket = parkingLot.park(car);
		Car fetchedCar = parkingLot.fetch(new ParkingTicket());

		Assert.assertNull(fetchedCar);
	}



}
