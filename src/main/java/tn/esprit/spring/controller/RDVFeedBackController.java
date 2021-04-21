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
import tn.esprit.spring.entity.RDVFeedBack;
import tn.esprit.spring.service.RDVFeedBackService;

@RestController
public class RDVFeedBackController {
	
	@Autowired
	RDVFeedBackService rdvFeedBackService;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-RDVFeedBack
		@GetMapping("/retrieve-all-RDVFeedBack")
		@ResponseBody
		public List<RDVFeedBack> getRDVFeedBack() {
			List<RDVFeedBack> list = rdvFeedBackService.retrieveAllRDVFeedBack();
			return list;
		}
		// http://localhost:8081/DariTn/Pi/retrieve-RDVFeedBack/{rdvFeedBack-id}
				@GetMapping("/retrieve-rdvFeedBack/{rdvFeedBack-id}")
				@ResponseBody
				public RDVFeedBack retrieveRDVFeedBack(@PathVariable("rdvFeedBack-id") String id_rdv_feedback) {
					return rdvFeedBackService.retrieveRDVFeedBack(id_rdv_feedback);
				}

				// Ajouter : http://localhost:8081/DariTn/Pi/add-RDVFeedBack
				@PostMapping("/add-RDVFeedBack")
				@ResponseBody
				public RDVFeedBack addRDVFeedBack(@RequestBody RDVFeedBack rf) {
					 RDVFeedBack rdvf = rdvFeedBackService.addRDVFeedBack(rf);
					return rdvf;
				}

				// http://localhost:8081/DariTn/Pi/Delete-rdvFeedBack/{rdvFeedBack-id}
				@DeleteMapping("/Delete-rdvFeedBack/{rdvFeedBack-id}")
				@ResponseBody
				public void removeRDVFeedBack(@PathVariable("rdvFeedBack-id") String id_rdv_feedback) {
					rdvFeedBackService.deleteRDVFeedBack(id_rdv_feedback);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-rdvFeedBack
				@PutMapping("/modify-rdvFeedBack")
				@ResponseBody
				public RDVFeedBack modifyRDVFeedBack(@RequestBody RDVFeedBack rf) {
					return rdvFeedBackService.updateRDVFeedBack(rf);
				}
				
}
