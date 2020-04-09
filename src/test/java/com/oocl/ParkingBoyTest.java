package com.oocl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingBoyTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void should_return_exception_message_when_fetch_with_incorrect_ticket() {
		expectedException.expect(UnrecognizedParkingTicketException.class);
		expectedException.expectMessage("Unrecognized parking ticket.");

		ParkingLot parkingLot = new ParkingLot();
		ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
		Car car = new Car();

		ParkingTicket parkingTicket = parkingBoy.park(car);

		parkingBoy.fetch(new ParkingTicket());
	}
}
