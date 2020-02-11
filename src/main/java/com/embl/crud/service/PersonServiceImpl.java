package com.embl.crud.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embl.crud.dto.PersonDto;
import com.embl.crud.exception.PersonNotFoundException;
import com.embl.crud.model.Mapper;
import com.embl.crud.model.Person;
import com.embl.crud.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	public void store(PersonDto personDto) {
		Person person = new Person();
		person.setFirstname(personDto.getFirstName());
		person.setLastname(personDto.getLastName());
		person.setAge(personDto.getAge());
		person.setFavouritecolour(personDto.getFavouriteColour());
		person.setHobby(personDto.getHobby());

		personRepository.saveAndFlush(person);
	}

	public List<PersonDto> retrieve() {
		List<Person> persons = personRepository.findAll();

		List<PersonDto> listOfPersons = persons.stream().map(Mapper::personEntity2dto).collect(Collectors.toList());
		return listOfPersons;
	}

	public void update(PersonDto personDto) {
		Person person = personRepository.findByFirstnameAndLastnameAndAge(personDto.getFirstName(),
				personDto.getLastName(), personDto.getAge());

		if (Objects.isNull(person)) {
			throw new PersonNotFoundException(personDto.getFirstName(), personDto.getLastName());
		} else {
			person.setFavouritecolour(personDto.getFavouriteColour());
			person.setHobby(personDto.getHobby());
			personRepository.saveAndFlush(person);
		}

	}

	@Transactional
	public void delete(String firstName, String lastName, int age) {
		Person person = personRepository.findByFirstnameAndLastnameAndAge(firstName, lastName, age);

		if (Objects.isNull(person)) {
			throw new PersonNotFoundException(firstName, lastName);
		} else {
			personRepository.deleteByFirstnameAndLastnameAndAge(firstName, lastName, age);
		}

	}

}
