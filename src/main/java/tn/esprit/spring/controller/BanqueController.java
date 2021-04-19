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

import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.service.BanqueService;


@RestController
public class BanqueController {
	@Autowired
	BanqueService banqueService;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-banque
		@GetMapping("/retrieve-all-banque")
		@ResponseBody
		public List<Banque> getBanque() {
			List<Banque> list = banqueService.retrieveAllBanque();
			return list;
		}
		// http://localhost:8081/DariTn/Pi/retrieve-banque/{banque-id}
				@GetMapping("/retrieve-banque/{banque-id}")
				@ResponseBody
				public Banque retrieveMeuble(@PathVariable("banque-id") String id_b) {
					return banqueService.retrieveBanque(id_b);
				}

				// Ajouter : http://localhost:8081/DariTn/Pi/add-banque
				@PostMapping("/add-banque")
				@ResponseBody
				public Banque addBanque(@RequestBody Banque b) {
					 Banque banque = banqueService.addBanque(b);
					return banque;
				}

				// http://localhost:8081/DariTn/Pi/Delete-banque/{banque-id}
				@DeleteMapping("/Delete-banque/{banque-id}")
				@ResponseBody
				public void removeBanque(@PathVariable("banque-id") String id_b) {
					banqueService.deleteBanque(id_b);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-banque
				@PutMapping("/modify-banque")
				@ResponseBody
				public Banque modifyBanque(@RequestBody Banque b) {
					return banqueService.updateBanque(b);
				}
				
				// recherche par nom
				// http://localhost:8081/DariTn/Pi/search-banque/{banque-name}
				@GetMapping("/search-banque/{banque-name}")
				@ResponseBody
				public List<Banque> SearchBanqueByName(@PathVariable("banque-name") String name_banque) {
					return banqueService.SearchBanqueByName(name_banque);
				}
				
}
