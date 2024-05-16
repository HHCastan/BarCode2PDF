package co.com.flamingo.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class BarCode128List {
	public static void BarCode128(String pdfFileName, String txtFileName) throws DocumentException, IOException {
		Document document = new Document(new Rectangle(PageSize.LETTER));
		FileInputStream in = new FileInputStream(txtFileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
	
		document.open();

		Barcode128 code128 = new Barcode128();
		code128.setGenerateChecksum(true);
		
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
			code128.setCode(line.trim());
			cell = new PdfPCell(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
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

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

	
		
		Document document = new Document(new Rectangle(PageSize.LETTER));
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("s:/tmp/BarCode_128.pdf"));
		BigInteger[]  seriales = new BigInteger[60];
		seriales[0] = new BigInteger("067591162618");
		seriales[1] = new BigInteger("088840990092");
		seriales[2] = new BigInteger("067591160712");
		seriales[3] = new BigInteger("067655657763");
		seriales[4] = new BigInteger("067655657767");
		seriales[5] = new BigInteger("067655657766");
		seriales[6] = new BigInteger("082065292961");
		seriales[7] = new BigInteger("082065292963");
		seriales[8] = new BigInteger("009120153007");
		seriales[9] = new BigInteger("405656533211");
		seriales[10] = new BigInteger("082065292962");
		seriales[11] = new BigInteger("770538653999");
		seriales[12] = new BigInteger("067655665299");
		seriales[13] = new BigInteger("082622062336");
		seriales[14] = new BigInteger("082622063322");
		seriales[15] = new BigInteger("067655665507");
		seriales[16] = new BigInteger("067655665300");
		seriales[17] = new BigInteger("067655665313");
		seriales[18] = new BigInteger("065965882590");
		seriales[19] = new BigInteger("088841006379");
		seriales[20] = new BigInteger("082622063320");
		seriales[21] = new BigInteger("088841006381");
		seriales[22] = new BigInteger("088841006378");
		seriales[23] = new BigInteger("088841006380");
		seriales[24] = new BigInteger("082622063957");
		seriales[25] = new BigInteger("082622063834");
		seriales[26] = new BigInteger("082322904316");
		seriales[27] = new BigInteger("082322904318");
		seriales[28] = new BigInteger("009120153005");
		seriales[29] = new BigInteger("009120153006");
		seriales[30] = new BigInteger("082622063831");
		seriales[31] = new BigInteger("405656533620");
		seriales[32] = new BigInteger("009120153004");
		seriales[33] = new BigInteger("067655657769");
		seriales[34] = new BigInteger("088841006382");
		seriales[35] = new BigInteger("082622063833");
		seriales[36] = new BigInteger("009120152990");
		seriales[37] = new BigInteger("082622063926");
		seriales[38] = new BigInteger("405534227262");
		seriales[39] = new BigInteger("082322904312");
		seriales[40] = new BigInteger("405534227266");
		seriales[41] = new BigInteger("405534227261");
		seriales[42] = new BigInteger("082622062118");
		seriales[43] = new BigInteger("082622062117");
		seriales[44] = new BigInteger("088654969739");
		seriales[45] = new BigInteger("065965883130");
		seriales[46] = new BigInteger("088654969736");
		seriales[47] = new BigInteger("088841006377");
		seriales[48] = new BigInteger("067591162655");
		seriales[49] = new BigInteger("067591162620");
		seriales[50] = new BigInteger("067591163207");
		seriales[51] = new BigInteger("082622062119");
		seriales[52] = new BigInteger("067655657764");
		seriales[53] = new BigInteger("065965882331");
		seriales[54] = new BigInteger("082622063321");
		seriales[55] = new BigInteger("082622062323");
		seriales[56] = new BigInteger("405728226203");
		seriales[57] = new BigInteger("405728226202");
		document.open();

		Barcode128 code128 = new Barcode128();
		code128.setGenerateChecksum(true);
		
		PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);

        PdfPCell cell;
		cell = new PdfPCell(new Paragraph("CODIGOS DE PRUEBA - TRANSACCIÓN BLOQUEADA"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(3);
		table.addCell(cell);
		
		for(int x = 0; x < 57; x = x + 3) {
			for (int y = 0; y < 3; y = y + 1) {
				code128.setCode(seriales[x+y].toString());
				cell = new PdfPCell(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setFixedHeight(100f);
				table.addCell(cell);
			}
		}
		
		document.add(table);
		document.close();

		System.out.println("Document Generated...!!!!!!");
	}

}
