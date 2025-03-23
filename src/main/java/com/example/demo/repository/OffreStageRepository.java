package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.OffreStage;

@Repository
public interface OffreStageRepository extends JpaRepository<OffreStage, Long> {

	@Query("SELECT o FROM OffreStage o WHERE o.intitule = :intitule")
	List<OffreStage> getStagesByIntitule(@Param("intitule") String intitule);
	
	@Query("SELECT o FROM OffreStage o WHERE o.societe.idSociete = :idSociete")
	List<OffreStage> getStagesBySociete(@Param("idSociete") Long idSociete);
	
	@Query("SELECT o FROM OffreStage o WHERE o.societe.idSociete IN (SELECT s.idSociete FROM Societe s WHERE s.pays = :pays)")
	List<OffreStage> getStagesByPays(@Param("pays") String pays);
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM OffreStage o WHERE o.specialite = :specialite")
	void deleteStageBySpecialite(@Param("specialite") String specialite);

	
	@Transactional
	@Modifying
	@Query("DELETE FROM OffreStage o WHERE o.societe.idSociete IN (SELECT s.idSociete FROM Societe s WHERE s.activite = :activite)")
	void deleteStageByActivite(@Param("activite") String societeAct);



}
