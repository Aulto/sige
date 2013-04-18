package sige.sistema;

import java.util.ArrayList;

import sige.repositorio.Repositorio;
import sige.repositorio.RepositorioException;

public class Autenticacao {

	private static Pessoa pessoa;

	/**
	 * Verificar se existe ao menos um administrador no sistema
	 * 
	 * @param repositorio
	 *            Repositorio que ser� utilizado para fazer a busca
	 * @return retorna true caso haja ao menos um administrador, false caso
	 *         contr�rio
	 * @throws RepositorioException
	 *             lan�ado quando h� um problema no reposit�rio
	 */
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

	/**
	 * Fazer login no sistema com as informa��es fornecidas
	 * 
	 * @param user
	 *            login do usu�rio (cpf)
	 * @param pass
	 *            senha do usu�rio
	 * @param repositorio
	 *            Repositorio utilizado para fazer a consulta
	 * @return retorna true caso haja um usu�rio cadastrado no sistema com este
	 *         login e senha
	 * @throws RepositorioException
	 *             lan�ado quando h� um erro no reposit�rio
	 */
	public static boolean login(String user, String pass,
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

	/**
	 * Deslogar usu�rio
	 */
	public static void deslogar() {
		pessoa = null;
	}

	/**
	 * Recuperar o n�vel de acesso e privil�gios do usu�rio logado
	 * 
	 * @return retorna uma String com o tipo de usu�rio logad (Aluno, Professor,
	 *         Administrador ou ProfessorAdministrador
	 */
	public static String runlevel() {
		return pessoa.getClass().getSimpleName();
	}

	/**
	 * Verificar se o usu�rio logado � o root (principal administrador)
	 * 
	 * @return retorna true caso seja root, false caso contr�rio
	 */
	public static boolean isRoot() {
		if (Autenticacao.runlevel().equals("Administrador")
				|| Autenticacao.runlevel().equals("ProfessorAdministrador")) {
			IAdministrador adm = (IAdministrador) pessoa;
			return adm.isRoot();
		}
		return false;
	}

	/**
	 * Verificar se o usu�rio logado � um administrador
	 * 
	 * @return retorna true caso seja administrador, false caso contr�rio
	 */
	public static boolean isAdm() {
		if (Autenticacao.runlevel().equals("Administrador")
				|| Autenticacao.runlevel().equals("ProfessorAdministrador")) {
			return true;
		}
		return false;
	}
}
