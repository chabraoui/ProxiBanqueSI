package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sid.entities.Client;
@Repository
public interface ClientRepository  extends JpaRepository<Client, Long>{
	@Query("select o from Client o where conseiller.id=:x")
public Client getCl(@Param("x") long id);
}
