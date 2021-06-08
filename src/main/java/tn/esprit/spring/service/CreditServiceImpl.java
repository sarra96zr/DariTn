package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.Expert_financier;
import tn.esprit.spring.repository.BanqueRepo;
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
	UserRepo urep;
	
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public void ajouterCredit(int client, int id, Credit C) {
		Banque B=brep.findById(id).get();
		Client cl=(Client) urep.findById((long) client).get();
		int duree=B.getDuration();
		double interet=B.getInterestRate();
		float somme=C.getInitialamount();	
		float sommefinal=(float) (somme*interet);	
		float monthly=sommefinal/(duree);
		C.setFinalamount(sommefinal);
		C.setMonthly(monthly);	
		C.setBanque(B);
		cl.addcredit(C);
		crep.save(C);	
	}
	
	@Override
	public void capaciteClient(int client, Credit C) {
		Client cl=(Client) urep.findById((long) client).get();
		float somme=C.getSalaire();
		float sommefinal=(float) (somme*0.4);	
		C.setPartmensuel(sommefinal);
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
	public void modifiercredit(int credit, int id) {
		Credit C=crep.findById(credit).get();
		Banque B=brep.findById(id).get();
		int duree=B.getDuration();
		double interet=B.getInterestRate();
		float somme=C.getInitialamount();	
		float sommefinal=(float) (somme+(somme*interet));	
		float monthly=sommefinal/(duree*12);
		C.setFinalamount(sommefinal);
		C.setMonthly(monthly);	
		C.setBanque(B);
		crep.save(C);
}



	public void sendTextEmail(Credit emailTemplate) {

		SimpleMailMessage msg = new SimpleMailMessage();
		try {
			if (emailTemplate.getPartmensuel()>emailTemplate.getMonthly()) {

				String[] emails = emailTemplate.getClient().getEmail().split(",");
				int receipantSize = emails.length;
				for (int i = 0; i < receipantSize; i++) {

					msg.setTo(emails[i]);
					msg.setSubject("Votre demande de crédit a été accepté  ");
					msg.setText("Cher client,"+(emailTemplate.getClient().getFirstName()+emailTemplate.getClient().getLastName()+"nous vous informons que votre demande de crédit"+emailTemplate.getFinalamount()+"a été accepté"));
					mailSender.send(msg);
				}

			} else {
				msg.setTo(emailTemplate.getClient().getEmail());
				msg.setSubject("Demande de credit");
				msg.setText("Cher client, "+(emailTemplate.getClient().getFirstName()+" "+emailTemplate.getClient().getLastName()+"nous vous informons que votre demande de crédit"+emailTemplate.getFinalamount()+"n'a pas été accepté"));
				mailSender.send(msg);
				mailSender.send(msg);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}}}
		

	
	

	
	
