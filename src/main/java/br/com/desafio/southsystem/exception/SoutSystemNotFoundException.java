package br.com.desafio.southsystem.exception;

public class SoutSystemNotFoundException extends RuntimeException {


	
	private static final long serialVersionUID = 421274637906071096L;

	public SoutSystemNotFoundException(String errorMessage, Throwable err) {
	        super(errorMessage, err);
	    }
	  
	  public SoutSystemNotFoundException(String errorMessage) {
		  super(errorMessage);
	  }
}
