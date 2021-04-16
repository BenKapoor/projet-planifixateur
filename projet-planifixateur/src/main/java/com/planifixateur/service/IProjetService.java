package com.planifixateur.service;

import java.util.List;

import com.planifixateur.model.Projet;

public interface IProjetService {

	public Projet saveProjet(Projet projet);

	public List<Projet> listAllProjet();

	public Projet getProjet(Long id);

	public Projet updateProjet(Projet newProjet, Long id);

	public Projet deleteProjet(Long id);

}
