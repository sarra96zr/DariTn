package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.repository.CommandeRepo;
import tn.esprit.spring.repository.UserRepo;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.helper.GeneratePdfReport;
import tn.esprit.spring.helper.MailService;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.service.CommandeService;
import tn.esprit.spring.service.PanierService;
@Controller
public class CommandeController {
	@Autowired
	CommandeService ordersService;
	@Autowired
	 PanierService basketService;

	@Autowired
	private CommandeRepo orderrepository;
	
	@Autowired
	private UserRepo ur;
	@Autowired
	private MailService notificationService;

	private User user=new User();
	// afficher les commandes par meubles
	// http://localhost:8081/DariTn/Pi/ordersmeubles/{ref_meuble}
			@GetMapping("/ordersmeubless/{ref_meuble}")
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


		// http://localhost:8081/DariTn/Pi/retrieve-all-orders
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
		
		////////////////JSF
		@RequestMapping("/cmd")
		public String  getMeubles(Model model) {
			List<Commande> list = ordersService.retrieveAll();
		    model.addAttribute("order", list);
		     
		    return "cmd";
		}
		@RequestMapping("/payer")
		public String  payer(Model model) {
		  
		    return "payer";
		}
		//PDF
		// http://localhost:8083/orders/export/pdf
		@RequestMapping("/export/pdf")
		public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		   response.setContentType("application/pdf");
		   DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		   String currentDateTime = dateFormatter.format(new Date());
		    
		   String headerKey = "Content-Disposition";
		   String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		   response.setHeader(headerKey, headerValue);
		    
		   List<Commande> listorders = ordersService.findAll();
		    
		   GeneratePdfReport exporter = new GeneratePdfReport(listorders);
		   exporter.export(response);
		    
		}
		//mail
		@RequestMapping("send-mail-attachment")
		public  String sendWithAttachment() throws MessagingException {

			/*
			 * Creating a User with the help of User class that we have declared and setting
			 * Email address of the sender.
			 */
			user.setEmail("esprit.daritn@gmail.com"); //Receiver's email address

			/*
			 * Here we will call sendEmailWithAttachment() for Sending mail to the sender
			 * that contains a attachment.
			 */
			try {
				notificationService.sendEmailWithAttachment(user);
			} catch (MailException mailException) {
				System.out.println(mailException);
			}
			return "Congratulations! Your mail has been send to the user.";
					
		}
			//JSF
		public List<Commande> getordersbyRef( Meubles meuble) {
			List<Commande> list = ordersService.GetOrdersByMeubles(meuble);
			return list;
		}
}
