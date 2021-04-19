package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.service.CommandeService;
import tn.esprit.spring.service.PanierService;

@Controller
public class PanierController {
	@Autowired
	CommandeService ordersService;
	@Autowired
	PanierService basketService;

	public PanierController(CommandeService ordersService) {
		super();
		this.ordersService = ordersService;
	}

	// http://localhost:8081/add-basket
	@PostMapping("/add-basket")
	@ResponseBody
	public Panier addorders(@RequestBody Panier b) {

		Panier order = basketService.addBasket(b);
		return order;
	}

	

}
