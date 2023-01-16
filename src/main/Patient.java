package main;

import java.time.LocalDate;

public class Patient {
	private String medicare; 			// 12 character medicare card number
	private String fName; 				// First Name
	private String lName; 				// Last Name
	private int age;
	private char gender;
	private LocalDate dateOfBirth;		// year, month, day
	private double disease1; 			// 0-1 range
	private double disease2;
	private double disease3;
	private double disease4;
	private double disease5;
	private double disease6;
	
	public Patient() {
		// Default
	}
	
	public Patient(String medicare, String fName, String lName, int age, char gender, 
			LocalDate dateOfBirth) {
		this.medicare = medicare;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public Patient(String medicare, String fName, String lName, int age, char gender, 
			int dobYear, int dobDay, int dobMonth,
			double disease1, double disease2, double disease3, double disease4, double disease5, double disease6) {
		this.medicare = medicare;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.gender = gender;
		this.dateOfBirth = LocalDate.of(dobYear, dobDay, dobMonth);
		this.disease1 = disease1;
		this.disease2 = disease2;
		this.disease3 = disease3;
		this.disease4 = disease4;
		this.disease5 = disease5;
		this.disease6 = disease6;
	}

	public String getMedicare() {
		return medicare;
	}

	public void setMedicare(String medicare) {
		this.medicare = medicare;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int year, int month, int day) {
		this.dateOfBirth = LocalDate.of(year, month, day);
	}

	public double getDisease1() {
		return disease1;
	}

	public void setDisease1(double disease1) {
		this.disease1 = disease1;
	}

	public double getDisease2() {
		return disease2;
	}

	public void setDisease2(double disease2) {
		this.disease2 = disease2;
	}

	public double getDisease3() {
		return disease3;
	}

	public void setDisease3(double disease3) {
		this.disease3 = disease3;
	}

	public double getDisease4() {
		return disease4;
	}

	public void setDisease4(double disease4) {
		this.disease4 = disease4;
	}

	public double getDisease5() {
		return disease5;
	}

	public void setDisease5(double disease5) {
		this.disease5 = disease5;
	}

	public double getDisease6() {
		return disease6;
	}

	public void setDisease6(double disease6) {
		this.disease6 = disease6;
	}

	@Override
	public String toString() {
		return "Patient [medicare=" + medicare + ", fName=" + fName + ", lName=" + lName + ", age=" + age + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", disease1=" + disease1 + ", disease2=" + disease2
				+ ", disease3=" + disease3 + ", disease4=" + disease4 + ", disease5=" + disease5 + ", disease6="
				+ disease6 + "]";
	}
	
	
	
}
