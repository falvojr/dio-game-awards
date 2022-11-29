package me.dio.gameawards.service.exception;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String mensagemNegocio) {
		super(mensagemNegocio);
	}
}
