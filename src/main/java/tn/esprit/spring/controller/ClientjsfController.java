package tn.esprit.spring.controller;

import java.util.Date;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.JwtProvider;
import tn.esprit.spring.security.JwtResponse;
import tn.esprit.spring.security.LoginForm;
import tn.esprit.spring.security.ResponseMessage;
import tn.esprit.spring.service.ClientServicelmpl;

@Controller(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/login.jsf")

public class ClientjsfController {
	
	@Autowired
	ClientServicelmpl clientService;
	
	  @Autowired
	  UserRepository userRepository;
	  @Autowired
		PasswordEncoder encoder;
	
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	AuthenticationManager authenticationManager;
	
	private long id_user ;
	
	private String firstName;

	private String lastName ;

	private String email;

	private String password;
	
	private String roles;


	 public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	private Date date_de_naissance;

		public long getId_user() {
		return id_user;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate_de_naissance() {
		return date_de_naissance;
	}
	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}
	
	public String authenticateUser() {
		LoginForm loginRequest = new LoginForm();
		loginRequest.setEmail(email);
		loginRequest.setPassword(password);
		try{
			
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println(userDetails.getPassword());
		String jwt = jwtProvider.generateJwtToken(authentication);
		System.out.println(jwt);
		return "/profil.xhtml?faces-redirect=true";
		}
		catch (Exception e) {
			
		}
		return null;
		//return ResponseEntity.ok(new JwtResponse(jwt,loginRequest.getEmail(), userDetails.getAuthorities()));
		
	}
	

	public ResponseEntity<?> registerUser() {

		User signUpRequest = new User(firstName, lastName, email, password, roles, date_de_naissance, null, null);
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

}
