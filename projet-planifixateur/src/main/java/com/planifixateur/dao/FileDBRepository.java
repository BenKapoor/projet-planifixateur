package com.planifixateur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planifixateur.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
