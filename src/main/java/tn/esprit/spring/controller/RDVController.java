package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.RDV;
import tn.esprit.spring.service.RDVService;


@Scope(value = "session")
@Controller(value = "RDVController") // Name of the bean in Spring IoC
@ELBeanName(value = "RDVController") // Name of the bean used by JSF
@Join(path = "/", to = "/AddRDV.jsf")
@RestController

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
				@GetMapping("/retrieve-rdv/{rdv-id}")
				@ResponseBody
				public RDV retrieveRDV(@PathVariable("rdv-id") String id_rdv) {
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
				public void removeRDV(@PathVariable("rdv-id") Long id_rdv) {
					rdvService.deleteRDV(id_rdv);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-rdv
				@PutMapping("/modify-rdv/{id_rdv}")
				@ResponseBody
				public RDV modifyRDV(@RequestBody RDV r,@PathVariable("id_rdv") Long id_rdv) {
					return rdvService.updateRDV(r,id_rdv);
				}
				
				/*// http://localhost:8081/DariTn/Pi/rdv/{dateDeb}/{dateFin}
				@GetMapping("/rdv/{dateDeb}/{dateFin}")
				List<RDV> RDV(@PathVariable("dateDeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date  dateDeb, @PathVariable("dateFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFin)
				{
				    return rdvService.getRDV(dateDeb,dateFin);
				}*/
				
				// http://localhost:8081/DariTn/Pi/searchRDV/{title}
				/*@GetMapping("/searchRDV/{title}")
				public List<RDV> searchRDV(@PathVariable("title") String title) {
					return rdvService.searchRDV(title);
				}*/
				
}



