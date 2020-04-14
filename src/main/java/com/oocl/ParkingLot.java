package com.oocl;

import java.util.HashMap;

public class ParkingLot {
	public static final int PARKING_LOT_CAPACITY = 10;
	private HashMap<ParkingTicket, Car> parkingTicketCarHashMap = new HashMap<ParkingTicket, Car>();

	public boolean isFull() { return parkingTicketCarHashMap.size() == PARKING_LOT_CAPACITY; }

	public boolean isContainTicket(ParkingTicket parkingTicket) { return parkingTicketCarHashMap.containsKey(parkingTicket); }

	public int getCurrentCapacity() { return parkingTicketCarHashMap.size(); }

	public double getCurrentAvailablePositionRate() {
		return ((double) (PARKING_LOT_CAPACITY - this.getCurrentCapacity()) / PARKING_LOT_CAPACITY);
	}

	public ParkingTicket park(Car car) {
		if (this.isFull()) {
			return null;
		}
		ParkingTicket parkingTicket = new ParkingTicket();
		this.parkingTicketCarHashMap.put(parkingTicket, car);
		return parkingTicket;
	}

	public Car fetch(ParkingTicket parkingTicket)  { return this.parkingTicketCarHashMap.remove(parkingTicket); }
}
