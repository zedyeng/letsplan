package com.letsplan.controllers;

import com.letsplan.entities.Role;
import com.letsplan.entities.Utilisateur;
import com.letsplan.pojos.UserRegistration;
import com.letsplan.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private TokenStore tokenStore;


    //a rendre mvc
    @PostMapping(value = "/register")
    public String register(@RequestBody UserRegistration userRegistration){
        if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation()))
            return "Error the two passwords do not match";
        else if(utilisateurService.getUser(userRegistration.getUsername()) != null)
            return "Error this username already exists";

        //Checking for non alphanumerical characters in the username.
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        if(pattern.matcher(userRegistration.getUsername()).find())
            return "No special characters are allowed in the username";

        utilisateurService.save(new Utilisateur(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"), new Role("ACTUATOR")), userRegistration.getNom(), 
        		userRegistration.getPrenom(), userRegistration.getMail()));
        return "User created";
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
