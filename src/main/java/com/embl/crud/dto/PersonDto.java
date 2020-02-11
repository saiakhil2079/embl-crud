package com.embl.crud.dto;

import java.util.List;

public class PersonDto {
	private String firstName;
	private String lastName;
	private int age;
	private String favouriteColour;
	private List<String> hobby;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFavouriteColour() {
		return favouriteColour;
	}

	public void setFavouriteColour(String favouriteColour) {
		this.favouriteColour = favouriteColour;
	}

	public String getHobby() {
		StringBuilder hobbies = new StringBuilder();
		for (String hobbie : hobby) {
			hobbies.append(hobbie + ",");
		}
		hobbies.deleteCharAt(hobbies.length() - 1);
		return hobbies.toString();
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", favouriteColour="
				+ favouriteColour + ", hobby=" + hobby + "]";
	}

}
