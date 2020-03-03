package com.letsplan.controllers;

import com.letsplan.config.CustomUserDetails;
import com.letsplan.entities.Evenement;
import com.letsplan.entities.Lieu;
import com.letsplan.entities.Utilisateur;
import com.letsplan.modele.DisponibilitePojo;
import com.letsplan.modele.EvenementCreation;
import com.letsplan.modele.UserRegistration;
import com.letsplan.service.EvenementService;
import com.letsplan.service.LieuService;
import com.letsplan.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

@RestController
public class BlogController {

	@Autowired
	private EvenementService evenementService;
	
	@Autowired
	private LieuService lieuService;
	
	@Autowired
    public JavaMailSender emailSender;

	@Autowired
	private UtilisateurService userService;
	
    private static Pattern pattern;
    private static Matcher matcher;

	
	@GetMapping(value = "/evenements")
	public List<Evenement> evenements() {
		return evenementService.getAllEvenement();
	}

	@GetMapping(value = "/evenement/{id}")
	public Optional<Evenement> getEvenementById(@PathVariable Long id) {
		return evenementService.getEvenement(id);
	}

	@GetMapping(value = "/posts/{username}")
	public List<Evenement> evenementByUser(@PathVariable String username) {
		return evenementService.findByUser(userService.getUser(username));
	}
	
	@GetMapping(value = "/evenements/{username}")
	public List<Evenement> evenementsInvite(@PathVariable String username) {
		Utilisateur utilisateur = userService.getUser(username);
		return evenementService.getAllEvenementInvite(utilisateur.getId());
	}
	
	@PostMapping(value = "/creationEvenement")
	public String creationEvenement(@RequestBody EvenementCreation evenementCreation) {
		String tableau[] = evenementCreation.getLoginsInvite().split(",");
		Evenement evenement = new Evenement();
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		for (String username : tableau) {
			if (userService.getUser(username) == null) {
		        pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
		        matcher = pattern.matcher(username);
		        while(matcher.find()){
		        	SimpleMailMessage message = new SimpleMailMessage();
		        	message.setTo("le.minhtri230999@gmail.com");
		        	message.setFrom(userService.getUser(userDetails.getUsername()).getUsername());
		        	message.setSubject(userService.getUser(userDetails.getUsername()).getUsername() + " vous invite à " + evenementCreation.getLibelle());
		        	message.setText("Veuillez créer un compte et répondre à l'invitation : http://localhost:8080/registration");
		        	this.emailSender.send(message);
		        }
			}else {
				evenement.getMapInvité().put(userService.getUser(username).getId(), 0);
			}
		}
		Lieu lieu = new Lieu(evenementCreation.getLibelleLieu(), evenementCreation.getNumRue(), evenementCreation.getNomRue(), evenementCreation.getNomVille(), evenementCreation.getDepartement());
		evenement.setLieu(lieu);

		evenement.setUtilisateurAdmin(userService.getUser(userDetails.getUsername()));
		evenement.setDateCreated(evenementCreation.getDate());
		evenement.setLibelle(evenementCreation.getLibelle());
		evenement.setType(evenementCreation.getNature());
		lieuService.insert(lieu);
		evenementService.insert(evenement);
		return "Evenement created";
	}

	@PostMapping(value = "/l_evenement/changerDisponibilite/{evenementId}/{username}")
	public void changerDisponibilite(@RequestBody DisponibilitePojo disponibilite, @PathVariable Long evenementId) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Evenement> evenement = evenementService.getEvenement(evenementId);
        if(evenement.isPresent()) {
        	evenement.get().getMapInvité().replace(userService.getUser(userDetails.getUsername()).getId(), disponibilite.getDisponibilite());
        	evenementService.insert(evenement.get());
        }
	}
	
    @GetMapping(value = "/evenement/invites/{evenementId}")
    public Map<String, Integer> getInvites(@PathVariable Long evenementId){
    	Map<String, Integer> map = new HashMap<>();
    	if(evenementService.getEvenement(evenementId).isPresent()) {
    		for (Long invite : evenementService.getEvenement(evenementId).get().getMapInvité().keySet()) {
    			if(userService.getUser(invite).isPresent()) {
    				map.put(userService.getUser(invite).get().getUsername(), evenementService.getEvenement(evenementId).get().getMapInvité().get(invite));
    			}
    		}
    		return map;
    	}else {
			throw new RuntimeException();
		}
    }
    
}
