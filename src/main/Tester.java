package main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Tester {

	public static void main(String[] args) {
		PatientView view = new PatientView();
		PatientController controller = new PatientController(view);
		String medicare = "NGXT1";
		Patient p1 = new Patient("Thomas", "Ng", 1900, 10, 15, medicare, "111 Plain", "dude@mail.com");
		Diagnosis d1 = new Diagnosis(medicare, 1, 2, 3, 4, 5, 6);
		

//		connect.insertPatient(p1);
//		connect.insertDiagnosis(d1);
		
//		List<Patient> patients = DatabaseConnection.retrievePatients();
//		List<Diagnosis> diagnosis = DatabaseConnection.retrieveDiagnosis();
		controller.retrieveAllData();

		System.out.println(controller.getdModels());
		System.out.println(controller.getpModels());
		
	}

}
