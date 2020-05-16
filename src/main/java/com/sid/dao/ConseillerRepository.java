package com.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sid.entities.Conseiller;
import com.sid.entities.Gerant;
@Repository
public interface ConseillerRepository extends JpaRepository<Conseiller, Long> {
	@Query("select o from Conseiller o ")
	public List<Conseiller> getConseiller() ;
	
	//@Query("select o from Conseiller o, Client c where o.id=c.conseiller.id")
	//public Conseiller getCons(long id);
}
