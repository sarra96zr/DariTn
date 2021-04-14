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

import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.service.RecService;


@RestController
public class RecController {
	@Autowired
	RecService RecService;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-reclamations
		@GetMapping("/retrieve-all-reclamations")
		@ResponseBody
		public List<Reclamations> getRecs() {
			List<Reclamations> list = RecService.retrieveAllRecs();
			return list;
		}
		// http://localhost:8081/DariTn/Pi/retrieve-reclamation/{rec-id}
				@GetMapping("/retrieve-reclamation/{rec-id}")
				@ResponseBody
				public Reclamations retrieveMeuble(@PathVariable("rec-id") String id_r) {
					return RecService.retrieveRec(id_r);
				}

				// http://localhost:8081/DariTn/Pi/add-reclamation
				@PostMapping("/add-reclamation")
				@ResponseBody
				public Reclamations addProduct(@RequestBody Reclamations r) {
					 Reclamations rec = RecService.addRec(r);
					return rec;
				}

				// http://localhost:8081/DariTn/Pi/Delete-rec/{rec-id}
				@DeleteMapping("/Delete-rec/{rec-id}")
				@ResponseBody
				public void removeProduct(@PathVariable("rec-id") String id_r) {
					RecService.deleteRec(id_r);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-reclamation
				@PutMapping("/modify-meuble")
				@ResponseBody
				public Reclamations modifyProduct(@RequestBody Reclamations r) {
					return RecService.updateRec(r);
				}
				
}
