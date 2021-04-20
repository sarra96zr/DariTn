package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.CreditFormula;
import tn.esprit.spring.repository.BanqueRepo;
import tn.esprit.spring.repository.ClientRepo;
import tn.esprit.spring.repository.CreditFormulaRepo;
import tn.esprit.spring.repository.CreditRepo;
import tn.esprit.spring.repository.UserRepo;

@Service
public class CreditServiceImpl implements CreditService {
	
	@Autowired
	CreditFormulaRepo frep;
	
	@Autowired
	BanqueRepo brep;
	
	@Autowired
	CreditRepo crep;
	
	@Autowired
	UserRepo urep;
	
	@Autowired
	ClientRepo clrep;

	@Override
	public void ajouterCredit(int client, int id, Credit C) {
		CreditFormula F=frep.findById(id).get();
		Client cl=(Client) urep.findById((long) client).get();
		int duree=F.getDuration();
		double interet=F.getInterestRate();
		float somme=C.getInitialamount();	
		float sommefinal=(float) (somme+(somme*interet));	
		float monthly=sommefinal/(duree*12);
		C.setFinalamount(sommefinal);
		C.setMonthly(monthly);	
		C.setCreditformula(F);
		cl.addcredit(C);
		crep.save(C);	
	}

	@Override
	public Credit afficherCredit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerCredit(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterCreditFormula(CreditFormula C, int id) {
		Banque B=brep.findById(id).get();
		C.setBank(B);
		B.addFormula(C);
		frep.save(C);
	}

	@Override
	public List<CreditFormula> listeformulescredit(int banque) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditFormula affichercreditformula(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credit> getallcreditsofclient(int idclient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credit> retrieveAllCredit() {
		// TODO Auto-generated method stub
		List<Credit> credit= (List<Credit>) crep.findAll();
		return credit;
	}

	@Override
	public List<CreditFormula> retrieveAllFormule() {
		// TODO Auto-generated method stub
		List<CreditFormula> creditformule= (List<CreditFormula>) frep.findAll();
		return creditformule;
	}
	

}
