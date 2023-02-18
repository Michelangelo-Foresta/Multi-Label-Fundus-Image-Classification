package main;

import java.time.LocalDate;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Patient {
	
	private ObjectId id;
	private String firstName;
	private String lastName;
	private int dobDay;
	private int dobMonth;
	private int dobYear;
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
		this.dobDay = day;
		this.dobMonth = month;
		this.dobYear = year;
		this.medicare = medicare;
		this.address = address;
		this.email = email;
	}

	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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

	public int getDobDay() {
		return dobDay;
	}

	public void setDobDay(int dobDay) {
		this.dobDay = dobDay;
	}

	public int getDobMonth() {
		return dobMonth;
	}

	public void setDobMonth(int dobMonth) {
		this.dobMonth = dobMonth;
	}

	public int getDobYear() {
		return dobYear;
	}

	public void setDobYear(int dobYear) {
		this.dobYear = dobYear;
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
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dobDay=" + dobDay
				+ ", dobMonth=" + dobMonth + ", dobYear=" + dobYear + ", medicare=" + medicare + ", address=" + address
				+ ", email=" + email + "]";
	}

	

}
