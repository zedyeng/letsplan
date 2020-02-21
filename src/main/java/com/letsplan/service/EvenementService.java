package com.letsplan.service;

import com.letsplan.entities.Evenement;
import com.letsplan.entities.Utilisateur;
import com.letsplan.repositories.EvenementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    public List<Evenement> getAllEvenement(){
        return evenementRepository.findAll();
    }
   
    public List<Evenement> getAllEvenementInvite(Long utilisateurId){
        return evenementRepository.getAllEvenementInvite(utilisateurId);
    }
    
    public List<Long> getAllInviteByEvenement(Long evenementId){
		return evenementRepository.getAllInviteByEvenement(evenementId);
    }
    
    public void insert(Evenement evenement) {
        evenementRepository.save(evenement);
    }

    public List<Evenement> findByUser(Utilisateur user){
        return evenementRepository.findByUtilisateurAdminId(user.getId());
    }

    public boolean deleteEvenement(Long evenementId){
        Optional<Evenement> theEvenement = evenementRepository.findById(evenementId);
        if(theEvenement == null)
            return false;
        evenementRepository.deleteById(evenementId);
        return true;
    }

    public Optional<Evenement> getEvenement(Long id) {
        return evenementRepository.findById(id);
    }

    public Optional<Evenement> find(Long evenementId) {
        return evenementRepository.findById(evenementId);
    }



}
