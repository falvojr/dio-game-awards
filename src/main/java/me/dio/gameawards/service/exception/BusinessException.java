package me.dio.gameawards.service.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException(String mensagemNegocio) {
		super(mensagemNegocio);
	}
}
