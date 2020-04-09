package com.oocl;

public class NoParkingTicketException extends RuntimeException{
	public NoParkingTicketException() {
		super("Please provide your parking ticket.");
	}

}
