package com.planifixateur.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.planifixateur.model.dto.TacheDto;

@Entity
public class Tache {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTache;

	private String libelle;

	public static Tache from(TacheDto tacheDto) {
		Tache tache = new Tache();
		tache.setLibelle(tacheDto.getLibelle());
		return tache;
	}

	public Tache() {
		super();
	}

	public Tache(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Tache(Long id, String libelle) {
		super();
		this.idTache = id;
		this.libelle = libelle;
	}

	public Long getId() {
		return idTache;
	}

	public void setId(Long id) {
		this.idTache = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
