package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OffreStage;
import com.example.demo.service.OffreStageService;

@RestController
@RequestMapping(path="RestApi/stages")
public class OffreStageController {

	
	public final OffreStageService offreStageService; 
	
	@Autowired
	public OffreStageController(OffreStageService offreStageService) {
		this.offreStageService = offreStageService;
	}
	
	@GetMapping()
	public List<OffreStage> getAll(){
		return offreStageService.getAll();
	}
	
	
	@GetMapping(value="/{id}")
	public OffreStage getStageById(@PathVariable("id") Long id){
		return offreStageService.getStageById(id);
	}
	
	
	@DeleteMapping(value="/{id}")
	public String deleteStage(@PathVariable("id") Long id){
		return offreStageService.deleteStage(id);
	}
	
	@PostMapping()
	public String createStage(@RequestBody OffreStage newStage){
		return offreStageService.createStage(newStage);
	}
	
	@PutMapping(value="/{id}")
	public String updateStage(
			@PathVariable("id") Long stageId, 
			@RequestBody OffreStage updatedStage
			){
		return offreStageService.updateStage(updatedStage,stageId);
	}
	
	
	//Personalised JPQL
	
	@GetMapping(value="/intitule/{intitule}")
	public List<OffreStage> getStagesByIntitule(@PathVariable("intitule") String intitule){
		return offreStageService.getStagesByIntitule(intitule);
	}
	
	@GetMapping(value="/societe/{idSociete}")
	public List<OffreStage> getStagesBySociete(@PathVariable("idSociete") long idSociete){
		return offreStageService.getStagesBySociete(idSociete);
	}
	
	
	@GetMapping(value="/pays/{pays}")
	public List<OffreStage> getStagesByPays(@PathVariable("pays") String pays){
		return offreStageService.getStagesByPays(pays);
	}
	
	@DeleteMapping(value="/specialite/{specialite}")
	public void deleteStageBySpecialite(@PathVariable("specialite") String specialite){
		offreStageService.deleteStageBySpecialite(specialite);
	}
	
	@DeleteMapping(value="/activite/{societeAct}")
	public void deleteStageByActivite(@PathVariable("societeAct") String societeAct){
		offreStageService.deleteStageByActivite(societeAct);
	}
	
	
}
