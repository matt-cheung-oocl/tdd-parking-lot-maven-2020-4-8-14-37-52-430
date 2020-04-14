package com.oocl;

import java.util.List;

public class ParkingBoy {

	private List<ParkingLot> parkingLots;

	public List<ParkingLot> getParkingLots() { return parkingLots; }

	public ParkingBoy(List<ParkingLot> parkingLots) { this.parkingLots = parkingLots; }

	public ParkingTicket park(Car car) throws FullCapacityException {
		for (ParkingLot parkingLot : this.parkingLots) {
			if (!parkingLot.isFull()) {
				return parkingLot.park(car);
			}
		}
		throw new FullCapacityException();
	}

	public Car fetch(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException, NoParkingTicketException {
		if (parkingTicket == null) {
			throw new NoParkingTicketException();
		}
		for (int counter = 1; counter < this.getParkingLots().size(); counter++) {
			if (this.getParkingLots().get(counter).isContainTicket(parkingTicket)) {
				return this.parkingLots.get(counter).fetch(parkingTicket);
			}
		}
		throw new UnrecognizedParkingTicketException();
	}
}