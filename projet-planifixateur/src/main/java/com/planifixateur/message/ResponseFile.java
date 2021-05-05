package com.planifixateur.message;

import com.planifixateur.model.Projet;

public class ResponseFile {
	private String id;
	private String name;
	private String url;
	private String type;
	private long size;
	private Projet projet;

	public ResponseFile(String name, String url, String type, long size) {
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
	}

	public ResponseFile(String id, String name, String url, String type, long size) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
	}

	public ResponseFile(String id, String name, String url, String type, long size, Projet projet) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
		this.projet = projet;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}