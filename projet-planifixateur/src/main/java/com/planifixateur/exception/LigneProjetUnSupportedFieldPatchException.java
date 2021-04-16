package com.planifixateur.exception;

import java.util.Set;

public class LigneProjetUnSupportedFieldPatchException extends RuntimeException {

	public LigneProjetUnSupportedFieldPatchException(final Set<String> keys) {
		super("Field og the Lign " + keys.toString() + " update is not allow.");
	}
}
