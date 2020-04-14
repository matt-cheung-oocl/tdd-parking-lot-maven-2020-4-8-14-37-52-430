package com.oocl.exception;

public class FullCapacityException extends RuntimeException {
	public FullCapacityException() {
		super("Not enough position.");
	}
}
