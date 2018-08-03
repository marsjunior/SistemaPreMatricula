package br.edu.ufcg.preMatricula.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NaoAutorizadoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NaoAutorizadoException(String message) {
		super(message);
	}
}
