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
import tn.esprit.spring.entity.RDV;
import tn.esprit.spring.service.RDVService;

public class RDVController {
	
	@Autowired
	RDVService rdvService;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-RDV
		@GetMapping("/retrieve-all-RDV")
		@ResponseBody
		public List<RDV> getRDV() {
			List<RDV> list = rdvService.retrieveAllRDV();
			return list;
		}
		// http://localhost:8081/DariTn/Pi/retrieve-RDV/{rdv-id}
				@GetMapping("/retrieve-furniture/{rdv-id}")
				@ResponseBody
				public RDV retrieveRDV(@PathVariable("meuble-id") String id_rdv) {
					return rdvService.retrieveRDV(id_rdv);
				}

				// Ajouter : http://localhost:8081/DariTn/Pi/add-RDV
				@PostMapping("/add-RDV")
				@ResponseBody
				public RDV addRDV(@RequestBody RDV r) {
					 RDV rdv = rdvService.addRDV(r);
					return rdv;
				}

				// http://localhost:8081/DariTn/Pi/Delete-rdv/{rdv-id}
				@DeleteMapping("/Delete-rdv/{rdv-id}")
				@ResponseBody
				public void removeRDV(@PathVariable("rdv-id") String id_rdv) {
					rdvService.deleteRDV(id_rdv);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-rdv
				@PutMapping("/modify-rdv")
				@ResponseBody
				public RDV modifyRDV(@RequestBody RDV r) {
					return rdvService.updateRDV(r);
				}
				
}



