package com.planifixateur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planifixateur.model.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {

}
