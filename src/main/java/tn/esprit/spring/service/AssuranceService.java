package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.Assurance;

public interface AssuranceService {
	public Long addOrUpdateAssurance(Assurance assurance);
	List<Assurance> retrieveAllAssurance();
	public void deleteAssurance(int id);
	Assurance updateAssurance(Assurance assurance);

}
