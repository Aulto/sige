package sige.sistema;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 */
public class ProblemaInterno extends Exception {

	/**
	 * Lan�ada quando h� algum erro no sistema.
	 */
	private static final long serialVersionUID = 1L;

	public ProblemaInterno() {
		super("Problema interno!");
	}
}
