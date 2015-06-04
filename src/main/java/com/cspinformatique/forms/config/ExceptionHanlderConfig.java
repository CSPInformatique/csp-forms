package com.cspinformatique.forms.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class ExceptionHanlderConfig {

	@ExceptionHandler
	public ResponseEntity<String> handleInvalidFileFormatException(
			HttpServletRequest request, RuntimeException ex) {
		String message = ex.getMessage();
		if (ex instanceof MultipartException) {
			message = "La taille du fichier ne peut excéder 10Mb.";
		}
		return new ResponseEntity<String>(message,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
