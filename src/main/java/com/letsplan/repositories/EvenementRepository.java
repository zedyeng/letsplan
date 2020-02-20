package com.letsplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letsplan.entities.Evenement;
import com.letsplan.entities.Utilisateur;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement,Long>{

    List<Evenement> findByUtilisateurAdminId(Long id);
    
    @Query("SELECT e FROM Evenement e WHERE KEY(e.mapInvites) = ?1")
    List<Evenement> getAllEvenementInvite(Long utilisateurId);

    @Transactional
    @Modifying
    @Query("UPDATE Evenement e SET e.mapInvites = :disponibilite WHERE e.id = :evenementId AND KEY(e.mapInvites) = :utilisateurId")
    void update(@Param("evenementId")Long evenementId, @Param("utilisateurId")Long utilisateurId, @Param("disponibilite")int disponibilite);
//    void update(Long evenementId, Long utilisateurId, Integer disponibilite);
    
    @Query("SELECT KEY(e.mapInvites) FROM Evenement e WHERE e.id =?1")
    List<Long> getAllInviteByEvenement(Long evenementId);


}
