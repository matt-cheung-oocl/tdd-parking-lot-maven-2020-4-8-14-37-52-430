package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

	@Test
	public void should_return_parking_ticket_when_give_car() throws DuplicatedCarException, NullCarException {
		ParkingLot parkingLot = new ParkingLot();
		ParkingTicket parkingTicket = parkingLot.park(new Car());

		Assert.assertNotNull(parkingTicket);
	}

	@Test
	public void should_return_correct_car_when_give_ticket() throws DuplicatedCarException, NullCarException {
		ParkingLot parkingLot = new ParkingLot();
		Car car = new Car();
		ParkingTicket parkingTicket = parkingLot.park(car);
		Car fetchedCar = parkingLot.fetch(parkingTicket);

		Assert.assertEquals(car, fetchedCar);
	}

	@Test
	public void should_return_null_when_give_wrong_ticket() {
		ParkingLot parkingLot = new ParkingLot();
		Car fetchedCar = parkingLot.fetch(new ParkingTicket());

		Assert.assertNull(fetchedCar);
	}

	@Test
	public void should_return_null_when_give_used_ticket() throws DuplicatedCarException, NullCarException {
		ParkingLot parkingLot = new ParkingLot();
		Car car = new Car();
		ParkingTicket parkingTicket = parkingLot.park(car);
		parkingLot.fetch(parkingTicket);

		Car fetchedCar = parkingLot.fetch(parkingTicket);

		Assert.assertNull(fetchedCar);
	}

	@Test
	public void should_return_null_when_parking_lot_is_full() throws DuplicatedCarException, NullCarException {
		ParkingLot parkingLot = new ParkingLot();
		for (int count = 0; count < 10; count++) {
			parkingLot.park(new Car());
		}
		ParkingTicket eleventhParkingTicket = parkingLot.park(new Car());

		Assert.assertNull(eleventhParkingTicket);
	}

//	@Test
//	public void should_return_exception_when_park_parked_car() throws DuplicatedCarException, NullCarException {
//		ParkingLot parkingLot = new ParkingLot();
//		Car car = new Car();
//		parkingLot.park(car);
//		ParkingTicket secondParkingTicket = parkingLot.park(car);
//
//		Assert.assertThrows();
//	}

}
