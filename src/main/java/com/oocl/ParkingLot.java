package com.oocl;

import java.util.HashMap;

public class ParkingLot {
	private HashMap<ParkingTicket, Car> parkingTicketCarHashMap = new HashMap<ParkingTicket, Car>();

	public ParkingTicket park(Car car) {
		ParkingTicket parkingTicket = new ParkingTicket();
		this.parkingTicketCarHashMap.put(parkingTicket, car);
		return parkingTicket;
	}

	public Car fetch(ParkingTicket parkingTicket) {
		return this.parkingTicketCarHashMap.remove(parkingTicket);
	}
}
