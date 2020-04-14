package com.oocl.model.parkingboy;

import com.oocl.exception.FullCapacityException;
import com.oocl.model.Car;
import com.oocl.model.ParkingLot;
import com.oocl.model.ParkingTicket;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

	public SmartParkingBoy(List<ParkingLot> parkingLots) { super(parkingLots); }

	@Override
	public ParkingTicket park(Car car) throws FullCapacityException {
		ParkingLot moreEmptyParkingLot = this.parkingLots.get(0);
		for (int counter = 1; counter < this.parkingLots.size(); counter++) {
			if (this.parkingLots.get(counter).getCurrentCapacity() < moreEmptyParkingLot.getCurrentCapacity()) {
				moreEmptyParkingLot = this.parkingLots.get(counter);
			}
		}
		if (moreEmptyParkingLot.getCurrentCapacity() == ParkingLot.PARKING_LOT_CAPACITY) {
			throw new FullCapacityException();
		}
		return moreEmptyParkingLot.park(car);
	}
}