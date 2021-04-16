package com.planifixateur.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planifixateur.dao.ProjetRepository;
import com.planifixateur.exception.LignesAlreadyAssignedException;
import com.planifixateur.exception.ProjetNotFoundException;
import com.planifixateur.model.LigneProjet;
import com.planifixateur.model.Projet;

@Service
public class ProjetService implements IProjetService {

	private final ProjetRepository projetRepository;
	private final LigneProjetService ligneProjetService;

	@Autowired
	public ProjetService(ProjetRepository projetRepository, LigneProjetService ligneProjetService) {
		this.projetRepository = projetRepository;
		this.ligneProjetService = ligneProjetService;
	}

	/**
	 * Service Sauvegarde le Projet
	 */
	@Override
	public Projet saveProjet(Projet projet) {
		// TODO Auto-generated method stub
		return projetRepository.save(projet);
	}

	/**
	 * Service Retourne tous les projets
	 */
	@Override
	public List<Projet> listAllProjet() {
		// TODO Auto-generated method stub
		return projetRepository.findAll();
	}

	/**
	 * Service Retourne le projet cherché par l'id Retourne une erreur si id non
	 * trouvé
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Projet getProjet(Long id) {
		return projetRepository.findById(id).orElseThrow(() -> new ProjetNotFoundException(id));
	}

	/**
	 * Service Si id trouvé, update les champs nom et lignesProjet Sinon crée un
	 * nouveau projet
	 *
	 * @param newProjet
	 * @param id
	 * @return
	 */
	@Override
	public Projet updateProjet(Projet newProjet, Long id) {
		return projetRepository.findById(id).map(x -> {
			x.setNom(newProjet.getNom());
//			x.setLignesProjet(newProjet.getLignesProjet());
			return projetRepository.save(x);
		}).orElseGet(() -> {
			newProjet.setId(id);
			return projetRepository.save(newProjet);
		});
	}

	/**
	 * Service Supprime le projet selon l'id
	 *
	 * @param id
	 */
	@Override
	public Projet deleteProjet(Long id) {
		Projet projet = getProjet(id);
		projetRepository.deleteById(id);
		return projet;
	}

	@Transactional
	public Projet addLigneToProjet(Long projetId, Long idLigne) {
		Projet projet = getProjet(projetId);
		LigneProjet ligneProjet = ligneProjetService.getLigneProjet(idLigne);
		if (Objects.nonNull(ligneProjet.getProjet())) {
			throw new LignesAlreadyAssignedException(idLigne, ligneProjet.getProjet().getId());
		}
		projet.addLigne(ligneProjet);
		ligneProjet.setProjet(projet);
		return projet;
	}

	@Transactional
	public Projet removeLigneFromProjet(Long projetId, Long idLigne) {
		Projet projet = getProjet(projetId);
		LigneProjet ligneProjet = ligneProjetService.getLigneProjet(idLigne);
		projet.removeLigne(ligneProjet);
		return projet;
	}
}
