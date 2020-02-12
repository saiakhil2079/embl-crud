package com.embl.crud.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PersonInfo.class)
public class Person {
    @Id
	private String firstname;
    @Id
	private String lastname;
    @Id
	private int age;
	private String favouritecolour;
	private String hobby;

	public Person() {

	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFavouritecolour() {
		return favouritecolour;
	}

	public void setFavouritecolour(String favouritecolour) {
		this.favouritecolour = favouritecolour;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
