package com.oocl;

import java.util.HashMap;

public class ParkingLot {
	public static final int PARKING_LOT_CAPACITY = 10;
	private HashMap<ParkingTicket, Car> parkingTicketCarHashMap = new HashMap<ParkingTicket, Car>();

	public ParkingTicket park(Car car) {
		if (parkingTicketCarHashMap.size() >= PARKING_LOT_CAPACITY) {
			return null;
		}
		ParkingTicket parkingTicket = new ParkingTicket();
		this.parkingTicketCarHashMap.put(parkingTicket, car);
		return parkingTicket;
	}

	public Car fetch(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException {
		if (parkingTicket == null) {
			throw new NoParkingTicketException();
		}
		if (!parkingTicketCarHashMap.containsKey(parkingTicket)) {
			throw new UnrecognizedParkingTicketException();
		}
		return this.parkingTicketCarHashMap.remove(parkingTicket);
	}
}
