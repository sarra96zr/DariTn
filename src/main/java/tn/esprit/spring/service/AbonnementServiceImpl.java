package tn.esprit.spring.service;

import java.util.Date;
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
	public long addAbonnement(Abonnement abonnement) {

		abonnementDAO.save(abonnement);
		return abonnement.getId();
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
		return abonnementDAO.findById(Long.parseLong(id_ab)).orElse(null);
	}

	@Override
	public List<Abonnement> SearchAbonnementByType(String type_abonnement) {
		// TODO Auto-generated method stub
		return abonnementDAO.SearchAbonnementByType(type_abonnement);
	}

	@Override
	public List<Abonnement> Range(java.util.Date db, java.util.Date df) {
		// TODO Auto-generated method stub
		return abonnementDAO.Range(db, df);
	}
	@Override
	public List<Abonnement> orderByAscendingId() {
		// TODO Auto-generated method stub
		return abonnementDAO.orderByAscendingId();
	}

	@Override
	public List<Abonnement> orderByDescendingId() {
		// TODO Auto-generated method stub
		return abonnementDAO.orderByDescendingId();
	}





}
