package com.oocl;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

	public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
	}

	public ParkingTicket park(Car car) {
		ParkingLot higherAvailableRateParkingLot = this.getParkingLots().get(0);
		for (int counter = 1; counter < this.getParkingLots().size(); counter++) {
			if (this.getParkingLots().get(counter).getCurrentAvailablePositionRate() > higherAvailableRateParkingLot.getCurrentAvailablePositionRate()) {
				higherAvailableRateParkingLot = this.getParkingLots().get(counter);
			}
		}
		return higherAvailableRateParkingLot.park(car);
	}
}
