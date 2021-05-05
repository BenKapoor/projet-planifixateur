package com.planifixateur.model.dto;

import java.util.Objects;

import com.planifixateur.model.FileDB;

public class FileDBDto {

	private String id;

	private String name;

	private String type;

	private byte[] data;

	private PlainProjetDto plainProjetDto;

	public static FileDBDto from(FileDB fileDb) {
		FileDBDto filesDBDto = new FileDBDto();
		filesDBDto.setId(fileDb.getId());
		filesDBDto.setName(fileDb.getName());
		filesDBDto.setType(fileDb.getType());
		filesDBDto.setData(fileDb.getData());
		if (Objects.nonNull(fileDb.getProjet())) {
			filesDBDto.setPlainProjetDto(PlainProjetDto.from(fileDb.getProjet()));
		}
		return filesDBDto;

	}

	public FileDBDto() {
		super();
	}

	public FileDBDto(String name, String type, byte[] data, PlainProjetDto plainProjetDto) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.plainProjetDto = plainProjetDto;
	}

	public FileDBDto(String id, String name, String type, byte[] data, PlainProjetDto plainProjetDto) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.data = data;
		this.plainProjetDto = plainProjetDto;
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

	public PlainProjetDto getPlainProjetDto() {
		return plainProjetDto;
	}

	public void setPlainProjetDto(PlainProjetDto plainProjetDto) {
		this.plainProjetDto = plainProjetDto;
	}

}
