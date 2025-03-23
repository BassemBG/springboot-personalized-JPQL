package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class OffreStage {
	
	@Id
	@GeneratedValue
	long code;
	
	String intitule;
	String specialite;
	
	@ManyToOne
	@JoinColumn(name = "idSociete", nullable = false)
	Societe societe;
	

	/**
	 * 
	 */
	public OffreStage() {
		super();
	}

	
	/**
	 * @param intitule
	 * @param specialite
	 * @param societe
	 */
	
	public OffreStage(String intitule, String specialite, Societe societe) {
		super();
		this.intitule = intitule;
		this.specialite = specialite;
		this.societe = societe;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	
	
	
}
