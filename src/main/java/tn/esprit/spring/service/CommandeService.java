package tn.esprit.spring.service;
import java.util.List;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Meubles;;
public interface CommandeService {
	List<Commande> GetOrdersByMeubles( Meubles meuble) ;
	List<Commande> retrieveAll();

	Commande retrieveorders(String ordersId);

	void removeorders(String ordersId);

	Commande updateorders(Commande ordersId);

	Commande addorders(Commande o);

	void affecterOrdertoBasket(int orderId, int basketId);

	List<Commande> findAll();
}
