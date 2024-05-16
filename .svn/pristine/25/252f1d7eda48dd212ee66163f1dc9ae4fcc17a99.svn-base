package co.com.flamingo.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.math.BigInteger;

public class BarCode128 {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

		Document document = new Document(new Rectangle(PageSize.LETTER));
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("s:/tmp/BarCode_128.pdf"));
		BigInteger  serial = new BigInteger ("2320000000799");

		document.open();

		Barcode128 code128 = new Barcode128();
		code128.setGenerateChecksum(true);
		
		PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);

        PdfPCell cell;
		cell = new PdfPCell(new Paragraph("CODIGOS DE PRUEBA - BONO REGALO"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(3);
		table.addCell(cell);
		
		for(int x = 0; x < 100; x = x + 3) {
			for (int y = 0; y < 3; y = y + 1) {
				serial = serial.add(new BigInteger("1"));
				code128.setCode(serial.toString());
				cell = new PdfPCell(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setFixedHeight(60f);
				table.addCell(cell);
			}
		}
		
		document.add(table);
		document.close();

		System.out.println("Document Generated...!!!!!!");
	}

}
