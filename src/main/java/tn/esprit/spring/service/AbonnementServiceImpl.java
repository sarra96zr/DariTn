package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.repository.AbonnementRepo;

@Service
public class AbonnementServiceImpl implements AbonnementService {
	
	@Autowired
	private AbonnementRepo abonnementDAO;
	//private static final Logger L= LogManager.getLogger(MeubleServiceImpl.class);

	@Override
	public List<Abonnement> retrieveAllAbonnement() {
		// TODO Auto-generated method stub
				List<Abonnement> abonnement= (List<Abonnement>) abonnementDAO.findAll();
				return abonnement;
	}

	@Override
	public Abonnement addAbonnement(Abonnement ab) {
		// TODO Auto-generated method stub
		return abonnementDAO.save(ab);
	}

	@Override
	public void deleteAbonnement(String id_ab) {
		// TODO Auto-generated method stub
		abonnementDAO.deleteById(Long.parseLong(id_ab));
		
	}

	@Override
	public Abonnement updateAbonnement(Abonnement ab) {
		// TODO Auto-generated method stub
		return abonnementDAO.save(ab);
	}

	@Override
	public Abonnement retrieveAbonnement(String id_ab) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Abonnement> SearchAbonnementByType(String type_abonnement) {
		// TODO Auto-generated method stub
		return abonnementDAO.SearchAbonnementByType(type_abonnement);
	}



}
