package tn.esprit.spring.service;


import java.util.List;


import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.CreditFormula;

public interface CreditService {

	public void ajouterCredit(int client, int id, Credit C);
	public Credit afficherCredit(int id);
	public void supprimerCredit(int id);
	public void modifiercredit(int id, int credit);
	public void ajouterCreditFormula(CreditFormula C, int id);
	public CreditFormula affichercreditformula(int id);
	public List<Credit> getallcreditsofclient(int id_client);
	public List<Credit> retrieveAllCredit();
	public List<CreditFormula> retrieveAllFormule();
	public void emailagentbancaire(int credit , String email, String subject, String message);
	
}
