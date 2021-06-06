package tn.esprit.spring.controller;

import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Disponible;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.LocationRepository;
import tn.esprit.spring.service.LocationService;



@Scope(value="session")
@ELBeanName(value = "locationController") // Name of the bean used by JSF
@Join(path = "/", to = "/welcome.jsf")
@Controller(value = "locationController")
@RestController
public class LocationController {

	@Autowired
	LocationService locationService;
	@Autowired
	AnnonceRepository ann;
	List<Location> locations;
		
		// http://localhost:8081/DariTn/Pi/louer
	       @PostMapping("/louer/{datedeb}/{datefin}")
			@ResponseBody
			public Location addLocation(@PathVariable("datedeb") String datedeb,@PathVariable("datefin") String datefin) throws ParseException {
	    	   Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(datedeb);
	    	   Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(datefin);
	    	   if (date1.before(date2)){
	    	   Location l = locationService.addLocation(date1, date2);
				return l;}
	    	   else return null;
			}
			
	    // http://localhost:8081/DariTn/Pi/retrieve-all-location
	   	    @GetMapping("/retrieve-all-location")
	   		@ResponseBody
	   		public List<Location> getLocation() {
	   			List<Location> list = locationService.retrieveAllLocation();
	   			return list;
	   		}
	   	    //jsf
	   	    
	   	
	 	LocationRepository locationRepository;
	 	public Location location = new Location();

	 	
	 	public Date dateDebut;
	 	public Date dateFin;


	 	public void ajoutLocation() {
	 		System.err.println("*********"+location.id);
	 		//System.err.println("*********"+rdv.title);
	 		System.err.println("*********"+location.dateDebut);
	 		System.err.println("*********"+location.dateFin);
	 		MouseListener an;
	 		
	 	    location.dateDebut = GregorianCalendar.getInstance().getTime();
	 		location.dateFin = GregorianCalendar.getInstance().getTime();
	 		locationService.addOrUpdateLocation(new Location(dateDebut, dateFin, null, null, null) );
	 		//rdvService.addOrUpdateRDV(new RDV(rdv.dateRDV, rdv.dateDeb, rdv.dateFin));
	 	}
	 	
	 	
		public void validerLocation(@PathVariable("annonce-id") String id_a){
			System.err.println("hello1");
			Long id = Long.valueOf(id_a);
			Annonce a = ann.findById(id).get();
			
			System.err.println("hello2");
			a.setDisponible(Disponible.Reserve);
			System.err.println("hello3");
			
			
		}
		public void annulerLocation(@PathVariable("annonce-id") String id_a){
			System.err.println("hello1");
			Long id = Long.valueOf(id_a);
			Annonce a = ann.findById(id).get();
			a.setDisponible(Disponible.Dispo);
			System.err.println("hello2");
			
		}

	 	public String save() {

	 		
	 		locationRepository.save(location);
	 		location = new Location();
	 		location.dateDebut = GregorianCalendar.getInstance().getTime();
	 		// = GregorianCalendar.getInstance().getTime();
	 		location.dateFin = GregorianCalendar.getInstance().getTime();
	 		//System.err.println("*********"+rdv.RD);
	 		return "/DariTn/welcome.xhtml";
	 	}

		public LocationService getLocationService() {
			return locationService;
		}

		public void setLocationService(LocationService locationService) {
			this.locationService = locationService;
		}

		public LocationRepository getLocationRepository() {
			return locationRepository;
		}

		public void setLocationRepository(LocationRepository locationRepository) {
			this.locationRepository = locationRepository;
		}

		public Date getDateDebut() {
			return dateDebut;
		}

		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}

		public Date getDateFin() {
			return dateFin;
		}

		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

	 	
	 	
	 	
	 	
	 	
}