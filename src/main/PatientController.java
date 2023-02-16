package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientController {
	private PatientView view;
	private ArrayList<Patient> pModels;
	private ArrayList<Diagnosis> dModels;
	
	public PatientController(PatientView view) {
		this.view = view;
		this.pModels = new ArrayList<Patient>();
		this.dModels = new ArrayList<Diagnosis>();
	}
	
	public void consolePrintPatients()
	{
		this.view.printAllPatients(pModels);
	}
	
	public void consolePrintDiagnosis()
	{
		this.view.printAllDiagnosis(dModels);
	}
	
	public void retrieveAllData()
	{
		DatabaseConnection.colDiagnosis.find().into(this.dModels);
		DatabaseConnection.colPatient.find().into(this.pModels);	
	}
	
	public void insertEntry(Patient patient, Diagnosis diagnosis)
	{
		this.pModels.add(patient);
		this.dModels.add(diagnosis);
		DatabaseConnection.insertPatient(patient);
		DatabaseConnection.insertDiagnosis(diagnosis);	
	}
	
	public void insertEntry(String firstName, String lastName, 
			int year, int month, int day, 
			String medicare, String address, String email,
			double disease1, double disease2,  double disease3,
			double disease4, double disease5, double disease6)
	{
		Patient patient = new Patient(firstName, lastName, year, month, day, medicare, address, email);
		Diagnosis diagnosis = new Diagnosis(medicare, disease1, disease2, disease3,
				 disease4, disease5, disease6);
		this.pModels.add(patient);
		this.dModels.add(diagnosis);
		DatabaseConnection.insertPatient(patient);
		DatabaseConnection.insertDiagnosis(diagnosis);	
	}
	
	// Getters and setters
	public PatientView getView() {
		return view;
	}

	public void setView(PatientView view) {
		this.view = view;
	}

	public ArrayList<Patient> getpModels() {
		return pModels;
	}

	public void setpModels(ArrayList<Patient> pModels) {
		this.pModels = pModels;
	}

	public ArrayList<Diagnosis> getdModels() {
		return dModels;
	}

	public void setdModels(ArrayList<Diagnosis> dModels) {
		this.dModels = dModels;
	}
	
	
}
