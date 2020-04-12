package com.oocl;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

	public SmartParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
	}

	public ParkingTicket park(Car car) {
		for (ParkingLot parkingLot : this.getParkingLots()) {
			if (!parkingLot.isFull()) {
				return parkingLot.park(car);
			}
		}
		return this.getParkingLots().get(0).park(car);
	}
}
