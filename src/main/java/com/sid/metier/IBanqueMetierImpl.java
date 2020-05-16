package com.sid.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.dao.ClientRepository;
import com.sid.dao.CompteRepository;
import com.sid.dao.OperationRepository;
import com.sid.entities.Compte;
import com.sid.entities.CompteCourant;
import com.sid.entities.Operation;
import com.sid.entities.Retrait;
import com.sid.entities.Versement;

@Service
@Transactional
public class IBanqueMetierImpl implements IBanqueMetier {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compteRepository.findById(codeCpte).get();
		if (cp==null) throw new RuntimeException("compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);

	}

	@Override
	public void retirer(String codeCpte, double montant) {

		Compte cp = consulterCompte(codeCpte);
		double faciliteCaisse = 0;
		if (cp instanceof CompteCourant)
			faciliteCaisse = ((CompteCourant) cp).getDecouvert();
		if (cp.getSolde() + faciliteCaisse < montant)
			throw new RuntimeException("Solde Insuffisant !");
		Retrait v = new Retrait(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		if(codeCpte1.equals(codeCpte2)) throw new RuntimeException(" Impossible virement en mm compte");
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
		
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {

		return operationRepository.listeOperation(codeCpte, PageRequest.of(page, size) );
	}

}
