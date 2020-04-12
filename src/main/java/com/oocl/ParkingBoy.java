package com.oocl;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
	private List<ParkingLot> parkingLots;

	public ParkingBoy(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public ParkingTicket park(Car car) {
		for (ParkingLot parkingLot : this.parkingLots) {
			if (!parkingLot.isFull()) {
				return parkingLot.park(car);
			}
		}
		return parkingLots.get(0).park(car);
	}

	public Car fetch(ParkingTicket parkingTicket) {
		return this.parkingLots.get(0).fetch(parkingTicket);
	}
}
