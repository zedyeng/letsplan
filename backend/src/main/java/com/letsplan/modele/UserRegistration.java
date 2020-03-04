package com.letsplan.modele;

public class UserRegistration {

	private String username;
	private String password;
	private String passwordConfirmation;
	private String nom;
	private String prenom;
	private String mail;

	public UserRegistration() {
	}

	public UserRegistration(String username, String password, String passwordConfirmation, String nom, String prenom,
			String mail) {
		this.username = username;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
