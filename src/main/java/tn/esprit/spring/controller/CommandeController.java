package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.service.CommandeService;

public class CommandeController {
	@Autowired
	CommandeService ordersService;
	// affichage
		// http://localhost:8081/DariTn/Pi/ordersmeuble/{id_meuble}
		@GetMapping("/ordersmeuble/{id_meuble}")
		@ResponseBody
		public List<Commande> getordersbyMeubles(@PathVariable("id_meuble") Meubles meuble) {
			List<Commande> list = ordersService.GetOrdersByMeuble(meuble);
			return list;
		}
	
}
