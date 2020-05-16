package com.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sid.entities.Gerant;
@Repository
public interface GerantRepository extends JpaRepository<Gerant, Long>{
	@Query("select o from Gerant o ")
	public List<Gerant> getGerant() ;
		
	
}
