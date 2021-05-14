package tn.esprit.spring.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.SurveillanceRepo;

@Service
public class SurveillanceServiceImpl implements SurveillanceService {
	@Autowired
	SurveillanceRepo surveillanceRepository;
	
	Surveillance sur;

	@Override
	public List<Surveillance> retrieveAllSurveillance() {
		// TODO Auto-generated method stub
				List<Surveillance> surveillance= (List<Surveillance>) surveillanceRepository.findAll();
				return surveillance;
	}

	@Override
	public long addSurveillance(Surveillance surveillance) {

		surveillanceRepository.save(surveillance);
		return surveillance.getId();
	}

	@Override
	public void deleteSurveillance(int id_ab) {
		// TODO Auto-generated method stub
		surveillanceRepository.deleteById((long) id_ab);
		
		
	}

	@Override
	public Surveillance updateSurveillance(Surveillance ab) {
		// TODO Auto-generated method stub
		return surveillanceRepository.save(ab);
	}

	@Override
	public Surveillance retrieveSurveillance(String id_ab) {
		// TODO Auto-generated method stub
		return null;
	}

}