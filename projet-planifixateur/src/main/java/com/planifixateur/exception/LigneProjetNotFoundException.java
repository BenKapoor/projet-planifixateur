package com.planifixateur.exception;

public class LigneProjetNotFoundException extends RuntimeException {
	public LigneProjetNotFoundException(final Long id) {
		super("L'id : " + id + " de la ligne du projet n'a pas été trouvée");
	}
}
