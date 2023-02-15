package main;

import java.time.LocalDate;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Patient {
	
	private ObjectId id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;	// Integer => Year, Month, Day
	private String medicare;
	private String address;
	private String email;
	
	public Patient()
	{
		// default
	}
	
	public Patient(String firstName, String lastName, 
			int year, int month, int day, 
			String medicare, String address, String email) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = LocalDate.of(year, month, day);
		this.medicare = medicare;
		this.address = address;
		this.email = email;
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

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(int year, int month, int day) {
		this.dateOfBirth = LocalDate.of(year, month, day);
	}

	public String getMedicare() {
		return medicare;
	}

	public void setMedicare(String medicare) {
		this.medicare = medicare;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Patient [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", medicare=" + medicare + ", address=" + address + ", email=" + email + "]";
	}

}
