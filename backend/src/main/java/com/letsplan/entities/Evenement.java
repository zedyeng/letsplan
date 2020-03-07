package com.letsplan.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="evenement")
public class Evenement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String libelle;
	private String type;
	private Date date;
	private int duree;

	@OneToOne(targetEntity = Lieu.class)
	private Lieu lieu;

	@ManyToOne
	private Utilisateur utilisateurAdmin;
	
	private String transport;

	@ElementCollection
	private Map<Long, Integer> mapInvites = new HashMap<Long, Integer>();

	public Evenement() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public Map<Long, Integer> getMapInvité() {
		return mapInvites;
	}

	
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	
	public void setMapInvité(Map<Long, Integer> mapInvité) {
		this.mapInvites = mapInvité;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date dateCreated) {
		this.date = dateCreated;
	}

	public Utilisateur getUtilisateurAdmin() {
		return utilisateurAdmin;
	}

	public void setUtilisateurAdmin(Utilisateur utilisateurAdmin) {
		this.utilisateurAdmin = utilisateurAdmin;
	}
}
