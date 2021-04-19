package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.repository.ClientRepo;
import tn.esprit.spring.repository.CommandeRepo;
import tn.esprit.spring.repository.MeubleRepo;
import tn.esprit.spring.repository.PanierRepo;
@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	CommandeRepo ordersRepository;
	@Autowired
	MeubleRepo meubleRepository;
	@Autowired
	PanierRepo basketrepository;
	
	@Autowired
	ClientRepo clientrepository;
	@Override
	public List<Commande> GetOrdersByMeubles(Meubles meuble) {
		// TODO Auto-generated method stub
		return ordersRepository.GetOrdersByMeubles(meuble);
	}

	@Override
	public List<Commande> retrieveAll() {
		// TODO Auto-generated method stub
		return (List<Commande>)ordersRepository.findAll();
	}

	@Override
	public Commande retrieveorders(String ordersId) {
		// TODO Auto-generated method stub
		return ordersRepository.findById(Long.parseLong(ordersId)).orElse(null);
	}

	@Override
	public void removeorders(String ordersId) {
		// TODO Auto-generated method stub
		ordersRepository.deleteById(Long.parseLong(ordersId));
	}

	@Override
	public Commande updateorders(Commande ordersId) {
		// TODO Auto-generated method stub
		return ordersRepository.save(ordersId);
	}

	@Override
	public Commande addorders(Commande o) {
		// TODO Auto-generated method stub
		return ordersRepository.save(o);
	}

	@Override
	public void affecterOrdertoBasket(int orderId, int basketId) {
		// TODO Auto-generated method stub
		Panier b = basketrepository.findById((long) basketId).orElse(null);
		Commande o = ordersRepository.findById((long) orderId).orElse(null);
		b.getCommande().add(o);
		
		//grant total va etre incrementé dans le basket
		b.setPrix_total(b.getPrix_total());
		basketrepository.save(b);
		o.setPanier(b);
		ordersRepository.save(o);
		
		
	}

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		List<Commande> orders = (List<Commande>) ordersRepository.findAll();
		return orders;
	}


}
