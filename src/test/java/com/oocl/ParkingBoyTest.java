package com.oocl;

import com.oocl.exception.FullCapacityException;
import com.oocl.exception.NoParkingTicketException;
import com.oocl.exception.UnrecognizedParkingTicketException;
import com.oocl.model.Car;
import com.oocl.model.parkingboy.ParkingBoy;
import com.oocl.model.ParkingLot;
import com.oocl.model.ParkingTicket;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void should_return_exception_message_when_fetch_with_incorrect_ticket() {
		expectedException.expect(UnrecognizedParkingTicketException.class);
		expectedException.expectMessage("Unrecognized parking ticket.");

		ParkingLot parkingLot = new ParkingLot();
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLot);
		ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
		Car car = new Car();

		parkingBoy.park(car);
		parkingBoy.fetch(new ParkingTicket());
	}

	@Test
	public void should_return_exception_message_when_fetch_with_no_ticket() {
		expectedException.expect(NoParkingTicketException.class);
		expectedException.expectMessage("Please provide your parking ticket.");

		ParkingLot parkingLot = new ParkingLot();
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLot);
		ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
		Car car = new Car();

		parkingBoy.park(car);
		parkingBoy.fetch(null);
	}

	@Test
	public void should_return_exception_message_when_park_car_to_full_parking_lot() {
		expectedException.expect(FullCapacityException.class);
		expectedException.expectMessage("Not enough position.");

		ParkingLot parkingLot = new ParkingLot();
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLot);
		ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

		for (int count = 0; count < 10; count++) {
			parkingLot.park(new Car());
		}
		parkingBoy.park(new Car());
	}

	@Test
	public void should_still_return_ticket_when_1st_parkingLot_is_full() {

		ParkingLot parkingLot1 = new ParkingLot();
		ParkingLot parkingLot2 = new ParkingLot();
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLot1);
		parkingLots.add(parkingLot2);
		ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

		for (int count = 0; count < 10; count++) {
			parkingBoy.park(new Car());
		}
		Assert.assertNotNull(parkingBoy.park(new Car()));
	}


	@Test
	public void should_return_exception_message_when_park_car_to_both_two_full_parking_lot() {
		expectedException.expect(FullCapacityException.class);
		expectedException.expectMessage("Not enough position.");

		ParkingLot parkingLot1 = new ParkingLot();
		ParkingLot parkingLot2 = new ParkingLot();
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLot1);
		parkingLots.add(parkingLot2);
		ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

		for (int count = 0; count < 20; count++) {
			parkingBoy.park(new Car());
		}
		parkingBoy.park(new Car());
	}

	@Test
	public void should_return_ticket_when_park_car_to_2nd_parking_lot() {

		ParkingLot parkingLot1 = new ParkingLot();
		ParkingLot parkingLot2 = new ParkingLot();
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLot1);
		parkingLots.add(parkingLot2);
		ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

		for (int count = 0; count < 10; count++) {
			parkingBoy.park(new Car());
		}
		Car targetCar = new Car();
		ParkingTicket ticket = parkingBoy.park(targetCar);
		Car fetchedCar = parkingBoy.fetch(ticket);
		Assert.assertEquals(targetCar, fetchedCar);
	}
}