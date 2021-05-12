package tn.esprit.spring.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.SurveillanceRepo;

@Service
public class SurveillanceServiceImpl implements SurveillanceService {
	@Autowired
	SurveillanceRepo surveillanceRepository;
	
	Surveillance sur;
/*
	@Override
	public Long addOrUpdateSurveillance(Surveillance surveillance) {
		
		//surveillance.setPrix(null);
		surveillanceRepository.save(surveillance);
	return surveillance.getId();
	}
	@Override
	public List<Surveillance> affichersurveilconnecté(Long id) {
	return surveillanceRepository.getSubById(id);}
	
	@Override
	public List<Surveillance> affichersurveil(User user) {
	return (List<Surveillance>) surveillanceRepository.getSubByUser(user);}
	
	
	@Override
	public void deleteSurv(String id) {
		surveillanceRepository.deleteById(Long.parseLong(id));
		
	} */
}