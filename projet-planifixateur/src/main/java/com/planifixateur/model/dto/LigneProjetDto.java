package com.planifixateur.model.dto;

import java.util.Date;
import java.util.Objects;

import com.planifixateur.model.LigneProjet;

public class LigneProjetDto {
	private Long id;

	private String libelle;

	private String description;

	private Date dateDebut;

	private Date dateFin;

	private PlainProjetDto plainProjetDto;

	public static LigneProjetDto from(LigneProjet ligneProjet) {
		LigneProjetDto ligneProjetDto = new LigneProjetDto();
		ligneProjetDto.setId(ligneProjet.getId());
		ligneProjetDto.setLibelle(ligneProjet.getLibelle());
		ligneProjetDto.setDescription(ligneProjet.getDescription());
		ligneProjetDto.setDateDebut(ligneProjet.getDateDebut());
		ligneProjetDto.setDateFin(ligneProjet.getDateFin());
		// dans le cas ou la ligne n'est assignées à aucun projet
		if (Objects.nonNull(ligneProjet.getProjet())) {
			ligneProjetDto.setPlainProjetDto(PlainProjetDto.from(ligneProjet.getProjet()));
		}
		return ligneProjetDto;
	}

	public LigneProjetDto() {
		super();
	}

	public LigneProjetDto(Long id, String libelle, String description, Date dateDebut, Date dateFin) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public LigneProjetDto(String libelle, String description, Date dateDebut, Date dateFin) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public PlainProjetDto getPlainProjetDto() {
		return plainProjetDto;
	}

	public void setPlainProjetDto(PlainProjetDto plainProjetDto) {
		this.plainProjetDto = plainProjetDto;
	}

}
