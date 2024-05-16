package co.com.flamingo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BarCode128Bonos {
	public static String BarCode128(String strPathOut, String txtFileName, String strLegales, String strMecanica, String strTerminosCondiciones, String subtitulo) throws DocumentException, IOException {
		FileInputStream in = new FileInputStream(txtFileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String strDate = LocalDate.now().format(formatter);
		strPathOut = strPathOut + "/" + strDate;
        Image img = Image.getInstance(BarCode128Bonos.class.getResource("/recursos/LogoFlamingo.png"));
        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
        Font monoFont = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
	
        File directory = new File(strPathOut);
        if (! directory.exists()){
            directory.mkdir();
        }        
		Barcode128 code128 = new Barcode128();
		code128.setGenerateChecksum(true);
		
		
		String line = reader.readLine();
		while (line != null) {
			if(line.indexOf(",") < 1) {
				JOptionPane.showMessageDialog(new JFrame(), "Esta línea no contiene los campos requeridos y será ignorada: " + line);
				continue;
			}
			
			String [] datos = line.split(",");
			
			Document document = new Document(new Rectangle(PageSize.LETTER));
			document.setMargins(20, 20, 20, 20);
			String pdfFileName = strPathOut + "/" + datos[0].trim() + ".pdf";
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
			document.open();
			
			double valor = Double.parseDouble(datos[1]); 
			Locale col = new Locale("es", "CO");
			NumberFormat pesosFormat = NumberFormat.getCurrencyInstance(col);
			pesosFormat.setMaximumFractionDigits(0);

			PdfPTable table = new PdfPTable(1);
	        table.setWidthPercentage(100);
	        table.setSpacingBefore(0f);
	        table.setSpacingAfter(0f);

	        PdfPCell cell1;
			cell1 = new PdfPCell(img, false);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell1.setBorder(Rectangle.NO_BORDER);

	        Paragraph preface = new Paragraph();

	        preface.add(new Paragraph(subtitulo + " por " + pesosFormat.format(valor), catFont));
	        preface.add(new Paragraph(MontoEscrito.cantidadConLetra(datos[1]), smallBold));
			if(datos.length > 2) {
				preface.add(new Paragraph("A nombre de: " + datos[2]));
			}
			if(datos.length > 3) {
				preface.add(new Paragraph("Cédula: " + datos[3]));
			}
	        PdfPCell cell2 = new PdfPCell(preface);
	        cell2.setBorder(Rectangle.NO_BORDER);
	        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        
			table.addCell(cell1);
			table.addCell(cell2);
			
			
			code128.setCode(datos[0].trim());
			code128.setX(1f); //máximo ancho del código de barras
			cell1 = new PdfPCell(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell1.setBorder(Rectangle.NO_BORDER);
			cell1.setFixedHeight(100f);
			table.addCell(cell1);
			document.add(table);
			
	        preface = new Paragraph();
	        preface.setAlignment(Element.ALIGN_CENTER);
	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph("INFORMACIÓN IMPORTANTE:" , subFont));
	        preface.add(new Paragraph(strLegales, smallBold));

	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph("MECÁNICA DE REDENCIÓN:" , subFont));
	        preface.add(new Paragraph(strMecanica, smallBold));
	        
	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph("TÉRMINOS Y CONDICIONES:" , subFont));
	        preface.add(new Paragraph(strTerminosCondiciones, smallBold));
	        
	        document.add(preface);

			line = reader.readLine();
			document.close();
		}
		
		reader.close();
		in.close();
		return strPathOut;

	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }


}
