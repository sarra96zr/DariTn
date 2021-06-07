package tn.esprit.spring.service;

import java.util.Optional;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.User;

public interface ClientServicelmpl {
	public Client addClient(Client c);
	java.util.List<User> retrieveAllClient();
	void deleteClient(Long id);
	User updateUser(User p);
	Optional<User> retrieveClient(Long id);
	

}
