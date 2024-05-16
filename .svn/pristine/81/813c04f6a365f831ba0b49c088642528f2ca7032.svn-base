package co.com.flamingo.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class BarEAN8 {
	public static void PDFGenEAN8(String pdfFileName, String txtFileName) throws Exception {
		Document document = new Document(new Rectangle(PageSize.LETTER));
		FileInputStream in = new FileInputStream(txtFileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
	
		document.open();
		
		BarcodeEAN ean8 = new BarcodeEAN();
		ean8.setGenerateChecksum(true);
				
		PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);

        PdfPCell cell;
		cell = new PdfPCell(new Paragraph("CODIGOS DE PRUEBA"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(3);
		table.addCell(cell);
		
		String line = reader.readLine();
		while (line != null) {
			line = line.trim() + getEAN8CheckDigit(line.trim());
			ean8.setCode(line);
			ean8.setCodeType(BarcodeEAN.EAN8);
			cell = new PdfPCell(ean8.createImageWithBarcode(writer.getDirectContent(), null, null));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setFixedHeight(100f);
			table.addCell(cell);
			line = reader.readLine();
		}
		
		reader.close();
		in.close();
		document.add(table);
		document.close();

	}

	private static String getEAN8CheckDigit(String ean) throws Exception {
		 
        if (ean.length() != 7) {
            throw new Exception("Please provide an input string of 7 chars. Current lenght: "+ean.length());
        }
        long tot = 0;
 
        for (int i = 0; i < 7; i++) {
            tot = tot + (Long.parseLong(String.valueOf(ean.charAt(i))) * (i % 2 == 0 ? 1 : 3));
        }
        return tot % 10 == 0 ? "0" : "" +(10-(tot % 10));
    }
}
