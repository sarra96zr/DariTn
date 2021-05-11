package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.RDV;
import tn.esprit.spring.repository.RDVRepository;


@Service
public class RDVServiceImpl implements RDVService {

	@Autowired
	private RDVRepository RDVDAO;

	/*@Override
	public List<RDV> getRDV(Date dateDeb, Date dateFin) {
		return RDVDAO.findBetween(dateDeb,dateFin);
		
	}*/
	
	
	@Override
	public RDV addRDV(RDV r) {
		// TODO Auto-generated method stub
		return RDVDAO.save(r);
	}
	
	
	@Override
	public RDV updateRDV(RDV r,Long id_rdv) {
		// TODO Auto-generated method stub
		RDV rdv_updated =RDVDAO.findById(id_rdv).orElse(null); 
		rdv_updated.setClient(r.getClient());
		rdv_updated.setDateRDV(r.getDateRDV());
		//rdv_updated.setTitle(r.getTitle());
		return RDVDAO.save(rdv_updated);
	}

	
	@Override
	public void deleteRDV(Long id_rdv) {
		// TODO Auto-generated method stub
		RDVDAO.deleteById(id_rdv);
		}


	@Override
	public RDV retrieveRDV(String id_rdv) {
		// TODO Auto-generated method stub
		return RDVDAO.findById(Long.parseLong(id_rdv)).orElse(null);
	}
	

	@Override
	public List<RDV> retrieveAllRDV() {
		// TODO Auto-generated method stub
		
		List<RDV> RDV= (List<RDV>) RDVDAO.findAll();
		return RDV;
	}
/*
	@Override
	public List<RDV> searchRDV(String title) {
		// TODO Auto-generated method stub
		return (List<RDV>)RDVDAO.searchEvent(title);
	}*/
	
	@Override
	public void addOrUpdateRDV(RDV rdv) {
	RDVDAO.save(rdv);
	
	}
	


}
