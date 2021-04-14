package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Banque;






public interface BanqueService {

		List<Banque> retrieveAllBanque();
		Banque addBanque(Banque b);
		void deleteBanque(String id_b);
		Banque updateBanque(Banque b);
		Banque retrieveBanque(String id_b);

}
