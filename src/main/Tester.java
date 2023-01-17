package main;
import java.time.LocalDate;
import java.util.ArrayList;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LocalDate d1 = LocalDate.of(1988, 6, 13);
//		System.out.println(d1);
		ArrayList<Patient> list = DatabaseConnection.BSONtoObjects();
		Patient p1 = new Patient("NGXT1111222", "Thomas", "Ng", 34, 'M', 
				13, 6, 1988, 1, 2, 3, 4, 5, 6);
//		System.out.println(p1.getDateOfBirth());
//		System.out.println(p1);
//		DatabaseConnection.viewAllDocuments();
//		DatabaseConnection.addEntry(p1);
		System.out.println(p1);

//		for(Patient patient: list)
//		{
//			System.out.println("Patient:");
//			System.out.println(patient.getMedicare());
//			System.out.println(patient.getfName());
//			System.out.println(patient.getlName());
//			System.out.println(patient.getAge());
//			System.out.println(patient.getGender());
//			System.out.println(patient.getDobDay());
//			System.out.println(patient.getDobMonth());
//			System.out.println(patient.getDobYear());
//			System.out.println(patient.getDisease1());
//			System.out.println(patient.getDisease2());
//			System.out.println(patient.getDisease3());
//			System.out.println(patient.getDisease4());
//			System.out.println(patient.getDisease5());
//			System.out.println(patient.getDisease6());		
//		}
//		
	}

}
