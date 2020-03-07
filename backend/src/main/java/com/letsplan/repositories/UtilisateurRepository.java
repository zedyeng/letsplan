package com.letsplan.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsplan.entities.Utilisateur;

/**
 * User repository for CRUD operations.
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByUsername(String username);

}
