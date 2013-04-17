package sige.repositorio;

public class RepositorioException extends Exception {

	public RepositorioException() {
		super("Problema ao se conectar com o BD");
	}
}
