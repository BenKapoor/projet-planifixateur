package com.planifixateur.exception;

public class ProjetNotFoundException extends RuntimeException {

	public ProjetNotFoundException(Long id) {
		super("L'id : " + id + " du projet n'a pas été trouvé");
	}
}
