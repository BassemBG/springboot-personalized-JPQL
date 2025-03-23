package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.OffreStage;
import com.example.demo.model.Societe;
import com.example.demo.repository.OffreStageRepository;
import com.example.demo.repository.SocieteRepository;

@Service
public class OffreStageService {

	public final OffreStageRepository offreStageRepo; 
	public final SocieteRepository societeRepo; 
	
	@Autowired
	public OffreStageService(OffreStageRepository offreStageRepo, SocieteRepository societeRepo) {
		super();
		this.offreStageRepo = offreStageRepo;
		this.societeRepo = societeRepo;
	}
	
	public List<OffreStage> getAll() {
		return offreStageRepo.findAll();
	}
	
	public OffreStage getStageById(Long id) {
		return offreStageRepo.findById(id).get();
	}
	
	public String deleteStage(Long id) {
		if (offreStageRepo.existsById(id)) {
			offreStageRepo.deleteById(id);
			return "supprimé avec succes";
		}
		return "Echec de supression, stage n existe pas";

		
	}
	
	public String createStage(OffreStage newStage) {
		if (offreStageRepo.existsById(newStage.getCode())) { //This isn't woeking properly cuz id is aut generated
			return "Stage déjà existe";
		}
		Societe societe = newStage.getSociete();
		
		if(!societeRepo.existsById(societe.getIdSociete())) {
			societeRepo.save(societe);  
		}
		offreStageRepo.save(newStage);
		return "Ajout avec succes";
	
	}
	
	public String updateStage(OffreStage updatedStage, long stageId) {
		if (offreStageRepo.existsById(stageId)) {
			OffreStage oldStage = offreStageRepo.findById(stageId).orElse(null);

            if (oldStage != null) {
            	
            	/*
            	 * i can further improve this code by only setting the attributes 
            	 * after checking if they even changed cuz he may not change the whole stage infos
            	 */
            	oldStage.setIntitule(updatedStage.getIntitule());
            	oldStage.setSpecialite(updatedStage.getSpecialite());
            	oldStage.setSociete(updatedStage.getSociete());

            	//check if user entered a company that doesn't exist -> we create it in db
            	if(!societeRepo.existsById(updatedStage.getSociete().getIdSociete())) {
            		societeRepo.save(updatedStage.getSociete());  
            	}


          
            	offreStageRepo.save(oldStage);
                return "Mise à jour avec succès";
            } else {
                return "Erreur de mise à jour de stage";
            }
		}
		
		return "Stage n\'existe pas";

		
	}
	
	
	//personalised JPQL
	
	public List<OffreStage> getStagesByIntitule(String intitule){
		return offreStageRepo.getStagesByIntitule(intitule);
	}
	
	public List<OffreStage> getStagesBySociete(long idSociete){
		return offreStageRepo.getStagesBySociete(idSociete);
	}
	
	public List<OffreStage> getStagesByPays(String pays){
		return offreStageRepo.getStagesByPays(pays);
	}
	
	public void deleteStageBySpecialite(String specialite){
		offreStageRepo.deleteStageBySpecialite(specialite);
	}
	
	public void deleteStageByActivite(String societeAct){
		offreStageRepo.deleteStageByActivite(societeAct);
	}
	
}
