package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.repository.CommandeRepo;
@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	CommandeRepo ordersRepository;
	@Override
	public List<Commande> GetOrdersByMeuble(Meubles m) {
		// TODO Auto-generated method stub
		return ordersRepository.GetOrdersByMeuble(m);
	}

	@Override
	public Commande addOrder(Commande cmd) {
		// TODO Auto-generated method stub
		return ordersRepository.save(cmd);
	}

}
