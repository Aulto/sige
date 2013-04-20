package sige.sistema;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 */
public class InicializacaoSistemaException extends Exception {

	/**
	 * Lançada quando ocorre algum problema ao tentar inicialziar o sistema
	 */
	private static final long serialVersionUID = 1L;

	public InicializacaoSistemaException() {
		super("Nao foi possivel inicializar o sistema");
	}

}
