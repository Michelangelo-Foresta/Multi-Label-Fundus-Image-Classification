package packages;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PDFMethods {
//    static ArrayList patientList;
    //static ArrayList diagnosisList;

    PDFMethods() {
        //  Patient patient = new Patient("", "", 0, 0, 0, "", "", "");
        // Diagnosis diagnosis = new Diagnosis("", 0, 0, 0, 0, 0, 0);

        //patient.toString();
        //diagnosis.toString();
/*
        patientList.add(new Patient(patient.getFirstName(), patient.getLastName(), patient.getDobYear(), patient.getDobMonth(), patient.getDobDay(),
                patient.getMedicare(), patient.getAddress(), patient.getEmail()));

        diagnosisList.add(new Diagnosis(diagnosis.getMedicare(), diagnosis.getDisease1(), diagnosis.getDisease2(), diagnosis.getDisease3(),
                diagnosis.getDisease4(), diagnosis.getDisease5(), diagnosis.getDisease6()));
*/
        //patientList.add(patient);
        //diagnosisList.add(diagnosis);
    }

    /*
//Insert Directory of the path of the file you want to load. Including the filename
if it does not exist then it will create the file at the specified path.
Input will be the complete object.
*/
    public static void pdfMethod(Patient obj,String Path) throws IOException {

        //patient.toString();
        //diagnosis.toString();
/*
        patientList.add(new Patient(patient.getFirstName(), patient.getLastName(), patient.getDobYear(), patient.getDobMonth(), patient.getDobDay(),
                patient.getMedicare(), patient.getAddress(), patient.getEmail()));

        diagnosisList.add(new Diagnosis(diagnosis.getMedicare(), diagnosis.getDisease1(), diagnosis.getDisease2(), diagnosis.getDisease3(),
                diagnosis.getDisease4(), diagnosis.getDisease5(), diagnosis.getDisease6()));
*/
        //patientList.add(patient);
        //diagnosisList.add(diagnosis);
        //String patient = patientList.get(i).toString();
        //String diagnosis = diagnosisList.get(i).toString();
        //patient.toString();
        //diagnosis.toString();

        //Set the path of the file if it exists, otherwise it will create a new one.
       // File file = new File(Path);
        PDPage page = new PDPage();
        //Create the object document and load the file pdf file.
        PDDocument document = new PDDocument();

        //document = PDDocument.load(file);

        //Instantiate page.

        document.addPage(new PDPage());
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        //If pageNumber is greater than 0 we will be adding a new page into an existing PDF

        contentStream.beginText();
        //set position
        contentStream.newLineAtOffset(62, 1000);
        //Pick the font
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 25);
        //contentStream.setFont(font, fontSize);

        //String of text goes in here



//        for (int i = 0; i < patientList.size()-1; i++) {
            contentStream.showText("HELLO WORLD! ");
//            contentStream.showText(patientList.get(i).toString());
//        }
        contentStream.endText();

        contentStream.close();
        document.save(Path);
        document.close();
    }
}
