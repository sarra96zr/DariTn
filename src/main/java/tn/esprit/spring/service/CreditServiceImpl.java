package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.CreditFormula;
import tn.esprit.spring.entity.Expert_financier;
import tn.esprit.spring.repository.BanqueRepo;
import tn.esprit.spring.repository.CreditFormulaRepo;
import tn.esprit.spring.repository.CreditRepo;
import tn.esprit.spring.repository.UserRepo;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;



@Service
public class CreditServiceImpl implements CreditService {
	
	@Autowired
	BanqueRepo brep;
	
	@Autowired
	CreditRepo crep;
	
	@Autowired
	CreditFormulaRepo frep;
	
	@Autowired
	UserRepo urep;
	
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public void ajouterCredit(int client, int id, Credit C) {
		CreditFormula F=frep.findById(id).get();
		Client cl=(Client) urep.findById((long) client).get();
		int duree=F.getDuration();
		double interet=F.getInterestRate();
		float somme=C.getInitialamount();	
		float sommefinal=(float) (somme+(somme*interet));	
		float monthly=sommefinal/(duree);
		C.setFinalamount(sommefinal);
		C.setMonthly(monthly);	
		C.setCreditformula(F);
		cl.addcredit(C);
		crep.save(C);	
	}

	@Override
	public Credit afficherCredit(int id) {
		// TODO Auto-generated method stub
		return crep.findById(id).orElse(null);
	}

	@Override
	public void supprimerCredit(int id) {
		// TODO Auto-generated method stub
		crep.deleteById(id);
		
	}

	@Override
	public void ajouterCreditFormula(CreditFormula C, int id) {
		Banque B=brep.findById(id).get();
		C.setBank(B);
		B.addFormula(C);
		frep.save(C);
	}


	@Override
	public CreditFormula affichercreditformula(int id) {
		// TODO Auto-generated method stub
		return frep.findById(id).orElse(null);
	}

	@Override
	public List<Credit> getallcreditsofclient(int id_client) {
		// TODO Auto-generated method stub
		List<Credit> liste=(List<Credit>) crep.findAll();
		
		List<Credit> finale=new ArrayList<Credit>();
		
		for(int i=0;i<liste.size();i++)
		{
			if(liste.get(i).getClient().getId_user()==id_client)
				finale.add(liste.get(i));
		}
		
		
		return finale;
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

	@Override
	public void modifiercredit(int credit, int id) {
		Credit C=crep.findById(credit).get();
		CreditFormula F=frep.findById(id).get();
		int duree=F.getDuration();
		double interet=F.getInterestRate();
		float somme=C.getInitialamount();	
		float sommefinal=(float) (somme+(somme*interet));	
		float monthly=sommefinal/(duree*12);
		C.setFinalamount(sommefinal);
		C.setMonthly(monthly);	
		C.setCreditformula(F);
		crep.save(C);
}

	@Override
	public void emailagentbancaire(int credit, String sender, String subject, String body) {
		// TODO Auto-generated method stub
		Credit C=crep.findById(credit).get();
		Banque bank=C.getCreditformula().getBank();
		Expert_financier E=urep.findbankagentbybankid(bank).get();
		String email=E.getEmail();
		SimpleMailMessage message = new SimpleMailMessage();		 
		message.setFrom(sender);
		message.setTo(email);
		message.setSubject(subject);
		message.setText(body);		 
		mailSender.send(message);
		
	}
	

	
	
}