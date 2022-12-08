package me.dio.gameawards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import me.dio.gameawards.service.exception.BusinessException;
import me.dio.gameawards.service.exception.NoContentException;

@RequestMapping("/api")
public abstract class BaseRestController {
	
	@ExceptionHandler(NoContentException.class)
	private ResponseEntity<Void> handlerNoContentException(NoContentException e) {
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(BusinessException.class)
	private ResponseEntity<ApiErrorDTO> handlerBusinessException(BusinessException e) {
		return ResponseEntity.badRequest().body(new ApiErrorDTO(e.getMessage()));
	}

	@ExceptionHandler(Throwable.class)
	private ResponseEntity<ApiErrorDTO> handlerUnexpectedException(Throwable e) {
		//TODO: Em produção definir um mecanismo de log mais adequado, tendo em vista a observabilidade da nossa solução.
		e.printStackTrace();
		
		return ResponseEntity.internalServerError().body(new ApiErrorDTO("Ops, ocorreu um erro inesperado."));
	}

}
