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

import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Meubles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
public class GeneratePdfReport {
		 private List<Commande> listorders;

		public GeneratePdfReport(List<Commande> listUsers) {
	        this.listorders = listUsers;
	    }
	    private static float topRightTextSpace = -2f;
	    private static float signatureWidth = 100f;
	    private static float signatureHeight = 100f;
		  static String LogoUrl = "file:///C:/Users/Sarra/Desktop/Esprit/logo.png";
		  
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
	         
	        cell.setPhrase(new Phrase("Nom du meuble", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Date de commande", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("statut", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Prix", font));
	        table.addCell(cell);
	         
	     /*   cell.setPhrase(new Phrase("Enabled", font));
	        table.addCell(cell);   */    
	    }
	    private void writeTableHeaders(PdfPTable table1) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(BaseColor.WHITE);
	         
	        cell.setPhrase(new Phrase("Prix a payer", font));
	         
	        table1.addCell(cell);
	         
	      
	    }
	  
	    private void writeTableData(PdfPTable table) {
	        for (Commande order : listorders) {
	            table.addCell(String.valueOf(order.getM().getNom_meuble()));
	            table.addCell(String.valueOf(order.getDate_order()));
	            table.addCell(String.valueOf(order.getStatut()));
	            table.addCell(String.valueOf(order.getPrice_order()));
	           // table.addCell(String.valueOf(order.getBasket().getType_paiement()));

	        }
	    }
	    
	    private void writeTableDatas(PdfPTable table1) {
	        for (Commande order : listorders) {
	            table1.addCell(String.valueOf(order.getM().getPrix()));
	            

	        }
	    }
	    
	    
	   /* private void writeTableDatass(PdfPTable table2) {
	        for (Orders order : listorders) {
	            table2.addCell(String.valueOf(order.getBasket().getClient().getFirst_name_user()));
	            table2.addCell(String.valueOf(order.getBasket().getClient().getLast_name_user()));

	            table2.addCell(String.valueOf(order.getBasket().getClient().getEmail_user()));
	            table2.addCell(String.valueOf(order.getBasket().getClient().getAddress_user()));
	            table2.addCell(String.valueOf(order.getBasket().getDate_basket()));
	            

	        }
	    }*/
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(BaseColor.CYAN);
	        Image signImage = Image.getInstance("file:///C:/Users/Sarra/Desktop/Esprit/logo.png");
	        signImage.scaleToFit(signatureWidth, signatureHeight);
	        signImage.setAlignment(Element.ALIGN_LEFT);
	        document.add(signImage);
	       
	        Paragraph p = new Paragraph("Votre commande", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);

	        document.add(p);
	      
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
	        table.setSpacingBefore(10);
	        
	        PdfPTable table1 = new PdfPTable(1);
	        table1.setWidthPercentage(25f);
	        table1.setWidths(new float[] {3.0f});
	        table1.setSpacingBefore(10);
	         
	     /*   PdfPTable table2 = new PdfPTable(5);
	        table2.setWidthPercentage(25f);
	        table2.setWidths(new float[] {3.0f,3.0f,3.0f,3.0f,3.0f});
	        table2.setSpacingBefore(10);*/
	        
	        writeTableHeader(table);
	        writeTableData(table);
	        writeTableHeaders(table1);
	        writeTableDatas(table1);
	       /* writeTableHeaderss(table2);
	        writeTableDatass(table2);*/
	        document.add(table);
	        document.add(table1);
	     //   document.add(table2);

	        document.close();
	         
	    }
	

}



