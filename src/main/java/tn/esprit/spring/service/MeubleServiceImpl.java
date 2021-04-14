package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.repository.MeubleRepo;


@Service
public class MeubleServiceImpl implements MeubleService {
	@Autowired
	private MeubleRepo MeubleDAO;
	//private static final Logger L= LogManager.getLogger(MeubleServiceImpl.class);
	@Override
	public List<Meubles> retrieveAllMeubles() {
		// TODO Auto-generated method stub
		List<Meubles> meubles= (List<Meubles>) MeubleDAO.findAll();
		return meubles;
	}

	@Override
	public Meubles addMeuble(Meubles m) {
		// TODO Auto-generated method stub
		return MeubleDAO.save(m);
	}

	@Override
	public void deleteMeubles(String id_m) {
		// TODO Auto-generated method stub
		MeubleDAO.deleteById(Long.parseLong(id_m));

	}

	@Override
	public Meubles updateMeuble(Meubles m) {
		// TODO Auto-generated method stub


		return MeubleDAO.save(m);
	
	}

	@Override
	public Meubles retrieveMeubles(String id_m) {
		// TODO Auto-generated method stub
		return MeubleDAO.findById(Long.parseLong(id_m)).orElse(null);
	}

}
