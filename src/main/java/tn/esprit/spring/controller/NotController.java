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

import tn.esprit.spring.entity.Notifications;
import tn.esprit.spring.service.NotService;


@RestController
public class NotController {
	@Autowired
	NotService NotService;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-notifications
		@GetMapping("/retrieve-all-notifications")
		@ResponseBody
		public List<Notifications> getNots() {
			List<Notifications> list = NotService.retrieveAllNots();
			return list;
		}
		// http://localhost:8081/DariTn/Pi/retrieve-notification/{not-id}
				@GetMapping("/retrieve-notification/{not-id}")
				@ResponseBody
				public Notifications retrieveNot(@PathVariable("not-id") String id_n) {
					return NotService.retrieveNot(id_n);
				}

				// http://localhost:8081/DariTn/Pi/add-notification
				@PostMapping("/add-notification")
				@ResponseBody
				public Notifications addProduct(@RequestBody Notifications n) {
					 Notifications not = NotService.addNot(n);
					return not;
				}

				// http://localhost:8081/DariTn/Pi/Delete-not/{not-id}
				@DeleteMapping("/Delete-not/{not-id}")
				@ResponseBody
				public void removeProduct(@PathVariable("not-id") String id_n) {
					NotService.deleteNot(id_n);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-notification
				@PutMapping("/modify-not")
				@ResponseBody
				public Notifications modifyProduct(@RequestBody Notifications n) {
					return NotService.updateNot(n);
				}
				
}
