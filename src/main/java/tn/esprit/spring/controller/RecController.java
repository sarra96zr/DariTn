package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.helper.GeneratePdfRec;


import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.entity.Type_Rec;
import tn.esprit.spring.repository.ClientRepo;
import tn.esprit.spring.repository.RecRepo;
import tn.esprit.spring.service.RecService;


@Scope(value = "session")
@Controller(value = "RecController") // Name of the bean in Spring IoC
@ELBeanName(value = "RecController") // Name of the bean used by JSF
@Join(path = "/", to = "/RecPrimeClient.jsf")
@RestController

public class RecController {

	public Reclamations rec = new Reclamations();

	public RecRepo RecDAO;
	public ClientRepo ClientDAO;	

	private String titreReclam;
	private String descriptionReclam;
	private Type_Rec type;
	private long id_reclamSelected;
	Client client;
	@Autowired
	private RecService RecService;



	public Type_Rec[] getTypes() { return Type_Rec.values(); } 

	// http://localhost:8081/DariTn/retrieve-all-reclamations
	@GetMapping("/retrieve-all-reclamations")
	@ResponseBody
	public List<Reclamations> getRecs() {
		return RecService.retrieveAllRecs();
	}
	// http://localhost:8081/DariTn/retrieve-reclamation/{rec-id}
	@GetMapping("/retrieve-reclamation/{rec-id}")
	@ResponseBody
	public Reclamations retrieveRec(@PathVariable("rec-id") String id_r) {
		return RecService.retrieveRec(id_r);
	}

	// http://localhost:8081/DariTn/add-reclamation
	//@PostMapping("/add-reclamation")
	//@ResponseBody
	//public Reclamations addProduct(@RequestBody Reclamations r) {
	//	 Reclamations rec = RecService.addRec(r);
	//	return rec;
	//}

	// http://localhost:8081/DariTn/Delete-rec/{rec-id}
	@DeleteMapping("/Delete-rec/{rec-id}")
	@ResponseBody
	public void removeProduct(@PathVariable("rec-id") String id_r) {
		RecService.deleteRec(id_r);

	}

	// http://localhost:8081/DariTn/modify-reclamation
	@PutMapping("/modify-rec")
	@ResponseBody
	public Reclamations modifyProduct(@RequestBody Reclamations r) {
		return RecService.updateRec(r);
	}

	// http://localhost:8081/DariTn/findByType/{rec-type}
	@GetMapping("/findByType/{rec-type}")
	@ResponseBody
	public List<Reclamations> SearchRecByType(@PathVariable("rec-type") Type_Rec type) {
		return RecService.RechercheRec(type);
	}

	// http://localhost:8081/DariTn/reclamations/client/get/{client}			
	@GetMapping("/reclamations/client/get/{client}")
	@ResponseBody
	public List<Reclamations> findClientById(@PathVariable("client") int id_client)
	{
		List<Reclamations> liste=RecService.findByClientId(id_client);
		return liste;
	}

	// http://localhost:8081/DariTn/add-reclamation/{client}
	@PutMapping("/add-reclamation/{client}")
	@ResponseBody
	public ResponseEntity<String> ajouterRec(@PathVariable("client")int client, @RequestBody Reclamations r)
	{
		RecService.ajouterRec(client,r);
		return new ResponseEntity<>("Ajout réussi.", HttpStatus.CREATED);


	}

	// http://localhost:8081/DariTn/modify-reclamation/{rec}/{client}
	@PutMapping("/modify-reclamation/{rec}/{client}")
	@ResponseBody
	public ResponseEntity<String> modifierCredit(@PathVariable("rec")int rec,@PathVariable("client")int client)
	{
		RecService.modifierRec(rec);		
		return new ResponseEntity<>("modification résussie.", HttpStatus.ACCEPTED);
	}

	// http://localhost:8081/DariTn/reclamations/panier/{panier}			
	@GetMapping("/reclamations/panier/{panier}")
	@ResponseBody
	public List<Reclamations> findRecWithPID(@PathVariable("panier") long id_panier)
	{
		return RecService.findRecWithPID(id_panier);

	}

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Reclamations> rec = RecService.retrieveAllRecs();
		model.addAttribute("listReclamations", rec);

		return "index";
	}

	public void save() {
		System.err.println("*********");
		//Reclamations r = new Reclamations();
		//Client c = new Client();
		//r.setId_reclam(2);
		//c.setId_user(1);
		//r.setClient(c);
		//r.setDescriptionReclam(rec.getDescriptionReclam());
		//r.setTitreReclam(rec.getTitreReclam());
		rec.setType(type);
		RecService.ajouterRec(1, rec);
		clear();
	}

	public void save1()

	{ rec.setType(type);
	RecService.ajouterRec(1, rec);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Réclamation ajouté"));
    PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
    PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    clear();    
   	}

	public void show(Reclamations r ) throws Exception {
		System.err.println("*********"+r);
		this.rec.setId_reclam(r.getId_reclam());
		this.rec.setTitreReclam(r.getTitreReclam());
		this.rec.setDescriptionReclam(r.getDescriptionReclam());
		this.rec.setClient(r.getClient1());
	}

	
	public void update1(){
		
		rec.setType(type);
		RecService.update(rec);
		clear();
	}
	
	
	public List<Reclamations> findClientById1()
	{
		List<Reclamations> liste=RecService.findByClientId(1);
		return liste;
	}
	
	
	//PDF
	// http://localhost:8083/orders/export/pdf
	@RequestMapping("/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException, com.itextpdf.text.DocumentException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Reclamations> listorders = RecService.retrieveAllRecs();

		GeneratePdfRec exporter = new GeneratePdfRec(listorders);
		exporter.export(response);
	}


	@PostMapping(value="/textemail",consumes = "application/json", produces = "application/json")
	public String sendEmail(@RequestBody Reclamations emailTemplate) {
		try {
			//log.info("Sending Simple Text Email....");
			RecService.sendTextEmail(emailTemplate);
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
	}
	
	
	public void onRowEdit(RowEditEvent<Reclamations> event, Reclamations r) {
		System.err.println("*********"+r);
		this.rec.setId_reclam(r.getId_reclam());
		this.rec.setTitreReclam(r.getTitreReclam());
		this.rec.setDescriptionReclam(r.getDescriptionReclam());
		this.rec.setClient(r.getClient1());
		rec.setType(type);
		RecService.update(rec);
		clear();
        FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getTitreReclam()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Reclamations> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getTitreReclam()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
	public void clear(){
		rec.setClient(null);
	    rec.setDescriptionReclam(null);
	    rec.setTitreReclam(null);
	    rec.setType(null);
	    rec.setId_reclam(0);
	}

	public long getId_reclamSelected() {
		return id_reclamSelected;
	}

	public void setId_reclamSelected(long id_reclamSelected) {
		this.id_reclamSelected = id_reclamSelected;
	}

	public Reclamations getRec() {
		return rec;
	}

	public void setRec(Reclamations rec) {
		this.rec = rec;
	}

	public String getTitreReclam() {
		return titreReclam;
	}
	public void setTitreReclam(String titreReclam) {
		this.titreReclam = titreReclam;
	}
	public String getDescriptionReclam() {
		return descriptionReclam;
	}
	public void setDescriptionReclam(String descriptionReclam) {
		this.descriptionReclam = descriptionReclam;
	}
	public Type_Rec getType() {
		return type;
	}
	public void setType(Type_Rec type) {
		this.type = type;
	}

	public void setClient(Client client) {
		this.client = client;
	}



}
