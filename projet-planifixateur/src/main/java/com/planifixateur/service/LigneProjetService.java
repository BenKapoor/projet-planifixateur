package com.planifixateur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planifixateur.dao.LigneProjetRepository;
import com.planifixateur.exception.LigneProjetNotFoundException;
import com.planifixateur.model.LigneProjet;

@Service
public class LigneProjetService implements ILigneProjetService {

	private final LigneProjetRepository ligneProjetRepository;

	@Autowired
	public LigneProjetService(LigneProjetRepository ligneProjetRepository) {
		this.ligneProjetRepository = ligneProjetRepository;
	}

	@Override
	public LigneProjet saveLigneProjet(LigneProjet newLigneProjet) {
		// TODO Auto-generated method stub
		return ligneProjetRepository.save(newLigneProjet);
	}

	@Override
	public List<LigneProjet> listAllLigneProjet() {
		// TODO Auto-generated method stub
		return ligneProjetRepository.findAll();
	}

	@Override
	public LigneProjet getLigneProjet(Long id) {
		// TODO Auto-generated method stub
		return ligneProjetRepository.findById(id).orElseThrow(() -> new LigneProjetNotFoundException(id));
	}

	@Override
	public LigneProjet updateLigneProjet(LigneProjet newLigneProjet, Long id) {
		// TODO Auto-generated method stub
		return ligneProjetRepository.findById(id).map(x -> {
			x.setLibelle(newLigneProjet.getLibelle());
			x.setDescription(newLigneProjet.getDescription());
			x.setDateDebut(newLigneProjet.getDateDebut());
			x.setDateFin(newLigneProjet.getDateFin());
			x.setTache(newLigneProjet.getTache());
			return ligneProjetRepository.save(x);
		}).orElseGet(() -> {
			newLigneProjet.setId(id);
			return ligneProjetRepository.save(newLigneProjet);
		});
	}

	@Override
	public LigneProjet deleteLigneProjet(Long id) {
		// TODO Auto-generated method stub
		LigneProjet ligneProjet = getLigneProjet(id);
		ligneProjetRepository.delete(ligneProjet);
		return ligneProjet;
	}

//	@Transactional
//	public LigneProjet addTacheToLigne(Long ligneId, Long tacheId) {
//		LigneProjet ligne = getLigneProjet(ligneId);
//		Tache tache = tacheService.getTache(tacheId);
//
//		ligne.setTache(tache);
//		return ligne;
//	}

}
