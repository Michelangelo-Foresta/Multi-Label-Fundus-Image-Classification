package main;

import java.util.ArrayList;

public class PatientView {
	
	public void printPatient(Patient patient)
	{
		System.out.println("Patient Information: ");
		System.out.println("First name: " + patient.getFirstName());
		System.out.println("Last Name: " + patient.getLastName());
		System.out.println("Date of Birth: Day:" + patient.getDobDay() + "/Month:" + patient.getDobMonth() +
				"/Year:" + patient.getDobYear());
		System.out.println("Medicare: " + patient.getMedicare());
		System.out.println("Address: " + patient.getAddress());
		System.out.println("E-mail: " + patient.getEmail() + "\n");
	}
	
	public void printAllPatients(ArrayList<Patient> models) 
	{
		for(Patient patient: models) 
		{
			printPatient(patient);
		}
	}
	
	public void printDiagnosis(Diagnosis diagnosis)
	{
		System.out.println("Diagnosis: ");
		System.out.println("Medicare: " + diagnosis.getMedicare());
		System.out.println("Disease 1: " + diagnosis.getDisease1());
		System.out.println("Disease 2: " + diagnosis.getDisease2());
		System.out.println("Disease 3: " + diagnosis.getDisease3());
		System.out.println("Disease 4: " + diagnosis.getDisease4());
		System.out.println("Disease 5: " + diagnosis.getDisease5());
		System.out.println("Disease 6: " + diagnosis.getDisease6() + "\n");
	}
	
	public void printAllDiagnosis(ArrayList<Diagnosis> models) 
	{
		for(Diagnosis diagnosis: models) 
		{
			printDiagnosis(diagnosis);
		}
	}
}
