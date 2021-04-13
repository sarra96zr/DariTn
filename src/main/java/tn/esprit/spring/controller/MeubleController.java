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

import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.service.MeubleService;


@RestController
public class MeubleController {
	@Autowired
	MeubleService meubleService;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-furnitures
		@GetMapping("/retrieve-all-furnitures")
		@ResponseBody
		public List<Meubles> getMeubles() {
			List<Meubles> list = meubleService.retrieveAllMeubles();
			return list;
		}
		// http://localhost:8081/DariTn/Pi/retrieve-furniture/{meuble-id}
				@GetMapping("/retrieve-furniture/{meuble-id}")
				@ResponseBody
				public Meubles retrieveMeuble(@PathVariable("meuble-id") String id_m) {
					return meubleService.retrieveMeubles(id_m);
				}

				// Ajouter : http://localhost:8081/DariTn/Pi/add-meuble
				@PostMapping("/add-meuble")
				@ResponseBody
				public Meubles addProduct(@RequestBody Meubles m) {
					 Meubles meuble = meubleService.addMeuble(m);
					return meuble;
				}

				// http://localhost:8081/DariTn/Pi/Delete-meuble/{meuble-id}
				@DeleteMapping("/Delete-meuble/{meuble-id}")
				@ResponseBody
				public void removeProduct(@PathVariable("meuble-id") String id_m) {
					meubleService.deleteMeubles(id_m);
					
				}

				// http://localhost:8086/ConsomiTounsi/servlet/modify-meuble
				@PutMapping("/modify-meuble")
				@ResponseBody
				public Meubles modifyProduct(@RequestBody Meubles m) {
					return meubleService.updateMeuble(m);
				}
				
}
