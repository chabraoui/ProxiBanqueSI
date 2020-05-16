package com.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sid.entities.Compte;
import com.sid.entities.Gerant;
@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {
	@Query("select o from Compte o ")
	public List<Compte> getCompte() ;
	//@Query("select o from Compte o, Client c where o.client.id=c.code")
	//public Compte getcompt();
	@Query("select o from Compte o ")
public Compte getc(String cpt);
	
	@Query("select o from Compte o where o.client.id=:x")
	public Compte getcompt(@Param("x") long code); 
}
