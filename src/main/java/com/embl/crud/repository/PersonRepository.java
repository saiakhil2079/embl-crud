package com.embl.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.embl.crud.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	public Person findByFirstnameAndLastnameAndAge(String firstname, String lastname, int age);
	
	public void deleteByFirstnameAndLastnameAndAge(String firstname, String lastname, int age);

}
