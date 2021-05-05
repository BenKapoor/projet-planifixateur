package com.planifixateur.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.planifixateur.model.dto.FileDBDto;

@Entity
@Table(name = "files")
public class FileDB {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String name;

	private String type;

	@Lob
	private byte[] data;

	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Projet projet;

	public static FileDB from(FileDBDto fileDBDto) {
		FileDB fileDB = new FileDB();
		fileDB.setName(fileDBDto.getName());
		fileDB.setType(fileDBDto.getType());
		fileDB.setType(fileDBDto.getType());
		fileDB.setData(fileDBDto.getData());
		return fileDB;
	}

	public FileDB() {
	}

	public FileDB(String name, String type, byte[] data, Projet projet) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.projet = projet;
	}

	public FileDB(String name, String type, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}