package com.embl.crud.service;

import java.util.ArrayList;
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

	public void store(List<PersonDto> personDto) {
		List<Person> persons = new ArrayList<>();
		for (PersonDto persondto : personDto) {
			Person person = new Person();
			person.setFirstname(persondto.getFirstName());
			person.setLastname(persondto.getLastName());
			person.setAge(persondto.getAge());
			person.setFavouritecolour(persondto.getFavouriteColour());
			person.setHobby(persondto.getHobby());
			persons.add(person);
		}
		personRepository.saveAll(persons);
	}

	public List<PersonDto> retrieve() {
		List<Person> persons = personRepository.findAll();

		List<PersonDto> listOfPersons = persons.stream().map(Mapper::personEntity2dto).collect(Collectors.toList());
		return listOfPersons;
	}

	public void update(List<PersonDto> personDto) {
		List<Person> persons = new ArrayList<>();
		for (PersonDto persondto : personDto) {
			Person person = personRepository.findByFirstnameAndLastnameAndAge(persondto.getFirstName(),
					persondto.getLastName(), persondto.getAge());
			if (Objects.isNull(person)) {
				throw new PersonNotFoundException(persondto.getFirstName(), persondto.getLastName());
			} else {
				person.setFavouritecolour(persondto.getFavouriteColour());
				person.setHobby(persondto.getHobby());
				persons.add(person);
			}
		}
		personRepository.saveAll(persons);

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
