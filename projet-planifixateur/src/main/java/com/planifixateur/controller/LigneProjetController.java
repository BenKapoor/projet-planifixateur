package com.planifixateur.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.planifixateur.model.LigneProjet;
import com.planifixateur.model.dto.LigneProjetDto;
import com.planifixateur.service.LigneProjetService;

@CrossOrigin
@RestController
public class LigneProjetController {

	private final LigneProjetService ligneProjetService;

	@Autowired
	public LigneProjetController(LigneProjetService ligneProjetService) {
		super();
		this.ligneProjetService = ligneProjetService;
	}

	/**
	 * Save Return 201 instead of 200
	 *
	 * @param newLigneProjet
	 * @return
	 */
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping("/lignesprojet")
//	LigneProjet newLigneProjet(@RequestBody LigneProjet newLigneProjet) {
//		return ligneProjetService.saveLigneProjet(newLigneProjet);
//	}

	/**
	 * Save or update
	 *
	 * @param newLigneProjet
	 * @param id
	 * @return
	 */
//	@PutMapping("/lignesprojet/{id}")
//	LigneProjet saveOrUpdate(@RequestBody LigneProjet newLigneProjet, @PathVariable Long id) {
//		return ligneProjetService.updateLigneProjet(newLigneProjet, id);
//	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/lignesprojet")
	public ResponseEntity<LigneProjetDto> addLigneProjet(@RequestBody final LigneProjetDto newLigneProjetDto) {
		LigneProjet ligne = ligneProjetService.saveLigneProjet(LigneProjet.from(newLigneProjetDto));
		return new ResponseEntity<>(LigneProjetDto.from(ligne), HttpStatus.OK);
	}

	@GetMapping("/lignesprojet")
	public ResponseEntity<List<LigneProjetDto>> getLignes() {
		List<LigneProjet> lignes = ligneProjetService.listAllLigneProjet();
		List<LigneProjetDto> lignesDto = lignes.stream().map(LigneProjetDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(lignesDto, HttpStatus.OK);
	}

	@GetMapping("/lignesprojet/{id}")
	public ResponseEntity<LigneProjetDto> getLigne(@PathVariable final Long id) {
		LigneProjet ligne = ligneProjetService.getLigneProjet(id);
		return new ResponseEntity<>(LigneProjetDto.from(ligne), HttpStatus.OK);
	}

	@DeleteMapping("/lignesprojet/{id}")
	public ResponseEntity<LigneProjetDto> deleteLigne(@PathVariable final Long id) {
		LigneProjet ligne = ligneProjetService.deleteLigneProjet(id);
		return new ResponseEntity<>(LigneProjetDto.from(ligne), HttpStatus.OK);
	}

	@PutMapping("/lignesprojet/{id}")
	public ResponseEntity<LigneProjetDto> editLigne(@PathVariable final Long id,
			@RequestBody LigneProjetDto lignesDto) {
		LigneProjet editedLigne = ligneProjetService.updateLigneProjet(LigneProjet.from(lignesDto), id);
		return new ResponseEntity<>(LigneProjetDto.from(editedLigne), HttpStatus.OK);
	}

//	@PostMapping("/lignesprojet/{ligneId}/tache/{tacheId}/add")
//	public ResponseEntity<LigneProjetDto> addTacheToLigne(@PathVariable final Long ligneId,
//			@PathVariable final Long tacheId) {
//		LigneProjet ligne = ligneProjetService.addTacheToLigne(ligneId, tacheId);
//		return new ResponseEntity<>(LigneProjetDto.from(ligne), HttpStatus.OK);
//	}
}
