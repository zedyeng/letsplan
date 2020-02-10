package com.letsplan.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String libelle;
    private String type;
    private Date duree;

	@OneToOne(targetEntity = Lieu.class)
	private Lieu lieu;
    
    @ManyToOne
    private User utilisateurAdmin;

	@ElementCollection(targetClass=User.class)
	@MapKeyColumn(name="mapInvité")
	private Map<User, Boolean> mapInvité;

    public Evenement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return libelle;
    }

    public void setTitle(String title) {
        this.libelle = title;
    }

    public String getBody() {
        return type;
    }

    public void setBody(String body) {
        this.type = body;
    }

    public Date getDateCreated() {
        return duree;
    }

    public void setDateCreated(Date dateCreated) {
        this.duree = dateCreated;
    }

    public User getUtilisateurAdmin() {
        return utilisateurAdmin;
    }

    public void setUtilisateurAdmin(User utilisateurAdmin) {
        this.utilisateurAdmin = utilisateurAdmin;
    }
}
