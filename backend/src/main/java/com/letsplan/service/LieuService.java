package com.letsplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsplan.entities.Evenement;
import com.letsplan.entities.Lieu;
import com.letsplan.repositories.EvenementRepository;
import com.letsplan.repositories.LieuRepository;

@Service
public class LieuService {
	
    @Autowired
    private LieuRepository lieuRepository;

    
    public void insert(Lieu lieu) {
    	lieuRepository.save(lieu);
    }
}
