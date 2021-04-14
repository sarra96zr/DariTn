package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Notifications;
import tn.esprit.spring.repository.NotRepo;


@Service
public class NotServiceImpl implements NotService {
	@Autowired
	private NotRepo NotDAO;
	//private static final Logger L= LogManager.getLogger(NotServiceImpl.class);
	@Override
	public List<Notifications> retrieveAllNots() {
		// TODO Auto-generated method stub
		List<Notifications> Nots= (List<Notifications>) NotDAO.findAll();
		return Nots;
	}

	@Override
	public Notifications addNot(Notifications n) {
		// TODO Auto-generated method stub
		return NotDAO.save(n);
	}

	@Override
	public void deleteNot(String id_n) {
		// TODO Auto-generated method stub
		NotDAO.deleteById(Long.parseLong(id_n));

	}

	@Override
	public Notifications updateNot(Notifications n) {
		// TODO Auto-generated method stub


		return NotDAO.save(n);
	
	}

	@Override
	public Notifications retrieveNot(String id_n) {
		// TODO Auto-generated method stub
		return NotDAO.findById(Long.parseLong(id_n)).orElse(null);
	}

}
