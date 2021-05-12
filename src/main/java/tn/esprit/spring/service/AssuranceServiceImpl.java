package tn.esprit.spring.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Assurance;
import tn.esprit.spring.repository.AssuranceRepo;

@Service
public class AssuranceServiceImpl implements AssuranceService {
	@Autowired
	AssuranceRepo assuranceRepository;

	@Override
	public Long addOrUpdateAssurance(Assurance assurance) {
		assuranceRepository.save(assurance);
		return assurance.getId();
	}

	@Override
	public List<Assurance> retrieveAllAssurance() {
		List<Assurance> assurance= (List<Assurance>) assuranceRepository.findAll();
		return assurance;
	}

	@Override
	public void deleteAssurance(int id) {
		// TODO Auto-generated method stub
		assuranceRepository.deleteById((long) id);
		
	}

	@Override
	public Assurance updateAssurance(Assurance assurance) {
		// TODO Auto-generated method stub
		return assuranceRepository.save(assurance);
	}
	
}