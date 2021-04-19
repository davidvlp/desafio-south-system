package br.com.desafio.southsystem.exception;

public class ExceptionMessages {

	public static String getPessoaNotFoundExceptionMessage(Long id) {
		return "Pessoa com o ID: " + id + " não encontrada";
	}
	
	public static String getContaNotFoundExceptionMessage(Long id) {
		return "Conta com o ID: " + id + " não encontrada";
	}
}
