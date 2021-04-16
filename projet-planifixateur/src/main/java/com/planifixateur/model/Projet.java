package com.planifixateur.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.planifixateur.model.dto.ProjetDto;

@Entity
@Table(name = "Projet")
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_projet")
	private Collection<LigneProjet> lignesProjet = new ArrayList<LigneProjet>();

	public Projet() {
		super();
	}

	public Projet(String nom, Collection<LigneProjet> lignesProjet) {
		super();
		this.nom = nom;
		this.lignesProjet = lignesProjet;
	}

	public static Projet from(ProjetDto projetDto) {
		Projet projet = new Projet();
		projet.setNom(projetDto.getNom());
		return projet;
	}

	public void addLigne(LigneProjet ligneProjet) {
		lignesProjet.add(ligneProjet);
	}

	public void removeLigne(LigneProjet ligneProjet) {
		lignesProjet.remove(ligneProjet);
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

	public Collection<LigneProjet> getLignesProjet() {
		return lignesProjet;
	}

	public void setLignesProjet(Collection<LigneProjet> lignesProjet) {
		this.lignesProjet = lignesProjet;
	}

}
