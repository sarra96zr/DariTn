package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.repository.BanqueRepo;


@Service
public class BanqueServiceImpl implements BanqueService {
	@Autowired
	private BanqueRepo banqueDAO;
	//private static final Logger L= LogManager.getLogger(MeubleServiceImpl.class);

	@Override
	public List<Banque> retrieveAllBanque() {
		// TODO Auto-generated method stub
		List<Banque> banque= (List<Banque>) banqueDAO.findAll();
		return banque;
	}

	@Override
	public Banque addBanque(Banque b) {
		// TODO Auto-generated method stub
		return banqueDAO.save(b);
	}

	@Override
	public void deleteBanque(String id_b) {
		// TODO Auto-generated method stub
		banqueDAO.deleteById(Long.parseLong(id_b));
	}

	@Override
	public Banque updateBanque(Banque b) {
		// TODO Auto-generated method stub
		return banqueDAO.save(b);
	}

	@Override
	public Banque retrieveBanque(String id_b) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
		

	}


