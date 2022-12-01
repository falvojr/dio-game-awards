package me.dio.gameawards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import me.dio.gameawards.service.exception.NegocioException;
import me.dio.gameawards.service.exception.SemResultadoException;

@RequestMapping("/api")
public abstract class BaseRestController {
	
	@ExceptionHandler(SemResultadoException.class)
	private ResponseEntity<Void> handlerSemResultadoException(SemResultadoException e) {
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(NegocioException.class)
	private ResponseEntity<ErrorResponse> handlerNegocioException(NegocioException e) {
		return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
	}

	@ExceptionHandler(Throwable.class)
	private ResponseEntity<ErrorResponse> handlerErroInesperado(Throwable e) {
		//TODO: Em produção definir um mecanismo de log mais adequado, tendo em vista a observabilidade da nossa solução.
		e.printStackTrace();
		
		ErrorResponse error = new ErrorResponse("Ops, ocorreu um erro inesperado.");
		return ResponseEntity.internalServerError().body(error);
	}

}
