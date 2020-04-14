package com.oocl;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

	public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
	}

	@Override
	public ParkingTicket park(Car car) throws FullCapacityException {
		ParkingLot higherAvailableRateParkingLot = this.getParkingLots().get(0);
		for (int counter = 1; counter < this.getParkingLots().size(); counter++) {
			if (this.getParkingLots().get(counter).getCurrentAvailablePositionRate() > higherAvailableRateParkingLot.getCurrentAvailablePositionRate()) {
				higherAvailableRateParkingLot = this.getParkingLots().get(counter);
			}
		}
		if (higherAvailableRateParkingLot.getCurrentCapacity() == ParkingLot.PARKING_LOT_CAPACITY) {
			throw new FullCapacityException();
		}
		return higherAvailableRateParkingLot.park(car);
	}
}
