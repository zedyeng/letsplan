package com.letsplan.modele;

import java.util.Date;
import java.util.Map;

import com.letsplan.entities.Lieu;
import com.letsplan.entities.Utilisateur;

public class EvenementCreation {

	private String libelle;
	private String nature;
	private Date date;
	private Date duree;
	private String libelleLieu;
	private int numRue;
	private String nomRue;
	private String nomVille;
	private int departement;
	private String loginsInvite;
	
	public EvenementCreation() {
	}

	public EvenementCreation(String libelle, String nature, Date date, Date duree, String libelleLieu, int numRue,
			String nomRue, String nomVille, int departement, String loginsInvite) {
		this.libelle = libelle;
		this.nature = nature;
		this.date = date;
		this.duree = duree;
		this.libelleLieu = libelleLieu;
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.nomVille = nomVille;
		this.departement = departement;
		this.loginsInvite = loginsInvite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	public String getLibelleLieu() {
		return libelleLieu;
	}

	public void setLibelleLieu(String libelleLieu) {
		this.libelleLieu = libelleLieu;
	}

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public int getDepartement() {
		return departement;
	}

	public void setDepartement(int departement) {
		this.departement = departement;
	}

	public String getLoginsInvite() {
		return loginsInvite;
	}

	public void setLoginsInvite(String loginsInvite) {
		this.loginsInvite = loginsInvite;
	}
	
}
