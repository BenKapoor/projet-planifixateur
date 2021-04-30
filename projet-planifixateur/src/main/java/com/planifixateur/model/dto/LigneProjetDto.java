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

//	private TacheDto tacheDto;
	private String tache;

	private PlainProjetDto plainProjetDto;

	public static LigneProjetDto from(LigneProjet ligneProjet) {
		LigneProjetDto ligneProjetDto = new LigneProjetDto();
		ligneProjetDto.setId(ligneProjet.getId());
		ligneProjetDto.setLibelle(ligneProjet.getLibelle());
		ligneProjetDto.setDescription(ligneProjet.getDescription());
		ligneProjetDto.setTache(ligneProjet.getTache());
		ligneProjetDto.setDateDebut(ligneProjet.getDateDebut());
		ligneProjetDto.setDateFin(ligneProjet.getDateFin());
		// dans le cas ou la ligne n'est assignées à aucune tâche
//		if (Objects.nonNull(ligneProjet.getTache())) {
//			ligneProjetDto.setTacheDto(TacheDto.from(ligneProjet.getTache()));
//		}
		// dans le cas ou la ligne n'est assignées à aucun projet
		if (Objects.nonNull(ligneProjet.getProjet())) {
			ligneProjetDto.setPlainProjetDto(PlainProjetDto.from(ligneProjet.getProjet()));
		}
		return ligneProjetDto;
	}

	public LigneProjetDto() {
		super();
	}

	public LigneProjetDto(String libelle, String description, Date dateDebut, Date dateFin, String tache,
			PlainProjetDto plainProjetDto) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tache = tache;
		this.plainProjetDto = plainProjetDto;
	}

	public LigneProjetDto(Long id, String libelle, String description, Date dateDebut, Date dateFin, String tache,
			PlainProjetDto plainProjetDto) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tache = tache;
		this.plainProjetDto = plainProjetDto;
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

	public String getTache() {
		return tache;
	}

	public void setTache(String tache) {
		this.tache = tache;
	}

}
