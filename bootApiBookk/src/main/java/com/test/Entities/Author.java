package com.test.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authId;
	@Column(name = "First_Name")
	private String firstName;
	@Column(name = "Last_Name")
	private String lastName;
	@Column(name = "Language")
	private String language;
	
	public Author(int authId, String firstName, String lastName, String language) {
		super();
		this.authId = authId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
	}
	   public Author(String firstName, String lastName, String language) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.language = language;
	    }
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Author [authId=" + authId + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
				+ language + "]";
	}
	
	
}
