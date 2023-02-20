package packages;

import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

import static packages.PDFMethods.pdfMethod;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // Assemble all the pieces of MVC
//path of pdf
        Patient patient = new Patient("", "", "");
        new PatientView("Andrew");
        pdfMethod(patient, "diagnosis.pdf");

        PatientView view = new PatientView("Eye Disease Diagnostic System");
        PatientController pController = new PatientController(view);
        pController.initController();
    }
}
