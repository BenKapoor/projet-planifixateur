package com.planifixateur.service;

import java.util.List;

import com.planifixateur.model.LigneProjet;

public interface ILigneProjetService {

	public LigneProjet saveLigneProjet(LigneProjet newLigneProjet);

	public List<LigneProjet> listAllLigneProjet();

	public LigneProjet getLigneProjet(Long id);

	public LigneProjet updateLigneProjet(LigneProjet newLigneProjet, Long id);

	public LigneProjet deleteLigneProjet(Long id);
}
