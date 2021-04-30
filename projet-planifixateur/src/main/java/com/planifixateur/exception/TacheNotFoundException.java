package com.planifixateur.exception;

public class TacheNotFoundException extends RuntimeException {
	public TacheNotFoundException(final Long id) {
		super("L'id : " + id + " de la tache n'a pas été trouvée");
	}
}
