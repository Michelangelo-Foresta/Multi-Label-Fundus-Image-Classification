package main;

import java.time.LocalDate;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Patient {
	@BsonProperty("_id")
	private ObjectId id;
	@BsonProperty("medicare")
	private String medicare; 			// 12 character medicare card number
	@BsonProperty("fName")
	private String fName; 				// First Name
	@BsonProperty("lName")
	private String lName; 				// Last Name
	@BsonProperty("age")
	private int age;
	@BsonProperty("gender")
	private char gender;
	@BsonProperty("dobDay")
	private int dobDay;
	@BsonProperty("dobMonth")
	private int dobMonth;
	@BsonProperty("dobYear")
	private int dobYear;
	@BsonProperty("disease1")
	private double disease1; 			// 0-1 range
	@BsonProperty("disease2")
	private double disease2;
	@BsonProperty("disease3")
	private double disease3;
	@BsonProperty("disease4")
	private double disease4;
	@BsonProperty("disease5")
	private double disease5;
	@BsonProperty("disease6")
	private double disease6;
	
	public Patient() {
		// Default
	}
	
	public Patient(String medicare, String fName, String lName, int age, char gender, 
			int dobDay, int dobMonth, int dobYear) {
		this.medicare = medicare;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.gender = gender;
		this.dobDay = dobDay;
		this.dobMonth = dobMonth;
		this.dobYear = dobYear;
	}

	public Patient(String medicare, String fName, String lName, int age, char gender, 
			int dobDay, int dobMonth, int dobYear,
			double disease1, double disease2, double disease3, double disease4, double disease5, double disease6) {
		this.medicare = medicare;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.gender = gender;
		this.dobDay = dobDay;
		this.dobMonth = dobMonth;
		this.dobYear = dobYear;
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
				+ gender + ", dobDay=" + dobDay + ", dobMonth=" + dobMonth + ", dobYear=" + dobYear + ", disease1="
				+ disease1 + ", disease2=" + disease2 + ", disease3=" + disease3 + ", disease4=" + disease4
				+ ", disease5=" + disease5 + ", disease6=" + disease6 + "]";
	}

	
	
	
	
}
