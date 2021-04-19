package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Paiement;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.repository.ClientRepo;
import tn.esprit.spring.repository.CommandeRepo;
import tn.esprit.spring.repository.PanierRepo;
@Service
public class PanierServiceImpl implements PanierService {
	@Autowired
	PanierRepo basketRepository;
	@Autowired
	CommandeRepo orderRepository;
	@Autowired
	ClientRepo clientRepository;
	@Override
	public List<Panier> retrieveAll() {
		// TODO Auto-generated method stub
		return (List<Panier>)basketRepository.findAll();
	}

	@Override
	public Panier retrieveBasket(String BasketId) {
		// TODO Auto-generated method stub
		return basketRepository.findById(Long.parseLong(BasketId)).orElse(null);
	}

	@Override
	public void removeBasket(String BasketId) {
		basketRepository.deleteById(Long.parseLong(BasketId));

	}

	@Override
	public Panier updateBasket(Panier BasketId) {
		// TODO Auto-generated method stub
		return basketRepository.save(BasketId);
	}

	@Override
	public Panier addBasket(Panier b) {
		// TODO Auto-generated method stub
		b.setDate_basket(new Date());
		return basketRepository.save(b);
	}

	@Override
	public void ValidateBasket(int basketId, int clientId, String tp) {
		// TODO Auto-generated method stub
		Panier b = basketRepository.findById((long) basketId).orElse(null);
		Client c = clientRepository.findById((long) clientId).orElse(null);
		
		b.setClient(c);
		List  ods=new ArrayList<>(b.getCommande());
		for(int i=0;i<ods.size();i++){
			Commande o=(Commande) ods.get(i);
			o.setStatut("in Delivering");
			
		}
		 if(tp.toUpperCase().equals(Paiement.Livraison) ){
			  b.setType_paiement(Paiement.Livraison);
		   }
		 else {
			  b.setType_paiement(Paiement.CarteBancaire);

		 }
		
		basketRepository.save(b);
		
	


	}

}
