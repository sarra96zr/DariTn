package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.RDV;

public interface RDVService {
	List<RDV> retrieveAllRDV();
	RDV addRDV(RDV  r);
	void deleteRDV(String id_rdv);
	RDV updateRDV(RDV  r);
	RDV retrieveRDV(String id_rdv);
}
