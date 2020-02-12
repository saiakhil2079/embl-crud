package com.embl.crud.exception;

public class PersonNotFoundException extends RuntimeException {

	public PersonNotFoundException(String firstName, String lastName) {
		super("Person " + firstName + " " + lastName + " not found in db");
	}

}
