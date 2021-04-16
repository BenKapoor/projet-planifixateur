package com.planifixateur.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.planifixateur.model.Projet;
import com.planifixateur.model.dto.ProjetDto;
import com.planifixateur.service.ProjetService;

@RestController
public class ProjetController {

	private final ProjetService projetService;

	@Autowired
	public ProjetController(ProjetService projetService) {
		super();
		this.projetService = projetService;
	}

	/**
	 * Find all projets
	 *
	 * @return
	 */
//	@GetMapping("/projets")
//	List<Projet> findAll() {
//		return projetService.listAllProjet();
//	}

	/**
	 * Save Return 201 instead of 200
	 *
	 * @param newProjet
	 * @return
	 */
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping("/projets")
//	Projet newProjet(@RequestBody Projet newProjet) {
//		return projetService.saveProjet(newProjet);
//	}

	/**
	 * Find
	 *
	 * @param id
	 * @return
	 */
//	@GetMapping("/projets/{id}")
//	Projet findOneProjet(@PathVariable Long id) {
//		return projetService.getProjet(id);
//	}

	/**
	 * Save or update
	 *
	 * @param newProjet
	 * @param id
	 * @return
	 */
//	@PutMapping("/projets/{id}")
//	Projet saveOrUpdate(@RequestBody Projet newProjet, @PathVariable Long id) {
//		return projetService.updateProjet(newProjet, id);
//	}

	/**
	 * Delete
	 *
	 * @param id
	 */
//	@DeleteMapping("/projets/{id}")
//	void deleteProjet(@PathVariable Long id) {
//		projetService.deleteProjet(id);
//	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/projets")
	public ResponseEntity<ProjetDto> addProjet(@RequestBody final ProjetDto newProjetDto) {
		Projet projet = projetService.saveProjet(Projet.from(newProjetDto));
		return new ResponseEntity<>(ProjetDto.from(projet), HttpStatus.OK);
	}

	@GetMapping("/projets")
	public ResponseEntity<List<ProjetDto>> getProjets() {
		List<Projet> projets = projetService.listAllProjet();
		List<ProjetDto> projetsDto = projets.stream().map(ProjetDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(projetsDto, HttpStatus.OK);
	}

	@GetMapping("/projets/{id}")
	public ResponseEntity<ProjetDto> getProjet(@PathVariable final Long id) {
		Projet projet = projetService.getProjet(id);
		return new ResponseEntity<>(ProjetDto.from(projet), HttpStatus.OK);
	}

	@DeleteMapping("/projets/{id}")
	public ResponseEntity<ProjetDto> deleteProjet(@PathVariable final Long id) {
		Projet projet = projetService.deleteProjet(id);
		return new ResponseEntity<>(ProjetDto.from(projet), HttpStatus.OK);
	}

	@PutMapping("/projets/{id}")
	public ResponseEntity<ProjetDto> editProjet(@PathVariable final Long id, @RequestBody ProjetDto projetsDto) {
		Projet editedProjet = projetService.updateProjet(Projet.from(projetsDto), id);
		return new ResponseEntity<>(ProjetDto.from(editedProjet), HttpStatus.OK);
	}

	@PostMapping("/projets/{projetId}/lignesprojet/{ligneId}/add")
	public ResponseEntity<ProjetDto> addLigneToProjet(@PathVariable final Long projetId,
			@PathVariable final Long ligneId) {
		Projet projet = projetService.addLigneToProjet(projetId, ligneId);
		return new ResponseEntity<>(ProjetDto.from(projet), HttpStatus.OK);
	}

	@DeleteMapping("/projets/{projetId}/lignesprojet/{ligneId}/remove")
	public ResponseEntity<ProjetDto> deleteLigneToProjet(@PathVariable final Long projetId,
			@PathVariable final Long ligneId) {
		Projet projet = projetService.removeLigneFromProjet(projetId, ligneId);
		return new ResponseEntity<>(ProjetDto.from(projet), HttpStatus.OK);
	}
}
