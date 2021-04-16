package com.planifixateur.model.dto;

import com.planifixateur.model.Projet;

public class PlainProjetDto {

	private Long id;
	private String nom;

	public static PlainProjetDto from(Projet projet) {
		PlainProjetDto plainProjetDto = new PlainProjetDto();
		plainProjetDto.setId(projet.getId());
		plainProjetDto.setNom(projet.getNom());
		return plainProjetDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
