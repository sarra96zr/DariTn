package tn.esprit.spring.helper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.entity.Reclamations;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
public class GeneratePdfRec {
		 private List<Reclamations> listorders;

		public GeneratePdfRec(List<Reclamations> listUsers) {
	        this.listorders = listUsers;
	    }
	    private static float topRightTextSpace = -2f;
	    private static float signatureWidth = 100f;
	    private static float signatureHeight = 100f;
		  static String LogoUrl = "file:///C:/Users/ASUS/Desktop/logo.png";
		  
		    private static String SIGNATURE = "Signature";
		    
		   
		        protected String imageUrl;

		        public void setHeader(String imageUrl) {
		            this.imageUrl = imageUrl;
		        
		    }   
		        
		        
		    
	  
	    private void writeTableHeader(PdfPTable table) {
	    	
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(BaseColor.WHITE);
	         
	        cell.setPhrase(new Phrase("Type", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Titre de la réclamation", font));
	        
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Description", font));
	        
	        table.addCell(cell);
	    }
	   
	  
	    private void writeTableData(PdfPTable table) {
	        for (Reclamations order : listorders) {
	            table.addCell(String.valueOf(order.getType()));
	            table.addCell(String.valueOf(order.titreReclam));
	            table.addCell(String.valueOf(order.descriptionReclam));
	        }
	    }
	    
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(BaseColor.CYAN);
	        Image signImage = Image.getInstance("file:///C:/Users/ASUS/Desktop/logo.png");
	        signImage.scaleToFit(signatureWidth, signatureHeight);
	        signImage.setAlignment(Element.ALIGN_LEFT);
	        document.add(signImage);
	       
	        Paragraph p = new Paragraph("Liste des Réclamations", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);

	        document.add(p);
	      
	        PdfPTable table = new PdfPTable(3);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {2.5f, 3.5f, 3.0f});
	        table.setSpacingBefore(10);
	        
	        PdfPTable table1 = new PdfPTable(1);
	        table1.setWidthPercentage(25f);
	        table1.setWidths(new float[] {3.0f});
	        table1.setSpacingBefore(10);
	        
	        writeTableHeader(table);
	        writeTableData(table);
	        document.add(table);
	        document.close();
	         
	    }
	

}