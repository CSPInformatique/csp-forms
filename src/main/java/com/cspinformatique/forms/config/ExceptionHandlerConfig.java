package com.cspinformatique.forms.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.error.model.Error;
import org.springframework.boot.error.service.ErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class ExceptionHandlerConfig {

	@Autowired
	private ErrorService errorService;

	@ExceptionHandler
	public ResponseEntity<Error> handleInvalidFileFormatException(HttpServletRequest request, RuntimeException ex) {
		String message = ex.getMessage();
		if (ex instanceof MultipartException) {
			message = "La taille du fichier ne peut excéder 10Mb.";
		}

		return new ResponseEntity<Error>(
				errorService.save(new Error(0, new Date(), request.getRemoteAddr(), request.getRemoteHost(),
						request.getHeader("User-Agent"), message, ExceptionUtils.getFullStackTrace(ex))),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
