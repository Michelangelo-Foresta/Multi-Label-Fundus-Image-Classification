package packages;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		// Assemble all the pieces of MVC
		PatientView view = new PatientView("Eye Disease Diagnastic System");
		PatientController pController = new PatientController(view);
		pController.initController();
	}

}
