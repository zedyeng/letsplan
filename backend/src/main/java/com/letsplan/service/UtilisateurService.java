package com.letsplan.service;

import com.letsplan.entities.Utilisateur;
import com.letsplan.repositories.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void save(Utilisateur user){
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        utilisateurRepository.save(user);
    }
    
    public Optional<Utilisateur> getUser(Long id){
        return utilisateurRepository.findById(id);
    }

    public Utilisateur getUserMail(String mail){
        return utilisateurRepository.findByMail(mail);
    }    
    public Utilisateur getUser(String username){
        return utilisateurRepository.findByUsername(username);
    }

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }
}
