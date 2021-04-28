package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.entity.Type_Rec;
import tn.esprit.spring.service.RecService;


@RestController
public class RecController {
	@Autowired
	RecService RecService;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-reclamations
		@GetMapping("/retrieve-all-reclamations")
		@ResponseBody
		public List<Reclamations> getRecs() {
			return RecService.retrieveAllRecs();
		}
		// http://localhost:8081/DariTn/Pi/retrieve-reclamation/{rec-id}
				@GetMapping("/retrieve-reclamation/{rec-id}")
				@ResponseBody
				public Reclamations retrieveRec(@PathVariable("rec-id") String id_r) {
					return RecService.retrieveRec(id_r);
				}

				// http://localhost:8081/DariTn/Pi/add-reclamation
				//@PostMapping("/add-reclamation")
				//@ResponseBody
				//public Reclamations addProduct(@RequestBody Reclamations r) {
				//	 Reclamations rec = RecService.addRec(r);
				//	return rec;
				//}

				// http://localhost:8081/DariTn/Pi/Delete-rec/{rec-id}
				@DeleteMapping("/Delete-rec/{rec-id}")
				@ResponseBody
				public void removeProduct(@PathVariable("rec-id") String id_r) {
					RecService.deleteRec(id_r);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-reclamation
				@PutMapping("/modify-rec")
				@ResponseBody
				public Reclamations modifyProduct(@RequestBody Reclamations r) {
					return RecService.updateRec(r);
				}
				
				// http://localhost:8081/DariTn/Pi/findByType/{rec-type}
				@GetMapping("/findByType/{rec-type}")
				@ResponseBody
				public List<Reclamations> SearchRecByType(@PathVariable("rec-type") Type_Rec type) {
					return RecService.RechercheRec(type);
				}
				
			    // http://localhost:8081/DariTn/Pi/reclamations/client/get/{client}			
				@GetMapping("/reclamations/client/get/{client}")
				@ResponseBody
				public List<Reclamations> findClientById(@PathVariable("client") int id_client)
				{
					List<Reclamations> liste=RecService.findByClientId(id_client);
					return liste;
				}
	
				// http://localhost:8081/DariTn/Pi/add-reclamation/{client}
				@PutMapping("/add-reclamation/{client}")
				@ResponseBody
				public ResponseEntity<String> ajouterRec(@PathVariable("client")int client, @RequestBody Reclamations r)
				{
					RecService.ajouterRec(client,r);
					return new ResponseEntity<>("Ajout réussi.", HttpStatus.CREATED);
				
					
				}
				
				// http://localhost:8081/DariTn/Pi/modify-reclamation/{rec}/{client}
				@PutMapping("/modify-reclamation/{rec}/{client}")
				@ResponseBody
				public ResponseEntity<String> modifierCredit(@PathVariable("rec")int rec,@PathVariable("client")int client)
				{
					RecService.modifierRec(rec);		
					return new ResponseEntity<>("modification résussie.", HttpStatus.ACCEPTED);
				}
				
				// http://localhost:8081/DariTn/Pi/reclamations/panier/{panier}			
				@GetMapping("/reclamations/panier/{panier}")
				@ResponseBody
				public List<Reclamations> findRecWithPID(@PathVariable("panier") Long id_panier)
				{
					List<Reclamations> liste=RecService.findRecWithPID(id_panier);
					return liste;
				}
				
				
				
}
