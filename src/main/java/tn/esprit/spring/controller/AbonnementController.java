package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.service.AbonnementService;




@RestController
public class AbonnementController {
	@Autowired
	AbonnementService abservice;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-abonnement
		@GetMapping("/retrieve-all-abonnement")
		@ResponseBody
		public List<Abonnement> getAbonnement() {
			List<Abonnement> list = abservice.retrieveAllAbonnement();
			return list;
		}
		// http://localhost:8081/DariTn/Pi/retrieve-abonnement/{abonnement-id}
				@GetMapping("/retrieve-abonnement/{abonnement-id}")
				@ResponseBody
				public Abonnement retrieveAbonnement(@PathVariable("abonnement-id") String id_ab) {
					return abservice.retrieveAbonnement(id_ab);
				}

				// Ajouter : http://localhost:8081/DariTn/Pi/add-abonnement
				@PostMapping("/add-abonnement")
				@ResponseBody
				public Abonnement addAbonnement(@RequestBody Abonnement ab) {
					Abonnement abonnement = abservice.addAbonnement(ab);
					return abonnement;
				}

				// http://localhost:8081/DariTn/Pi/Delete-abonnement/{abonnement-id}
				@DeleteMapping("/Delete-abonnement/{abonnement-id}")
				@ResponseBody
				public void removeAbonnement(@PathVariable("abonnement-id") String id_ab) {
					abservice.deleteAbonnement(id_ab);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-abonnement
				@PutMapping("/modify-abonnement")
				@ResponseBody
				public Abonnement modifyAbonnementt(@RequestBody Abonnement ab) {
					return abservice.updateAbonnement(ab);
				}
				
				// recherche par type
				// http://localhost:8081/DariTn/Pi/search-abonnement/{abonnement-type}
				@GetMapping("/search-abonnement/{abonnement-type}")
				@ResponseBody
				public List<Abonnement> SearchAbonnementByType(@PathVariable("abonnement-type") String type_abonnement) {
					return abservice.SearchAbonnementByType(type_abonnement);
				}
				
				
				
}
