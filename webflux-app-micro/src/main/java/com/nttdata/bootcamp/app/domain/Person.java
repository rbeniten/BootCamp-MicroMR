package com.nttdata.bootcamp.app.domain;

public class Person {

	private String firstname;
	
	private String lastname;
	
	private Integer age;
	
	

	public Person() {
	}

	public Person(String firstname, String lastname, Integer age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
