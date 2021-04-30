package com.planifixateur.service;

import java.util.List;

import com.planifixateur.model.Tache;

public interface ITacheService {

	public Tache saveTache(Tache newTache);

	public Tache getTache(Long id);

	public List<Tache> listAllTache();

}