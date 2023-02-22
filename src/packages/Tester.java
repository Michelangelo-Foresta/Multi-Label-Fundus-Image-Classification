package packages;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) throws IOException {
		PatientView view = new PatientView("Patient1");
		PatientController controller = new PatientController(view);
		String medicare = "AMGK2";
		Patient p1 = new Patient("Tom", "Dom", 1955, 10, 12, medicare, "111 Plain", "dude@mail.com");
		Diagnosis d1 = new Diagnosis(medicare, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7);
		
		String userName = "fds";
		String password = "password";
		controller.retrieveAllData();
		boolean result = controller.verifyLogin(userName, password);
		System.out.println(result);
		
//		controller.insertEntry("Vlad", "Poop", 1988, 6, 13, medicare, "111 Plain", "dude@mail.com",
//				1.2, 2.2, 3.2, 4.2, 5.2, 6.2);

//		controller.consolePrintPatients();
//		controller.consolePrintDiagnosis();
//		controller.consolePrintLogin();
		
		System.out.println("New Result \n=================================== \n");
//		controller.deleteEntry(medicare);
//		controller.insertEntry(p1, d1);
		
		
//		controller.updateEntry("Carrier", "Fisher", 1970, 1, 2, medicare, "222 Boner", "woman@mail.com",
//				0, 0, 0, 0, 0, 0, 0);
		
//		controller.consolePrintPatients();
//		controller.consolePrintDiagnosis();
//		controller.consolePrintLogin();
		
	}

}

