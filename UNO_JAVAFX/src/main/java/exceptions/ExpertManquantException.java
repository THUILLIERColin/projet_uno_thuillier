package exceptions;

public class ExpertManquantException extends Exception {
	/**
	 * Exception lorsque un expert n'existe pas
	 */
	public ExpertManquantException(String msg) {
		System.err.println(msg);
	}
}
