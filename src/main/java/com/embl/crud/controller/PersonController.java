package com.embl.crud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.embl.crud.dto.PersonDto;
import com.embl.crud.service.PersonService;

@RestController
public class PersonController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	PersonService personService;

	@PostMapping("/store")
	public void store(@RequestBody List<PersonDto> personDto) {
		try {
			personService.store(personDto);
		} catch (Exception e) {
			LOGGER.error("Error while storing the person in db", e);
		}
	}

	@GetMapping("/retrieve")
	public List<PersonDto> getAll() {
		List<PersonDto> persons = null;
		try {
			persons = personService.retrieve();
		} catch (Exception e) {
			LOGGER.error("Error while retrieving the data");
		}
		return persons;
	}

	@PostMapping("/update")
	public void update(@RequestBody List<PersonDto> personDto) {
		personService.update(personDto);
	}

	@DeleteMapping("/delete/{firstName}/{lastName}/{age}")
	public void delete(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName,
			@PathVariable("age") int age) {
		personService.delete(firstName, lastName, age);

	}

}
