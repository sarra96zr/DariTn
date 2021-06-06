package tn.esprit.spring.service;


import java.util.List;


import tn.esprit.spring.entity.Credit;

public interface CreditService {

	public void ajouterCredit(int client, int id, Credit C);
	public Credit afficherCredit(int id);
	public void supprimerCredit(int id);
	public void modifiercredit(int id, int credit);
	public List<Credit> getallcreditsofclient(int id_client);
	public List<Credit> retrieveAllCredit();
	public void emailagentbancaire(int credit , String email, String subject, String message);
	
}
