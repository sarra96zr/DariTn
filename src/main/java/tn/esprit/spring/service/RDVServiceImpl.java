package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.RDV;
import tn.esprit.spring.repository.RDVRepository;


@Service
public class RDVServiceImpl implements RDVService {

	@Autowired
	private RDVRepository RDVDAO;
	//private static final Logger L= LogManager.getLogger(RDVServiceImpl.class);
	@Override
	public List<RDV> retrieveAllRDV() {
		// TODO Auto-generated method stub
		List<RDV> RDV= (List<RDV>) RDVDAO.findAll();
		return RDV;
	}

	@Override
	public RDV addRDV(RDV r) {
		// TODO Auto-generated method stub
		return RDVDAO.save(r);
	}

	@Override
	public void deleteRDV(String id_rdv) {
		// TODO Auto-generated method stub
		RDVDAO.deleteById(Long.parseLong(id_rdv));
		
	}

	@Override
	public RDV updateRDV(RDV r) {
		// TODO Auto-generated method stub
		return RDVDAO.save(r);
	}

	@Override
	public RDV retrieveRDV(String id_rdv) {
		// TODO Auto-generated method stub
		return RDVDAO.findById(Long.parseLong(id_rdv)).orElse(null);
	}

}
