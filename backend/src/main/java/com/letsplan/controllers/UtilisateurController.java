package com.letsplan.controllers;

import com.letsplan.entities.Role;
import com.letsplan.entities.Utilisateur;
import com.letsplan.exception.UsernameExistantException;
import com.letsplan.modele.ResultatForm;
import com.letsplan.modele.UserRegistration;
import com.letsplan.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@ControllerAdvice
@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private TokenStore tokenStore;


    @PostMapping(value = "/register")
    @ExceptionHandler(value = UsernameExistantException.class)
    public ResultatForm register(@RequestBody UserRegistration userRegistration){
    	ResultatForm resultatForm = new ResultatForm();
    	
        if(utilisateurService.getUser(userRegistration.getUsername()) != null) {
        	resultatForm.setResultat(false);
        	resultatForm.setLibelleErreur("Username déja existant ! ");
        	return resultatForm;
        }
        
        if(utilisateurService.getUserMail(userRegistration.getMail()) != null) {
        	resultatForm.setResultat(false);
        	resultatForm.setLibelleErreur("Mail déja existant ! ");
        	return resultatForm;
        }
        
        if("".equals(userRegistration.getUsername()) ||
           "".equals(userRegistration.getMail())||
           "".equals(userRegistration.getPassword())||
           "".equals(userRegistration.getPasswordConfirmation())||
           "".equals(userRegistration.getNom())||
           "".equals(userRegistration.getPrenom())) {
        	resultatForm.setResultat(false);
        	resultatForm.setLibelleErreur("Les champs sont tous obligatoires !");
        	return resultatForm;
        }
        
        if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation())) {
        	resultatForm.setResultat(false);
        	resultatForm.setLibelleErreur("La confirmation du mot de passe n'est pas identique !");
        	return resultatForm;        
        }

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        if(pattern.matcher(userRegistration.getUsername()).find()) {
        	resultatForm.setResultat(false);
        	resultatForm.setLibelleErreur("Caracteres spéciaux non autorisés ! ");
        	return resultatForm;
        }
        
        pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        if(!pattern.matcher(userRegistration.getMail()).find()) {
        	resultatForm.setResultat(false);
        	resultatForm.setLibelleErreur("Adresse mail non valide ! ");
        	return resultatForm;
        }

        utilisateurService.save(new Utilisateur(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"), new Role("ACTUATOR")), userRegistration.getNom(), 
        		userRegistration.getPrenom(), userRegistration.getMail()));
        resultatForm.setResultat(true);
        return resultatForm;
    }

    @GetMapping(value = "/users")
    public List<Utilisateur> users(){
        return utilisateurService.getAllUsers();
    }

    @GetMapping(value = "/logouts")
    public void logout(@RequestParam (value = "access_token") String accessToken){
        tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken));
    }

    @GetMapping(value ="/getUsername")
    public String getUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }



}
