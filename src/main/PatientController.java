package main;

import java.util.ArrayList;

public class PatientController {
	private PatientView view;
	private ArrayList<Patient> model;
	
	public PatientController(PatientView view) {
		this.view = view;
		this.model = new ArrayList<Patient>();
	}
}
