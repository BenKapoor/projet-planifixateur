package com.planifixateur.exception;

import java.util.Set;

public class ProjetUnSupportedFieldPatchException extends RuntimeException {

	public ProjetUnSupportedFieldPatchException(Set<String> keys) {
		super("Field " + keys.toString() + " update is not allow.");
	}
}
