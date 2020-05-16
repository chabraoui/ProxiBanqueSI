package com.sid;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sid.dao.ClientRepository;
import com.sid.dao.CompteRepository;
import com.sid.dao.ConseillerRepository;
import com.sid.dao.GerantRepository;
import com.sid.dao.OperationRepository;
import com.sid.entities.Client;
import com.sid.entities.Compte;
import com.sid.entities.CompteCourant;
import com.sid.entities.CompteEpargne;
import com.sid.entities.Conseiller;
import com.sid.entities.Gerant;
import com.sid.entities.Operation;
import com.sid.entities.Retrait;
import com.sid.entities.Versement;


@SpringBootApplication
public class TrainingGestionCompteApplication implements CommandLineRunner {
	@Autowired
private ClientRepository clientRepository;
	@Autowired
private OperationRepository operationRepository;
	@Autowired
private GerantRepository gerantRepository;
	@Autowired
private CompteRepository compteRepository;
@Autowired
private ConseillerRepository conseillerRepository;

	public static void main(String[] args) {
		SpringApplication.run(TrainingGestionCompteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		/*
		 * Gerant g1=gerantRepository.save(new Gerant("YAZID")); Gerant
		 * g2=gerantRepository.save(new Gerant("ziyad"));
		 * 
		 * 
		 * Conseiller con1=conseillerRepository.save(new Conseiller("Younes", g1));
		 * Conseiller con2=conseillerRepository.save(new Conseiller("SHABRAWY", g2));
		 * 
		 * 
		 * 
		 * Client cl1=clientRepository.save(new Client("MASTAFA HAPPY",
		 * "happy@gmail.com", con1)); Client cl2=clientRepository.save(new
		 * Client("MASTAFA HAPPY", "happy@gmail.com", con2));
		 * 
		 * Compte c1=compteRepository.save(new CompteCourant("c1", new Date(), 9999999,
		 * cl1, 6000)); Compte c2=compteRepository.save(new CompteEpargne("c2", new
		 * Date(), 7878899, cl2, 5.5));
		 * 
		 * 
		 * Operation o1=operationRepository.save(new Versement(new Date(), 60089, c1));
		 * Operation o2=operationRepository.save(new Retrait(new Date(), 4100, c2));
		 */
		 
		
	}

}
