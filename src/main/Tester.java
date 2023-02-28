package main;

import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws IOException {


//		PatientView view = new PatientView("Patient1");
//		PatientController controller = new PatientController(view);
//		String medicare = "AMGK2";
//		Patient p1 = new Patient("Tom", "Dom", 1955, 10, 12, medicare, "111 Plain", "dude@mail.com");
//		Diagnosis d1 = new Diagnosis(medicare, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7);
//
//		controller.retrieveAllData();
//
//
////		controller.insertEntry("Vlad", "Poop", 1988, 6, 13, medicare, "111 Plain", "dude@mail.com",
////				1.2, 2.2, 3.2, 4.2, 5.2, 6.2);
//
//		controller.consolePrintPatients();
//		controller.consolePrintDiagnosis();
//		System.out.println("New Result \n=================================== \n");
////		controller.deleteEntry(medicare);
//		controller.insertEntry(p1, d1);
//
////		controller.updateEntry("Carrier", "Fisher", 1970, 1, 2, medicare, "222 Boner", "woman@mail.com",
////				0, 0, 0, 0, 0, 0, 0);
//
//		controller.consolePrintPatients();
//		controller.consolePrintDiagnosis();
//
////		PatientView view = new PatientView("Patient1");
////		PatientController controller = new PatientController(view);
//		String medicare = "wesdsa34";
//		Patient p1 = new Patient("Tom", "Dom", 1955, 10, 12, medicare, "111 Plain", "dude@mail.com");
//		Diagnosis d1 = new Diagnosis(medicare, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7);
//		DatabaseConnection.insertDiagnosis(d1);
//		controller.retrieveAllData();
//
////		controller.insertEntry(p1, d1);
////		controller.insertEntry("Vlad", "Poop", 1988, 6, 13, medicare, "111 Plain", "dude@mail.com",
////				1.2, 2.2, 3.2, 4.2, 5.2, 6.2);
//
//		controller.consolePrintPatients();
//		controller.consolePrintDiagnosis();
//		System.out.println("New Result \n =================================== \n");
////		controller.deleteEntry(medicare);
//
////		controller.updateEntry("Carrier", "Fisher", 1970, 1, 2, medicare, "222 Boner", "woman@mail.com",
////				0, 0, 0, 0, 0, 0);
//
//		controller.consolePrintPatients();
//		controller.consolePrintDiagnosis();


		PatientView view = new PatientView("Patient1");
		PatientController controller = new PatientController(view);
		String medicare = "xxxK2";
		Patient p1 = new Patient("Tom", "Dom", 1955, 10, 12, medicare, "111 Plain", "dude@mail.com");
		Diagnosis d1 = new Diagnosis(medicare, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7);
		
//		String userName = "fds";
//		String password = "password";
//		controller.retrieveAllData();
//		boolean result = controller.verifyLogin(userName, password);
//		System.out.println(result);
		
//		controller.insertEntry("Vlad", "Poop", 1988, 6, 13, medicare, "111 Plain", "dude@mail.com",
//				1.2, 2.2, 3.2, 4.2, 5.2, 6.2);

//		controller.consolePrintPatients();
//		controller.consolePrintDiagnosis();
//		controller.consolePrintLogin();
		
//		System.out.println("New Result \n=================================== \n");
//		controller.deleteEntry(medicare);
//		controller.insertEntry(p1, d1);
		
		
//		controller.updateEntry("Carrier", "Fisher", 1970, 1, 2, medicare, "222 Boner", "woman@mail.com",
//				0, 0, 0, 0, 0, 0, 0);
		
//		controller.consolePrintPatients();
//		controller.consolePrintDiagnosis();
//		controller.consolePrintLogin();
		DatabaseConnection.insertPatient(p1);
		
	}

}

