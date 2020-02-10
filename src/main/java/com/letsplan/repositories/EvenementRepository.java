package com.letsplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letsplan.entities.Evenement;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement,Long>{

    List<Evenement> findByUtilisateurAdminId(Long id);

}
