package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.RDVFeedBack;

public interface RDVFeedBackService {
	List<RDVFeedBack> retrieveAllRDVFeedBack();
	RDVFeedBack addRDVFeedBack(RDVFeedBack  rf);
	void deleteRDVFeedBack(String id_rdv_feedback);
	RDVFeedBack updateRDVFeedBack(RDVFeedBack  rf);
	RDVFeedBack retrieveRDVFeedBack(String id_rdv_feedback);
	//public void affecteFeedToRdv( Long id_feedback,Long id_rdv );

}
