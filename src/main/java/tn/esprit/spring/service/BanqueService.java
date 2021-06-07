
package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Banque;






public interface BanqueService {

		List<Banque> retrieveAllBanque();
		Banque addBanque(Banque b);
		void deleteBanque(int id);
		Banque updateBanque(Banque b);
		Banque retrieveBanque(String id_b);
        List<Banque> SearchBanqueByName(String name_banque);
            
}
