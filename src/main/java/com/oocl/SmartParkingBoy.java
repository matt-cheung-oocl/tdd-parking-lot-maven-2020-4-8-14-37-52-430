package com.oocl;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

	public SmartParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
	}

	@Override
	public ParkingTicket park(Car car) {
		ParkingLot moreEmptyParkingLot = this.getParkingLots().get(0);
		for (int counter = 1; counter < this.getParkingLots().size(); counter++) {
			if (this.getParkingLots().get(counter).getCurrentCapacity() < moreEmptyParkingLot.getCurrentCapacity()) {
				moreEmptyParkingLot = this.getParkingLots().get(counter);
			}
		}
		return moreEmptyParkingLot.park(car);
	}

}