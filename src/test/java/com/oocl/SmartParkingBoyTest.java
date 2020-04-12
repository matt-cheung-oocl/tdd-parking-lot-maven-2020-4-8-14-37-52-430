package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SmartParkingBoyTest {

	@Test
	public void should_return_capacity_1_for_2nd_parking_lot_when_parking_2nd_car() {

		ParkingLot parkingLot1 = new ParkingLot();
		ParkingLot parkingLot2 = new ParkingLot();
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLot1);
		parkingLots.add(parkingLot2);
		ParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);

		parkingBoy.park(new Car());
		parkingBoy.park(new Car());

		Assert.assertEquals(1, parkingLot2.getCurrentCapacity());
	}
}