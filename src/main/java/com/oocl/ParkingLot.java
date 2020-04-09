package com.oocl;

import java.util.HashMap;

public class ParkingLot {
	public static final int PARKING_LOT_CAPACITY = 10;
	private HashMap<ParkingTicket, Car> parkingTicketCarHashMap = new HashMap<ParkingTicket, Car>();

	public ParkingTicket park(Car car) throws DuplicatedCarException, NullCarException {
		if (parkingTicketCarHashMap.containsValue(car)) {
			throw new DuplicatedCarException("The car has been already parked.");
		}
		if (car == null) {
			throw new NullCarException("Null car is not valid");
		}

		if (parkingTicketCarHashMap.size() >= PARKING_LOT_CAPACITY) {
			return null;
		}
		ParkingTicket parkingTicket = new ParkingTicket();
		this.parkingTicketCarHashMap.put(parkingTicket, car);
		return parkingTicket;
	}

	public Car fetch(ParkingTicket parkingTicket) {
		return this.parkingTicketCarHashMap.remove(parkingTicket);
	}
}
