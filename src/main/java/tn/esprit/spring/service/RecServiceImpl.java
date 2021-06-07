package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.entity.Type_Rec;
import tn.esprit.spring.repository.RecRepo;
import tn.esprit.spring.repository.UserRepo;


@Service
public class RecServiceImpl implements RecService {
	
	@Autowired
	private RecRepo RecDAO;
	
	@Autowired
	UserRepo urep;
	
	@Autowired
	private JavaMailSender javaMailSender;

	
	
	
	//private static final Logger L= LogManager.getLogger(RecServiceImpl.class);
	@Override
	public List<Reclamations> retrieveAllRecs() {
		// TODO Auto-generated method stub
		//List<Reclamations> recs= (List<Reclamations>) RecDAO.findAll();
		List<Reclamations> recs= new ArrayList<Reclamations>();
		RecDAO.findAll().forEach(e ->recs.add(e));
		return recs;
	}
	
	@Override
	public Reclamations addRec(Reclamations r) {
		// TODO Auto-generated method stub
		return RecDAO.save(r);
	}

	@Override
	public void deleteRec(String id_r) {
		// TODO Auto-generated method stub
		RecDAO.deleteById(Long.parseLong(id_r));

	}

	@Override
	public Reclamations updateRec(Reclamations r) {
		// TODO Auto-generated method stub


		return RecDAO.save(r);
	
	}

	@Override
	public Reclamations retrieveRec(String id_r) {
		// TODO Auto-generated method stub
		return RecDAO.findById(Long.parseLong(id_r)).orElse(null);
	}

	@Override
	public List<Reclamations> RechercheRec(Type_Rec type) {
			return RecDAO.findByType(type);
	}
	
	@Override
	public List<Reclamations> findByClientId(int client) {
		
		List<Reclamations> liste=(List<Reclamations>) RecDAO.findAll();
		
		List<Reclamations> finale=new ArrayList<Reclamations>();
		
		for(int i=0;i<liste.size();i++)
		{
			if(liste.get(i).getClient().getId_user()==client)
				finale.add(liste.get(i));
		}
		
		
		return finale;
	}

	@Override
	public void ajouterRec(int client, Reclamations r) {
		Client cl=(Client) urep.findById((long) client).get();
		String titre=r.getTitreReclam();	
		String description=r.getDescriptionReclam();
		//Type_Rec type=r.getType();
		r.setDescriptionReclam(description);
		r.setTitreReclam(titre);
		//r.setType(type);
		cl.addReclam(r);
		RecDAO.save(r);	
	}

	@Override
	public void modifierRec(int rec) {
		Reclamations r=RecDAO.findById((long) rec).get();
		String titre=r.getTitreReclam();	
		String description=r.getDescriptionReclam();
		Type_Rec type=r.getType();
		r.setDescriptionReclam(description);
		r.setTitreReclam(titre);
		r.setType(type);
		RecDAO.save(r);
	}

	
	
	
	
	@Override
	public List<Reclamations> findRecWithPID(long id) {
		//List<Reclamations> liste=(List<Reclamations>) RecDAO.findRecWithPID(id);
		return RecDAO.findRecWithPID(id);
		
	}
	
	//@Override
	//public List<Long> findRecWithPID1(long id) {
		//List<Reclamations> liste=(List<Reclamations>) RecDAO.findRecWithPID(id);
		//return RecDAO.findRecWithPID1(id);
		
	//}
	
	@Override
	public void addOrUpdateRec(int client,Reclamations rec) {
		Client cl=(Client) urep.findById((long) client).get();
		rec.getId_reclam();
		cl.addReclam(rec);
		RecDAO.save(rec);
	}

	@Override
	public void update(Reclamations r) {
		RecDAO.save(r);
	}
	
	
	public void sendTextEmail(Reclamations emailTemplate) {

		SimpleMailMessage msg = new SimpleMailMessage();
		try {
			if (emailTemplate.getClient().getEmail().contains(",")) {
				String[] emails = emailTemplate.getClient().getEmail().split(",");
				int receipantSize = emails.length;
				for (int i = 0; i < receipantSize; i++) {

					msg.setTo(emails[i]);
					msg.setSubject("Votre réclamation au sujet: "+emailTemplate.getTitreReclam());
					msg.setText("Cher client,"+(emailTemplate.getClient().getFirstName()+emailTemplate.getClient().getLastName()+"nous vous informons que votre réclamation est prise en considération."));
					javaMailSender.send(msg);
				}

			} else {
				msg.setTo(emailTemplate.getClient().getEmail());
				msg.setSubject("Votre réclamation"+emailTemplate.getTitreReclam());
				msg.setText("Cher client, "+(emailTemplate.getClient().getFirstName()+" "+emailTemplate.getClient().getLastName()+" nous vous informons que votre réclamation est prise en considération."));
				javaMailSender.send(msg);
				javaMailSender.send(msg);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
