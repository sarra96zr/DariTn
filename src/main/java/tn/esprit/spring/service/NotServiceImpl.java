package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Notifications;
import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.NotRepo;
import tn.esprit.spring.repository.RecRepo;
import tn.esprit.spring.repository.UserRepo;


@Service
public class NotServiceImpl implements NotService {
	@Autowired
	NotRepo NotDAO;
	@Autowired
	RecRepo RecDAO;
	@Autowired
	UserRepo UserDAO;
	
	//private static final Logger L= LogManager.getLogger(NotServiceImpl.class);
	@Override
	public List<Notifications> retrieveAllNots() {
		// TODO Auto-generated method stub
	//	List<Notifications> Nots= (List<Notifications>) NotDAO.findAll();
		List<Notifications> recs= new ArrayList<Notifications>();
		NotDAO.findAll().forEach(e ->recs.add(e));
		return recs;
	}

	@Override
	public String addNot(Notifications n,Long idA) throws Exception  {
		Reclamations r = RecDAO.findById(idA).get();
		long idd = 1 ; 
		//p.setParent(currentParent());
		User u = UserDAO.findById(idd).get() ;
		//long iduser = u.getId_user() ; 
		n.setUser(u);
		n.setReclamations(r);
		if (n.getUser().getId_user() == n.getReclamations().getClient().getId_user() )
		{
			 NotDAO.save(n);
			 return ("Ajouté");
		}
		else 
		{
			return ("Ajout non effectué");
		}
	}

	@Override
	public void deleteNot(String id_n) {
		// TODO Auto-generated method stub
		NotDAO.deleteById(Long.parseLong(id_n));

	}

	@Override
	public Notifications updateNot(Notifications n) {
		// TODO Auto-generated method stub


		return NotDAO.save(n);
	
	}

	@Override
	public Notifications retrieveNot(Long id_n) {
		// TODO Auto-generated method stub
		return NotDAO.findById(id_n).orElse(null);
	}

}
