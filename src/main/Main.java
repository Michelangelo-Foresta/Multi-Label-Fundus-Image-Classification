package main;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // Assemble all the pieces of MVC

        PatientView view = new PatientView("Eye Disease Diagnostic System");
        PatientController pController = new PatientController(view);
        pController.retrieveAllData();
        pController.initController();
        
    }
}
