package com.planifixateur.exception;

import java.text.MessageFormat;

public class FileAlreadyAssignedException extends RuntimeException {

	public FileAlreadyAssignedException(final String fileId, final Long projetID) {
		super(MessageFormat.format("File : {0} is already assigned to Projet : {1}", fileId, projetID));
	}
}
