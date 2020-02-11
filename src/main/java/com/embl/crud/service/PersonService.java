package com.embl.crud.service;

import java.util.List;

import com.embl.crud.dto.PersonDto;

public interface PersonService {
	
	void store(PersonDto personDto);
	void update(PersonDto personDto);
	List<PersonDto> retrieve();
	void delete(String firstName, String lastName, int age);

}
