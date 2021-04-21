package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.RDVFeedBack;
import tn.esprit.spring.repository.RDVFeedBackRepository;


@Service
public class RDVFeedBackServiceImpl implements RDVFeedBackService {

	@Autowired
	private RDVFeedBackRepository RDVFeedBackDAO;
	//private static final Logger L= LogManager.getLogger(RDVFeedBackServiceImpl.class);	
	@Override
	public List<RDVFeedBack> retrieveAllRDVFeedBack() {
		// TODO Auto-generated method stub
		List<RDVFeedBack> RDVFeedBack= (List<RDVFeedBack>) RDVFeedBackDAO.findAll();
		return RDVFeedBack;
	}

	@Override
	public RDVFeedBack addRDVFeedBack(RDVFeedBack rf) {
		// TODO Auto-generated method stub
		return RDVFeedBackDAO.save(rf);
	}

	@Override
	public void deleteRDVFeedBack(String id_rdv_feedback) {
		// TODO Auto-generated method stub
		RDVFeedBackDAO.deleteById(Long.parseLong(id_rdv_feedback));
		
	}

	@Override
	public RDVFeedBack updateRDVFeedBack(RDVFeedBack rf) {
		// TODO Auto-generated method stub
		return RDVFeedBackDAO.save(rf);
	}

	@Override
	public RDVFeedBack retrieveRDVFeedBack(String id_rdv_feedback) {
		// TODO Auto-generated method stub
		return RDVFeedBackDAO.findById(Long.parseLong(id_rdv_feedback)).orElse(null);
	}

}
