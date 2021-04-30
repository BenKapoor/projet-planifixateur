package com.planifixateur.model.dto;

import com.planifixateur.model.Tache;

public class TacheDto {

	private Long idTache;

	private String libelle;

	public static TacheDto from(Tache tache) {
		TacheDto tacheDto = new TacheDto();
		tacheDto.setIdTache(tache.getId());
		tacheDto.setLibelle(tache.getLibelle());
		return tacheDto;
	}

	public TacheDto() {
		super();
	}

	public TacheDto(String libelle) {
		super();
		this.libelle = libelle;
	}

	public TacheDto(Long idTache, String libelle) {
		super();
		this.idTache = idTache;
		this.libelle = libelle;
	}

	public Long getIdTache() {
		return idTache;
	}

	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
