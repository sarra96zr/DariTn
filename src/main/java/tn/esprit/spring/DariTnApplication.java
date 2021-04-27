package tn.esprit.spring;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.spring.entity.Location;

@SpringBootApplication
public class DariTnApplication {

	public static void main(String[] args) {
		SpringApplication.run(DariTnApplication.class, args);
		
		Location.calculPrix((Double) 223.3, new SimpleDateFormat("20100520" ) ,new SimpleDateFormat("20100520" ));
	}

}
