package main;

import java.util.ArrayList;

public class PatientView {
	
	public void printPatient(Patient patient){
//		System.out.println("Patient Information: ");
//		System.out.println("First name: " + patient.getfName());
//		System.out.println("Last Name: " + patient.getlName());
//		System.out.println("Medicare: " + patient.getMedicare());
////		System.out.println("Date of Birth: " + patient.getDateOfBirth());
//		System.out.println(patient.getDisease1());
//		System.out.println(patient.getDisease2());
//		System.out.println(patient.getDisease3());
//		System.out.println(patient.getDisease4());
//		System.out.println(patient.getDisease5());
//		System.out.println(patient.getDisease6());
	}
	
	public void printAllPatients(ArrayList<Patient> models) {
		for(Patient patient: models) {
			printPatient(patient);
		}
	}
	
	/*
	 * TODO
	 * Maybe make view for just patient info and just disease info
	 */
}
