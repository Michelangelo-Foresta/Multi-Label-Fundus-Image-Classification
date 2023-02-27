package packages;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PDFMethods {

    PDFMethods() {

    }
    public static void createPDF(Patient obj, Map<String,Float> disease, String path) throws IOException {
        //Set the path of the file if it exists, otherwise it will create a new one.
        //Declare variables here
        File file = new File(path);
        PDPage page = new PDPage();
        PDFont font = PDType1Font.TIMES_ROMAN;
        //Create the object document and load the file pdf file.
        PDDocument document = new PDDocument();
        document.addPage(page);

        ////////////////////////////////

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.newLineAtOffset(25, 725);
        contentStream.setFont(font,12);
        contentStream.setLeading(14.5f);

        contentStream.showText("First name: "+obj.getFirstName());
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Last name: "+obj.getLastName());
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Date of Birth: "+obj.getDobDay());
        contentStream.showText("/"+obj.getDobMonth());
        contentStream.showText("/"+obj.getDobYear());
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Medicare: "+obj.getMedicare());
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Address: "+ obj.getAddress());
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Email address: "+obj.getEmail());
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Macular Degeneration: "+String.valueOf(disease.get("Macular-Degen")));
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Glaucoma: "+String.valueOf(disease.get("Glauc")));

        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Cataracts: "+String.valueOf(disease.get("Cats")));
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("HyperTension: "+String.valueOf(disease.get("Hyper")));
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Myopia: "+String.valueOf(disease.get("Myopia")));
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Non-Proliferative Diabetes: "+String.valueOf(disease.get("Non-Prolif")));
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Normal: "+String.valueOf(disease.get("Normal")));
        System.out.println("Content added successfully");
        contentStream.endText();
        contentStream.close();

        //saving document
        document.save(path+"Diagnosis.pdf");
        //closing document
        document.close();
    }


}