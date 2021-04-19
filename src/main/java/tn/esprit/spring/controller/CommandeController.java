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
import tn.esprit.spring.repository.CommandeRepo;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.service.CommandeService;
import tn.esprit.spring.service.PanierService;
@RestController
public class CommandeController {
	@Autowired
	CommandeService ordersService;
	@Autowired
	 PanierService basketService;
	private User user;
	@Autowired
	private CommandeRepo orderrepository;
	// afficher les orders with product
	// http://localhost:8081/DariTn/Pi/ordersmeubles/{ref_meuble}
			@GetMapping("/ordersmeubles/{ref_meuble}")
			@ResponseBody
			public List<Commande> getordersbyproducts(@PathVariable("ref_meuble") Meubles meuble) {
				List<Commande> list = ordersService.GetOrdersByMeubles(meuble);
				return list;
			}
			// ADD Order : 
			//http://localhost:8081/DariTn/Pi/add-orders
		 @PostMapping("/add-orders")
		 @ResponseBody
		 public Commande addorders(@RequestBody Commande o) {
			 Commande order = ordersService.addorders(o);
		 return order;
		 }

		// http://localhost:8081/DariTn/Pi/remove-orders/{orders-id}
		  @DeleteMapping("/remove-orders/{orders-id}")
		  @ResponseBody
		  public void removeorders(@PathVariable("orders-id") String ordersId) {
			   ordersService.removeorders(ordersId);
		  }
		 
		  // http://localhost:8081/DariTn/Pi/modify-orders
		  @PutMapping("/modify-orders")
		  @ResponseBody
		  public Commande modifyOrder(@RequestBody Commande ordersId) {
		  return ordersService.updateorders(ordersId);
		  }


		// http://localhost:8081/retrieve-all-orders
		@GetMapping("/retrieve-all-orders")
		@ResponseBody
		public List<Commande> getOrders() {
		List<Commande> list = ordersService.retrieveAll();
		return list;
		}

		// http://localhost:8081/retrieve-orders/{orders-id}
		 @GetMapping("/retrieve-orders/{orders-id}")
		 @ResponseBody
		 public Commande retrieveOrder(@PathVariable("orders-id") String ordersId) {
		 return ordersService.retrieveorders(ordersId);
		 }
		 
		 // Affecter order to basket  :
		 	// http://localhost:8081/affectOrderToBasket/{id_basket}/{id_order}
		@PutMapping("/affectOrderToBasket/{id_basket}/{id_order}")
		@ResponseBody
		public void affectOrderToBasket(@PathVariable("id_basket") int basketId, @PathVariable("id_order") int orderId) {
			ordersService.affecterOrdertoBasket(orderId, basketId);
		}
			
}
