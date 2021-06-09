package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Aonnement;
import tn.esprit.spring.entity.Assur;
import tn.esprit.spring.entity.Assurance;
import tn.esprit.spring.helper.GeneratePdfRec;
import tn.esprit.spring.service.AssuranceService;


@Scope(value = "session")
@Controller(value = "assuranceController")
@ELBeanName(value = "assuranceController")
//@Join(path= "/DariTn", to = "/assurance.jsf")
public class AssuranceController {
	
	@Autowired
	AssuranceService assuranceservice;
	private Long id;
	private Date datedeb;
	private Date datefin;
	private List<Assurance> assurances;
	
	
	//PDF
	// http://localhost:8081/DariTn/orders/export/pdf
	@RequestMapping("/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException, com.itextpdf.text.DocumentException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Assurance> listorders = assuranceservice.retrieveAllAssurance();

		GeneratePdfRec exporter = new GeneratePdfRec(listorders);
		exporter.export(response);
	}
	
	public List<Assurance> getAssurances() {
		assurances = assuranceservice.retrieveAllAssurance();
		return assurances;
	}
	public void setAssurances(List<Assurance> assurances) {
		this.assurances = assurances;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Assurance getAssurance() {
		return assurance;
	}
	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}
	public Date getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public Assur getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Assur entreprise) {
		this.entreprise = entreprise;
	}
	
	private Assur assur;
	
	public Assur getAssur() {
		return assur;
	}
	public void setAssur(Assur assur) {
		this.assur = assur;
	}

	private Assur entreprise;
	public Assur[] getEntreprises() { 
		return Assur.values();
		}
	
	private Assurance assurance = new Assurance();
public void addAssurance() {
		
	
		
		assuranceservice.addOrUpdateAssurance(new Assurance( datedeb, datefin,assur));
		}

public void removeAssurance(int id) { 
	assuranceservice.deleteAssurance(id);
	getAssurances();
}

public void updateAssurance() { 
	assuranceservice.updateAssurance(new Assurance(id, datedeb, datefin,assur));
}


public void displayAssurance(Assurance a){
	this.setId(a.getId());
	this.setDatedeb(a.getDateDebut());
	this.setDatefin(a.getDateFin());
	this.setAssur(a.getAssur());
	
	
	
}



}
