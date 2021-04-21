package tn.esprit.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.service.LocationService;

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

}