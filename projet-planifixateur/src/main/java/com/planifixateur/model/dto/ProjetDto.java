package com.planifixateur.model.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import com.planifixateur.model.Projet;

public class ProjetDto {
	private Long id;

	private String nom;

	private Collection<LigneProjetDto> lignesProjetDto = new ArrayList<LigneProjetDto>();

	public ProjetDto() {
		super();
	}

	public ProjetDto(String nom, Collection<LigneProjetDto> lignesProjetDto) {
		super();
		this.nom = nom;
		this.lignesProjetDto = lignesProjetDto;
	}

	public ProjetDto(Long id, String nom, Collection<LigneProjetDto> lignesProjetDto) {
		super();
		this.id = id;
		this.nom = nom;
		this.lignesProjetDto = lignesProjetDto;
	}

	public static ProjetDto from(Projet projet) {
		ProjetDto projetDto = new ProjetDto();
		projetDto.setId(projet.getId());
		projetDto.setNom(projet.getNom());
		projetDto.setLignesProjetDto(
				projet.getLignesProjet().stream().map(LigneProjetDto::from).collect(Collectors.toList()));
		return projetDto;
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

	public Collection<LigneProjetDto> getLignesProjetDto() {
		return lignesProjetDto;
	}

	public void setLignesProjetDto(Collection<LigneProjetDto> lignesProjetDto) {
		this.lignesProjetDto = lignesProjetDto;
	}

}
