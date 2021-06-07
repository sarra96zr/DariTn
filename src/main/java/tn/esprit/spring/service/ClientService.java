package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class ClientService implements ClientServicelmpl {
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public List<User> retrieveAllClient() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void deleteClient(Long id) {
		userRepository.deleteById(id);		
	}

	@Override
	public User updateUser(User p) {
		return userRepository.save(p);
	}

	@Override
	public Optional<User> retrieveClient(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	

}
