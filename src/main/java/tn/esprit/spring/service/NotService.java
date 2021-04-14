package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Notifications;





public interface NotService {
	List<Notifications> retrieveAllNots();
	void deleteNot(String id_n);
	Notifications updateNot(Notifications  n);
	Notifications retrieveNot(String id_n);
	Notifications addNot(Notifications n);

}
