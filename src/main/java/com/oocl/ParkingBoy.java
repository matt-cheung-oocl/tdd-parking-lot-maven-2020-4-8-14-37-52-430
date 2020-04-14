package com.oocl;

import java.util.List;

public class ParkingBoy {
	private List<ParkingLot> parkingLots;

	public List<ParkingLot> getParkingLots() {
		return parkingLots;
	}

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
		for (int counter = 1; counter < this.getParkingLots().size(); counter++) {
			if (this.getParkingLots().get(counter).isContainTicket(parkingTicket)) {
				return this.parkingLots.get(counter).fetch(parkingTicket);
			}
		}
		return this.parkingLots.get(0).fetch(parkingTicket);
	}
}
