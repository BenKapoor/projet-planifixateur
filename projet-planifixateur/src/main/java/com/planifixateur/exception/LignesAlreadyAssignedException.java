package com.planifixateur.exception;

import java.text.MessageFormat;

public class LignesAlreadyAssignedException extends RuntimeException {
	public LignesAlreadyAssignedException(final Long ligneId, final Long projetID) {
		super(MessageFormat.format("Ligne : {0} is already assigned to Projet : {1}", ligneId, projetID));
	}
}
