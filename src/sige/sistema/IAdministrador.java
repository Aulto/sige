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
	 * Retorna se é o administrador principal do sistema
	 * 
	 * @return true caso seja o administrador de nível mais alto no sistema,
	 *         false caso não
	 */
	boolean isRoot();
}
