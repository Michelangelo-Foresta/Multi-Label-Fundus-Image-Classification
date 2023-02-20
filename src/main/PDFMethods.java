package packages;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PDFMethods {
    //static ArrayList patientList;
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
    public static void pdfMethod(String Path) throws IOException {
        int i = 0;
        //Patient patient = new Patient("", "", 0, 0, 0, "", "", "");
        //Diagnosis diagnosis = new Diagnosis("", 0, 0, 0, 0, 0, 0);

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
        File file = new File(Path);
        //Create the object document and load the file pdf file.
        PDDocument document = PDDocument.load(file);

        //Instantiate page.
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        //If pageNumber is greater than 0 we will be adding a new page into an existing PDF

        contentStream.beginText();
        //set position
        contentStream.newLineAtOffset(100, 700);
        //Pick the font
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 25);
        //contentStream.setFont(font, fontSize);

        //String of text goes in here

        //contentStream.showText(patient + diagnosis);
        contentStream.showText("effefs");

        contentStream.endText();

        contentStream.close();
        document.save(Path);
        document.close();
    }
	package pdf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

//Uses a similar implementation to the File Package.
//Requires importing format of the results to later be exported as .pdf format.

public class CreatePdf {
    public static void main(String args[]) throws IOException {
        //Instantiate  ArrayList to be inserted into
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("A"));
        courseList.add(new Course("B"));
        courseList.add(new Course("C"));

        //Initialize and declare the path of the file.
        File file = new File("test.pdf");

        PDDocument document = new PDDocument();

        if (file.exists()) {
            document = PDDocument.load(file);
        } else {
            file.delete();
        }
        //Create the object document and load the file pdf file.

        //Instantiate page.
        PDPage page = new PDPage();

        //Get the page of the document.
        //page = document.getPage(0);

        document.addPage(page);
        //Initialize to add content into the pdf.
        PDPageContentStream pdf = new PDPageContentStream(document, page);
        String text = "This is a test";
        String output = "test.pdf";
        //Starts the string of the text.
        pdf.beginText();

        //Select font and font size
        pdf.setFont(PDType1Font.TIMES_ROMAN, 12);

        //setting the pos of the line.
        pdf.newLineAtOffset(62, 750);

        //this is our way to write the string into the text.
        //pdf.showText("Hello, how are you.");
        for(int i = 0; i < courseList.size(); i++) {
            pdf.showText(courseList.get(i).toString());
        }

        //pdf.showText(text);
        //to mark the end of the text.
        pdf.endText();
        //closes the pdf
        pdf.close();

        //output filename
        document.save(new File(output));

        //closes the document.
        document.close();
    }
}

}