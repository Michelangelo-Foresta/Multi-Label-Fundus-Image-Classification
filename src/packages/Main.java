package packages;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // Assemble all the pieces of MVC

        // object of Patient
        Patient patient = new Patient();
        PatientView view = new PatientView("Eye Disease Diagnostic System");
        PatientController pController = new PatientController(view);
        pController.retrieveAllData();
        pController.initController();

    }
}
