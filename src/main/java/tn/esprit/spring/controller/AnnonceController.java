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

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.service.AnnonceService;
import tn.esprit.spring.service.MeubleService;

@RestController
public class AnnonceController {

	@Autowired
	AnnonceService annonceService;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-annonces
	@GetMapping("/retrieve-all-annonces")
		@ResponseBody
		public List<Annonce> getAnnonces() {
			List<Annonce> list = annonceService.retrieveAllAnnonces();
			return list;
		}
	
		// http://localhost:8081/DariTn/Pi/retrieve-annonces/{annonce-id}
				@GetMapping("/retrieve-annonce/{annonce-id}")
				@ResponseBody
				public Annonce retrieveAnnoce(@PathVariable("annonce-id") String id_m) {
					return annonceService.retrieveAnnonce(id_m);
				}

				// Ajouter : http://localhost:8081/DariTn/Pi/add-annonce
				@PostMapping("/add-annonce")
				@ResponseBody
				public Annonce addProduct(@RequestBody Annonce a) {
					 Annonce annonce = annonceService.addAnnonce(a);
					return annonce;
				}

				// http://localhost:8081/DariTn/Pi/Delete-annonce/{annonce-id}
				@DeleteMapping("/Delete-annonce/{annonce-id}")
				@ResponseBody
				public void removeAnnonce(@PathVariable("annonce-id") String id_a) {
					annonceService.deleteAnnonce(id_a);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-annoce
				@PutMapping("/modify-annonce")
				@ResponseBody
				public Annonce modifyAnnoce(@RequestBody Annonce a) {
					return annonceService.updateAnnonce(a);
				}

}
