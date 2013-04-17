package sige.sistema;

import java.util.ArrayList;

import sige.repositorio.Repositorio;
import sige.repositorio.RepositorioException;

public class Autenticacao {

	private static Pessoa pessoa;

	public static boolean AdministradorExists(Repositorio repositorio)
			throws RepositorioException {
		try {
			for (Pessoa elemento : repositorio.recuperarPessoas()) {
				if (elemento instanceof Administrador
						|| elemento instanceof ProfessorAdministrador) {
					return true;
				}
			}
			return false;
		} catch (RepositorioException e) {
			throw new RepositorioException();
		}
	}

	public static boolean logado(String user, String pass,
			Repositorio repositorio) throws RepositorioException {
		try {
			ArrayList<Pessoa> pessoas = repositorio.buscarPessoaCpf(user);
			if (!pessoas.isEmpty()) {
				pessoa = pessoas.get(0);
				return pessoa.senha.equals(pass);
			}
			return false;
		} catch (RepositorioException e) {
			throw new RepositorioException();
		}
	}
	
	public static void deslogar(){
		pessoa = null;
	}

	public static String runlevel() {
		return pessoa.getClass().getSimpleName();
	}

	public static boolean isRoot() {
		if (Autenticacao.runlevel().equals("Administrador")
				|| Autenticacao.runlevel().equals("ProfessorAdministrador")) {
			IAdministrador adm = (IAdministrador) pessoa;
			return adm.isRoot();
		}
		return false;
	}

	public static boolean isAdm() {
		if (Autenticacao.runlevel().equals("Administrador")
				|| Autenticacao.runlevel().equals("ProfessorAdministrador")) {
			return true;
		}
		return false;
	}
}
