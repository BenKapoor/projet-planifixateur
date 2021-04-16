package com.planifixateur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planifixateur.model.LigneProjet;

@Repository
public interface LigneProjetRepository extends JpaRepository<LigneProjet, Long> {

}
