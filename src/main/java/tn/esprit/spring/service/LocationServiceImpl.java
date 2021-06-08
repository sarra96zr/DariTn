package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.LocationRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	LocationRepository locarepo;

	@Override
	public Double calculPrix(Double prix, Date datedeb, Date datefin) {
		
		 Double prix1;
	        final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24; 

	        return prix1= ((prix/31)*(datefin.getTime()-datedeb.getTime()))/ (MILLISECONDS_PER_DAY);
	         //annoncerepo.save(entity)
	           
	}

	@Override
	public Location addLocation( Date datedeb, Date datefin) {
		//User u = new tn.esprit.spring.entity.User(1, "zeineb","yah", "zeineb", "pass", , annonces, notifications)
		Location l = new Location(datedeb, datefin, calculPrix(308.6 ,datedeb, datefin),null,null);
		return locarepo.save(l);
	}

	@Override
	public List<Location> retrieveAllLocation() {
		List<Location> annonces = (List<Location>) locarepo.findAll();
		return annonces;
	}

	@Override
	public Long addOrUpdateLocation(Location l) {
		
		locarepo.save(l);
		return l.getId();
	}

	@Override
	public void deleteLocation(String id) {
		locarepo.deleteById(Long.parseLong(id));
		
	}
	@Override
	public void sendTextEmail(Location emailTemplate) {

		SimpleMailMessage msg = new SimpleMailMessage();
		try {
			if (emailTemplate.getUser().getEmail().contains(",")) {
				String[] emails = emailTemplate.getUser().getEmail().split(",");
				int receipantSize = emails.length;
				for (int i = 0; i < receipantSize; i++) {

					msg.setTo(emails[i]);
					msg.setSubject("Votre demande de location de l'annonce : "+emailTemplate.getAnnonce().titre);
					msg.setText("Cher client,"+(emailTemplate.getUser().getFirstName()+emailTemplate.getUser().getLastName()+"nous vous informons que votre demande de location est prise en considération avec un prix de ")+emailTemplate.getPrixLocation());
					javaMailSender.send(msg);
				}

			} else {
				msg.setTo(emailTemplate.getUser().getEmail());
				msg.setSubject("Votre réclamation"+emailTemplate.getPrixLocation());
				msg.setText("Cher client, "+(emailTemplate.getUser().getFirstName()+" "+emailTemplate.getUser().getLastName()+" nous vous informons que votre réclamation est prise en considération."));
				javaMailSender.send(msg);
				javaMailSender.send(msg);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
