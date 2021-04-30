package com.planifixateur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planifixateur.dao.TacheRepository;
import com.planifixateur.exception.TacheNotFoundException;
import com.planifixateur.model.Tache;

@Service
public class TacheService implements ITacheService {

	private final TacheRepository tacheRepository;

	@Autowired
	public TacheService(TacheRepository tacheRepository) {
		this.tacheRepository = tacheRepository;
	}

	@Override
	public Tache saveTache(Tache newTache) {
		return tacheRepository.save(newTache);
	}

	@Override
	public Tache getTache(Long id) {
		// TODO Auto-generated method stub
		return tacheRepository.findById(id).orElseThrow(() -> new TacheNotFoundException(id));
	}

	@Override
	public List<Tache> listAllTache() {
		// TODO Auto-generated method stub
		return tacheRepository.findAll();
	}
}
