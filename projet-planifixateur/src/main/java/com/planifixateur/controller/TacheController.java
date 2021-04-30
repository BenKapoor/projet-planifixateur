package com.planifixateur.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.planifixateur.model.Tache;
import com.planifixateur.model.dto.TacheDto;
import com.planifixateur.service.TacheService;

@CrossOrigin
@RestController
public class TacheController {
	private final TacheService tacheService;

	@Autowired
	public TacheController(TacheService tacheService) {
		this.tacheService = tacheService;
	}

	@GetMapping("/tache")
	public ResponseEntity<List<TacheDto>> getTaches() {
		List<Tache> taches = tacheService.listAllTache();
		List<TacheDto> tachesDto = taches.stream().map(TacheDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(tachesDto, HttpStatus.OK);
	}

	@GetMapping("/tache/{id}")
	public ResponseEntity<TacheDto> getTache(@PathVariable final Long id) {
		Tache tache = tacheService.getTache(id);
		return new ResponseEntity<>(TacheDto.from(tache), HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/tache")
	public ResponseEntity<TacheDto> addTache(@RequestBody final TacheDto newTacheDto) {
		Tache tache = tacheService.saveTache(Tache.from(newTacheDto));
		return new ResponseEntity<>(TacheDto.from(tache), HttpStatus.OK);
	}
}
