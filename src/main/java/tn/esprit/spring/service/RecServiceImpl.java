package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamations;
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

}
