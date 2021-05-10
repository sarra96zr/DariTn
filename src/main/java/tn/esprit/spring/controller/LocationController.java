package tn.esprit.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.repository.LocationRepository;
import tn.esprit.spring.service.LocationService;



@Scope(value="session")
@ELBeanName(value = "annonceController") // Name of the bean used by JSF
@Join(path = "/", to = "/welcome.jsf")
@Controller(value = "annController")
@RestController
public class LocationController {

	@Autowired
	LocationService locationService;
	
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

	 	
	 	public Date dateDeb;
	 	public Date dateFin;


	 	public void ajoutLocation() {
	 		System.err.println("*********"+location.id);
	 		//System.err.println("*********"+rdv.title);
	 		System.err.println("*********"+location.dateDebut);
	 		System.err.println("*********"+location.dateFin);
	 	    location.dateDebut = GregorianCalendar.getInstance().getTime();
	 		location.dateFin = GregorianCalendar.getInstance().getTime();
	 		locationService.addOrUpdateLocation(new Location(location.dateDebut, location.dateFin, 347.5, null, null) );
	 		//rdvService.addOrUpdateRDV(new RDV(rdv.dateRDV, rdv.dateDeb, rdv.dateFin));
	 	}

	 	public String save() {


	 		location.save(location);
	 		location = new Location();
	 		location.dateDebut = GregorianCalendar.getInstance().getTime();
	 		// = GregorianCalendar.getInstance().getTime();
	 		location.dateFin = GregorianCalendar.getInstance().getTime();
	 		//System.err.println("*********"+rdv.RD);
	 		return "/DariTn/RDV.xhtml";
	 	}

}