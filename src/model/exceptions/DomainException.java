package model.exceptions;

public class DomainException extends RuntimeException {
	 //Excess�o personalizada
	
	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);
	}
	
}
