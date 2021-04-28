package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Meubles;





public interface MeubleService {
	List<Meubles> retrieveAllMeubles();
	Meubles addMeuble(Meubles  m);
	void deleteMeubles(String id_m);
	Meubles updateMeuble(Meubles  m);
	Meubles retrieveMeubles(String id_m);
	List<Meubles> SearchMeublesByName(String name_meuble);
	List<Meubles> Range(float min, float max);
	List<Meubles> findAll();

}
