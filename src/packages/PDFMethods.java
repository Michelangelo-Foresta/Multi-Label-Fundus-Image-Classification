package packages;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class PDFMethods {
    static PDPageContentStream contentStream;
    static PDDocument document;
    static File file;
    public PDFMethods() {

    }

//Insert Directory of the path of the file you want to load. Including the filename.

    public static PDPageContentStream pdfMethod(String Path,  int pageNumber) throws IOException {
        File file = new File(Path);

        //Create the object document and load the file pdf file.
        PDDocument document = PDDocument.load(file);

        //Instantiate page.
        PDPage page = new PDPage();

        if (pageNumber > 0) {
            page = document.getPage(pageNumber);
        }

        //Get the page of the document.
        //page = document.getPage(0);

        document.addPage(page);
        //Initialize to add content into the pdf. Parses the document and page value from earlier.
        return new PDPageContentStream(document, page);
    }
    public static void writePDF(String Path, String input, String output, int pageNumber) throws IOException {
        pdfMethod(Path, pageNumber);

        contentStream.beginText();
        //set position
        contentStream.newLineAtOffset(25, 700);


        contentStream.setFont(PDType1Font.TIMES_ROMAN, 25);

        contentStream.showText(input);

        contentStream.endText();

        contentStream.close();
        document.save(file);
        document.close();
    }
}