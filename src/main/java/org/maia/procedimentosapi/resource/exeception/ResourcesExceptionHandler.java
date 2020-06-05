package org.maia.procedimentosapi.resource.exeception;

import javax.servlet.http.HttpServletRequest;

import org.maia.procedimentosapi.services.execeptions.IllegalArgumentException;
import org.maia.procedimentosapi.services.execeptions.ObjectNotFoundExecption;
import org.maia.procedimentosapi.services.execeptions.RequestNotAutorizationExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(ObjectNotFoundExecption.class)
	public ResponseEntity<StandardError> objNotFound(ObjectNotFoundExecption e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(RequestNotAutorizationExecption.class)
	public ResponseEntity<StandardError> objNotFound(RequestNotAutorizationExecption e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(),
				"Não Autorizado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> objNotFound(IllegalArgumentException e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Falha na Integridades dos Dados", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}


}
