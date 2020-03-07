package com.letsplan.modele;

public class ResultatForm {
	
	private boolean resultat;
	private String libelleErreur;
	
	public ResultatForm() {
	}
	
	public ResultatForm(boolean resultat, String libelleErreur) {
		super();
		this.resultat = resultat;
		this.libelleErreur = libelleErreur;
	}
	public boolean isResultat() {
		return resultat;
	}
	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}
	public String getLibelleErreur() {
		return libelleErreur;
	}
	public void setLibelleErreur(String libelleErreur) {
		this.libelleErreur = libelleErreur;
	}
	
	
	
}
