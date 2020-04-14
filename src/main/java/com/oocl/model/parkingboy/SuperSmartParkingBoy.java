package com.oocl.model.parkingboy;

import com.oocl.exception.FullCapacityException;
import com.oocl.model.Car;
import com.oocl.model.ParkingLot;
import com.oocl.model.ParkingTicket;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

	public SuperSmartParkingBoy(List<ParkingLot> parkingLots) { super(parkingLots); }

	@Override
	public ParkingTicket park(Car car) throws FullCapacityException {
		ParkingLot higherAvailableRateParkingLot = this.parkingLots.get(0);
		for (int counter = 1; counter < this.parkingLots.size(); counter++) {
			if (this.parkingLots.get(counter).getCurrentAvailablePositionRate() > higherAvailableRateParkingLot.getCurrentAvailablePositionRate()) {
				higherAvailableRateParkingLot = this.parkingLots.get(counter);
			}
		}
		if (higherAvailableRateParkingLot.getCurrentCapacity() == ParkingLot.PARKING_LOT_CAPACITY) {
			throw new FullCapacityException();
		}
		return higherAvailableRateParkingLot.park(car);
	}
}
