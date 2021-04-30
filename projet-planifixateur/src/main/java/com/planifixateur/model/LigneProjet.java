package com.planifixateur.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.planifixateur.model.dto.LigneProjetDto;

@Entity
@Table(name = "LigneProjet")
public class LigneProjet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String libelle;

	private String description;

	private String tache;

	private Date dateDebut;

	private Date dateFin;

//	@ManyToOne
//	@JoinColumn(name = "idTache")
//	private Tache tache;

	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Projet projet;

	public LigneProjet() {
		super();
	}

	public LigneProjet(String libelle, String description, Date dateDebut, Date dateFin, String tache, Projet projet) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tache = tache;
		this.projet = projet;
	}

	public static LigneProjet from(LigneProjetDto ligneProjetDto) {
		LigneProjet ligneProjet = new LigneProjet();
		ligneProjet.setLibelle(ligneProjetDto.getLibelle());
		ligneProjet.setDescription(ligneProjetDto.getDescription());
		ligneProjet.setTache(ligneProjetDto.getTache());
		ligneProjet.setDateDebut(ligneProjetDto.getDateDebut());
		ligneProjet.setDateFin(ligneProjetDto.getDateFin());
		return ligneProjet;
	}

//	public void addTache(Tache _tache) {
//		tache = _tache;
//	}

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

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String getTache() {
		return tache;
	}

	public void setTache(String tache) {
		this.tache = tache;
	}

}
