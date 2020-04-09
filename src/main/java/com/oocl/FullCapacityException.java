package com.oocl;

public class FullCapacityException extends RuntimeException {
	public FullCapacityException() {
		super("Not enough position.");
	}
}
