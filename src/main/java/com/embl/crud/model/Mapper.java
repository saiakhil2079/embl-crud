package com.embl.crud.model;

import java.util.Arrays;

import com.embl.crud.dto.PersonDto;

public class Mapper {
	
	public static final PersonDto personEntity2dto(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.setFirstName(person.getFirstname());
		personDto.setLastName(person.getLastname());
		personDto.setAge(person.getAge());
		personDto.setFavouriteColour(person.getFavouritecolour());
		personDto.setHobby(Arrays.asList(person.getHobby().split(",")));
		return personDto;
	}

}
