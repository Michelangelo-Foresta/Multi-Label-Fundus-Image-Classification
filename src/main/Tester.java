package main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Tester {

	public static void main(String[] args) {
		PatientView view = new PatientView();
		PatientController controller = new PatientController(view);
		String medicare = "AMTG3";
		Patient p1 = new Patient("Tom", "Dom", 1955, 10, 12, medicare, "111 Plain", "dude@mail.com");
		Diagnosis d1 = new Diagnosis(medicare, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6);
		
		controller.retrieveAllData();

//		controller.insertEntry(p1, d1);
//		controller.insertEntry("Vlad", "Poop", 1988, 6, 13, medicare, "111 Plain", "dude@mail.com",
//				1.2, 2.2, 3.2, 4.2, 5.2, 6.2);

		controller.consolePrintPatients();
		controller.consolePrintDiagnosis();
//		System.out.println(controller.getpModels());
//		System.out.println(controller.getdModels());
		
	}

}
