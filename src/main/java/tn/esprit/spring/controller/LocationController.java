package tn.esprit.spring.controller;

import java.sql.Date;
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
			public Location addLocation(@PathVariable("datedeb") Date datedeb,@PathVariable("datefin") Date datefin) {
				 Location l = locationService.addLocation(datedeb, datefin);
				return l;
			}
			
		

}