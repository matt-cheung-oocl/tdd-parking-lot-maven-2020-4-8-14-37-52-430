package com.oocl.exception;

public class NoParkingTicketException extends RuntimeException{
	public NoParkingTicketException() {
		super("Please provide your parking ticket.");
	}

}
