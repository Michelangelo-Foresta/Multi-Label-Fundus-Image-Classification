package packages;

import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws IOException {
		PatientView view = new PatientView();
		PatientController controller = new PatientController(view);
		String medicare = "NGXT2";
		Patient p1 = new Patient("Tom", "Dom", 1955, 10, 12, medicare, "111 Plain", "dude@mail.com");
		Diagnosis d1 = new Diagnosis(medicare, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6);
		
		controller.retrieveAllData();

//		controller.insertEntry(p1, d1);
//		controller.insertEntry("Vlad", "Poop", 1988, 6, 13, medicare, "111 Plain", "dude@mail.com",
//				1.2, 2.2, 3.2, 4.2, 5.2, 6.2);

		controller.consolePrintPatients();
		controller.consolePrintDiagnosis();
		System.out.println("New Result \n =================================== \n");
//		controller.deleteEntry(medicare);
		
//		controller.updateEntry("Carrier", "Fisher", 1970, 1, 2, medicare, "222 Boner", "woman@mail.com",
//				0, 0, 0, 0, 0, 0);
		
		controller.consolePrintPatients();
		controller.consolePrintDiagnosis();
		
	}

}
