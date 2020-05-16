package com.sid.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_cpte",discriminatorType = DiscriminatorType.STRING, length = 3)
//@Table(name = "Compte", uniqueConstraints = {
//	       @UniqueConstraint(columnNames = {"codeCompte"}) })
public abstract class Compte implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(name="codeCompte",unique=true)
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	//@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name="code_client")
	private Client client;
	//@OneToMany(mappedBy = "compte",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@OneToMany(mappedBy = "compte",fetch = FetchType.LAZY)
	private List<Operation> operation;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String codeCompte, Date dateCreation, double solde, Client client) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

}
