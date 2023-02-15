package main;

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
	
	public void retrieveAllData()
	{
		DatabaseConnection.colDiagnosis.find().into(this.dModels);
		DatabaseConnection.colPatient.find().into(this.pModels);	
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
