package tn.esprit.spring.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}