package tn.esprit.spring.service;
import java.util.List;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Meubles;;
public interface CommandeService {
	List<Commande> GetOrdersByMeuble( Meubles m);
	Commande addOrder(Commande cmd);
}
