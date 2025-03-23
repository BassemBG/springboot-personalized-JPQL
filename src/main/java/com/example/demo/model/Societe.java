package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Societe {
	
	@Id
	@GeneratedValue
	long idSociete;
	
	String nomCommercial;
	String activite;
	String pays;

	public Societe() {
		super();
	}

	
	/**
	 * @param nomCommercial
	 * @param activite
	 * @param pays
	 */
	
	public Societe(String nomCommercial, String activite, String pays) {
		super();
		this.nomCommercial = nomCommercial;
		this.activite = activite;
		this.pays = pays;
	}
	
	
	/**
	 * @return the idSociete
	 */
	
	public long getIdSociete() {
		return idSociete;
	}
	
	/**
	 * @param idSociete the idSociete to set
	 */
	
	public void setIdSociete(long idSociete) {
		this.idSociete = idSociete;
	}
	
	/**
	 * @return the nomCommercial
	 */
	
	public String getNomCommercial() {
		return nomCommercial;
	}
	
	/**
	 * @param nomCommercial the nomCommercial to set
	 */
	
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}
	
	/**
	 * @return the activite
	 */
	
	public String getActivite() {
		return activite;
	}
	
	/**
	 * @param activite the activite to set
	 */
	
	public void setActivite(String activite) {
		this.activite = activite;
	}
	
	/**
	 * @return the pays
	 */
	
	public String getPays() {
		return pays;
	}
	
	/**
	 * @param pays the pays to set
	 */
	
	public void setPays(String pays) {
		this.pays = pays;
	}
}