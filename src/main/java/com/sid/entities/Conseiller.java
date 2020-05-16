package com.sid.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Conseiller {
	@Id
	@GeneratedValue
	private long id;
	private String nom;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "name_gerant")
	private Gerant gerant;
	@OneToMany(mappedBy = "conseiller", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Client> listeClient;

	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conseiller(String nom, Gerant gerant) {
		super();
		this.nom = nom;
		this.gerant = gerant;
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

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

}
