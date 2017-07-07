package personnal.iTextTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class html2PDFTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, DocumentException {
		html2PDFTest t = new html2PDFTest();
		t.testPDF();
	}
	
	public void testPDF() throws DocumentException, IOException {
		Rectangle test = new Rectangle(400,400);
		// step 1
        Document document = new Document(test,2,2,2,2);
        
      //  System.out.println(" : " + PageSize.A4.getWidth()+";"+PageSize.A4.getHeight());
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output/testItext.pdf"));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new InputStreamReader(
                new FileInputStream("testItext.html"), "UTF8"));
        
        //step 5
         document.close();
	}
}
