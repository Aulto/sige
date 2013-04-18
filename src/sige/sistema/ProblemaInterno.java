package sige.sistema;

public class ProblemaInterno extends Exception {

	/**
	 * Lançada quando há algum erro no sistema.
	 */
	private static final long serialVersionUID = 1L;

	public ProblemaInterno() {
		super("Problema interno!");
	}
}
