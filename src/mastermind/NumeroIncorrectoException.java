package mastermind;

public class NumeroIncorrectoException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public NumeroIncorrectoException(String msg) {
		super(msg);
	}
}
