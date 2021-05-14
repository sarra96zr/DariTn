package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Aonnement;
import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.cam;
import tn.esprit.spring.service.SurveillanceService;


@Scope (value = "session")
@Component (value = "surveillances")
@ELBeanName(value = "surveillances")
//@Join(path = "/surveillance", to = "/surveillance.jsf")
@Controller
public class SurveillanceController {
	
	
	@Autowired
	SurveillanceService ss;
	
	private Date datedeb;
	private Date datefin;
	private List<Surveillance> surveil;
	private Long id;
	private cam nombrecamera;
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
	public List<Surveillance> getSurveil() {
		surveil = ss.retrieveAllSurveillance();
		return surveil;
		
	}
	public void setSurveil(List<Surveillance> surveil) {
		this.surveil = surveil;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public cam getNombrecamera() {
		return nombrecamera;
	}
	public void setNombrecamera(cam nombrecamera) {
		this.nombrecamera = nombrecamera;
	}
	private Surveillance surveillance = new Surveillance();
	
	
	public Surveillance getSurveillance() {
		return surveillance;
	}
	public void setSurveillance(Surveillance surveillance) {
		this.surveillance = surveillance;
	}
	

	
	public cam[] getAb() {
		return  cam.values();
	}
	
	
	
	
	public void addSurveillance() {

		
		ss.addSurveillance(new Surveillance(datedeb, datefin, nombrecamera));
		
		
		}
	
	public void removeSurveillance(int id_b) { 
		ss.deleteSurveillance(id_b);
		getSurveil();
	}
	
	public void updateSurveillance() { 
		ss.updateSurveillance(new Surveillance(id, nombrecamera, datedeb, datefin));
	}
	
	
	public void displaySurveillance(Surveillance s){
		this.setDatedeb(s.getDateDebut());
		this.setDatefin(s.getDateFin());
		this.setNombrecamera(s.getCamera());
		this.setId(s.getId());
		
		
	}
	
}
