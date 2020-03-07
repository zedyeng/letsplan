package com.letsplan.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lieu")
public class Lieu {

	@Id
	@GeneratedValue
	private Long Id;

	private String libelle;

	private int numRue;

	private String rue;

	private String ville;

	private int departement;

	public Lieu() {
	}

	public Lieu(String libelle, int numRue, String rue, String ville, int departement) {
		this.libelle = libelle;
		this.numRue = numRue;
		this.rue = rue;
		this.ville = ville;
		this.departement = departement;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getDepartement() {
		return departement;
	}

	public void setDepartement(int departement) {
		this.departement = departement;
	}

}