package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.RDV;

public interface RDVService {
	
	//public List<RDV> getRDV(Date dateDeb,Date dateFin );
	RDV addRDV(RDV  r);
	void deleteRDV(Long id_rdv);
	RDV updateRDV(RDV  r,Long id_rdv);
	RDV retrieveRDV(String id_rdv);
	List<RDV> retrieveAllRDV();	
	//public List<RDV> searchRDV(String title);
}
