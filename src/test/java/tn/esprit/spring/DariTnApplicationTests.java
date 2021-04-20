package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Type_Annonce;
import tn.esprit.spring.service.AnnonceServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DariTnApplicationTests {
	@Autowired
	AnnonceServiceImpl an;
	

	@Test
	public void contextLoads() {
		
				//an.addAnnonce(a);
				//an.updateAnnonce(a);
				//an.deleteAnnonce("2");
				//an.retrieveAllAnnonces();
			//AnnonceLocation.calculprix("20/04/2021", "24/04/2021", 22.2f);
				//AnnonceLocation.calculPrix(223.4, 20-04-2021, 24-04-2021);
	}

}
