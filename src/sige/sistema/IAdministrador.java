package sige.sistema;

/**
 * Interface do Administrador
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Implementada pelos administradores do sistema
 */
public interface IAdministrador {

	/**
	 * Retorna se � o administrador principal do sistema
	 * 
	 * @return true caso seja o administrador de n�vel mais alto no sistema,
	 *         false caso n�o
	 */
	boolean isRoot();
}
