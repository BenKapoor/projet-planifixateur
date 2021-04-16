package com.planifixateur.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.planifixateur.exception.LigneProjetNotFoundException;
import com.planifixateur.exception.LigneProjetUnSupportedFieldPatchException;
import com.planifixateur.exception.ProjetNotFoundException;
import com.planifixateur.exception.ProjetUnSupportedFieldPatchException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// Let Spring handle the exception, we just override the status code
	@ExceptionHandler({ ProjetNotFoundException.class, LigneProjetNotFoundException.class })
	public void springHandleNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler({ ProjetUnSupportedFieldPatchException.class, LigneProjetUnSupportedFieldPatchException.class })
	public void springUnSupportedFieldPatch(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value());
	}

}
