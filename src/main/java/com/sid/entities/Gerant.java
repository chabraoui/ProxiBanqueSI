package com.sid.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Gerant {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String nom;
@OneToMany(mappedBy = "gerant",fetch = FetchType.LAZY)
private List<Conseiller> conseiller;
public Gerant() {
	super();
	// TODO Auto-generated constructor stub
}
public Gerant(String nom) {
	super();
	this.nom = nom;
}



public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public List<Conseiller> getConseiller() {
	return conseiller;
}
public void setConseiller(List<Conseiller> conseiller) {
	this.conseiller = conseiller;
}

}
