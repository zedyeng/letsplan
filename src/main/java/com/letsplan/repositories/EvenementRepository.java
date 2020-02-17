package com.letsplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letsplan.entities.Evenement;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement,Long>{

    List<Evenement> findByUtilisateurAdminId(Long id);
    
//    @Query(value = "SELECT evenement_id FROM evenement_map_invites e WHERE e.map_invites_key = ?1",
//    		nativeQuery = true)
    @Query("SELECT e FROM Evenement e WHERE KEY(e.mapInvites) = ?1")
    List<Evenement> getAllEvenementInvite(Long utilisateurId);


}
