package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Notifications;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.JwtProvider;
import tn.esprit.spring.security.JwtResponse;
import tn.esprit.spring.security.LoginForm;
import tn.esprit.spring.security.ResponseMessage;
import tn.esprit.spring.service.ClientServicelmpl;


@RestController
@RequestMapping("/api")

public class ClientController  {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	ClientServicelmpl clientService;
	  @Autowired
	  UserRepository userRepository;
	@Autowired
	JwtProvider jwtProvider;
	


	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody User signUpRequest) {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

	

		// Creating user's account
		
		
		User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getRoles(), signUpRequest.getDate_de_naissance(), signUpRequest.getAnnonces(), signUpRequest.getNotifications());
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);

	}
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser( @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println(userDetails.getPassword());
		String jwt = jwtProvider.generateJwtToken(authentication);
		System.out.println(jwt);
		return ResponseEntity.ok(new JwtResponse(jwt,loginRequest.getEmail(), userDetails.getAuthorities()));

	}
	
	@PutMapping("/Client-update")
	public String updateUser(@RequestBody User c) {
		List<User>clients=clientService.retrieveAllClient();
		for(User i:clients)
			if(i.getId_user()==c.getId_user()){
		    clientService.updateUser(c);
		   return "modify successfully from id ="+c.getId_user(); 
		   
	         }
		return "client not found " ;
		}
	
	@DeleteMapping("/remove-user/{id}")
	@ResponseBody
	public void removeClient(@PathVariable("id") Long id) {
		clientService.deleteClient(id);
	}
	
	@GetMapping("/client/{id}")
	public Optional<User> afficher (@PathVariable("id") Long id){
		return  clientService.retrieveClient(id);
	}
	@GetMapping("/Client/all")
	public List<User> afficherAllClient (){
		return  clientService.retrieveAllClient();
	}

}
