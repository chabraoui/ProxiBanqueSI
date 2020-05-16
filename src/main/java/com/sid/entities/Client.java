package com.sid.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;


@Entity
public class Client implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue
	private long code;

	private String nom;

private String email;
	//@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@OneToOne(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	//private List<Compte> comptes;
	private Compte comptes;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="code_conseiller")
	private Conseiller conseiller;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(String nom, String email, Conseiller conseiller) {
		super();
		this.nom = nom;
		this.email = email;
		this.conseiller = conseiller;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Compte getComptes() {
		return comptes;
	}
	public void setComptes(Compte comptes) {
		this.comptes = comptes;
	}
	
}
