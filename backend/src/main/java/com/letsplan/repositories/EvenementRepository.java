package com.letsplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;
import com.letsplan.entities.Evenement;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement,Long>{

    List<Evenement> findByUtilisateurAdminId(Long id);
    
    @Query("SELECT e FROM Evenement e WHERE KEY(e.mapInvites) = ?1")
    List<Evenement> getAllEvenementInvite(Long utilisateurId);

    @Query("SELECT KEY(e.mapInvites) FROM Evenement e WHERE e.id =?1")
    List<Long> getAllInviteByEvenement(Long evenementId);

}
