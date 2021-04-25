package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.entity.Type_Rec;
import tn.esprit.spring.repository.RecRepo;


@Service
public class RecServiceImpl implements RecService {
	@Autowired
	private RecRepo RecDAO;
	//private static final Logger L= LogManager.getLogger(RecServiceImpl.class);
	@Override
	public List<Reclamations> retrieveAllRecs() {
		// TODO Auto-generated method stub
		List<Reclamations> recs= (List<Reclamations>) RecDAO.findAll();
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

}
