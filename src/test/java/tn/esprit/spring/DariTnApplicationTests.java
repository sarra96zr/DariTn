package tn.esprit.spring;

import java.sql.Date;
import java.text.SimpleDateFormat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Categorie_Annonce;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.Type_Annonce;
import tn.esprit.spring.service.AnnonceServiceImpl;
import tn.esprit.spring.service.LocationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DariTnApplicationTests {
	@Autowired
	AnnonceServiceImpl an;
	
	@Autowired
	LocationService locationService;
	@Test
	public void contextLoads() {
		
				//an.addAnnonce(a);
				//an.updateAnnonce(a);
				//an.deleteAnnonce("2");
				//an.retrieveAllAnnonces();
			//AnnonceLocation.calculprix("20/04/2021", "24/04/2021", 22.2f);
	
			//Date d=2021-04-15;
				//Location.calculPrix((Double) 223.3, new SimpleDateFormat("20100520" ) ,new SimpleDateFormat("20100520" ));
				 //Date.UTC(2021, 04, 20, 19, 12,12);
				 //Date startDate = Date.parse('12/15/15');
			       // Date endDate = Date.parse('12/16/15');
			        //SimpleDateFormat( "yyyyMMdd" ).parse( "20100520" );
	/*Annonce a = new Annonce("vente", "ariana","oui", "vente", "oui", 334.5f, true, Type_Annonce.Vente, Categorie_Annonce.DEPOT, null);
an.addAnnonce(a);*/
	}

}
