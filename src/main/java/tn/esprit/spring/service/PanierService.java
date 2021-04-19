package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Panier;

public interface PanierService {
	List<Panier> retrieveAll();

	Panier retrieveBasket(String BasketId);

	void removeBasket(String BasketId);

	Panier updateBasket(Panier BasketId);

	Panier addBasket(Panier b);
	void ValidateBasket(int basketId, int clientId ,String tp );

}
