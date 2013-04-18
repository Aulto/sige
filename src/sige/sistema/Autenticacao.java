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
	 *            Repositorio que será utilizado para fazer a busca
	 * @return retorna true caso haja ao menos um administrador, false caso
	 *         contrário
	 * @throws RepositorioException
	 *             lançado quando há um problema no repositório
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
	 * Fazer login no sistema com as informações fornecidas
	 * 
	 * @param user
	 *            login do usuário (cpf)
	 * @param pass
	 *            senha do usuário
	 * @param repositorio
	 *            Repositorio utilizado para fazer a consulta
	 * @return retorna true caso haja um usuário cadastrado no sistema com este
	 *         login e senha
	 * @throws RepositorioException
	 *             lançado quando há um erro no repositório
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
	 * Deslogar usuário
	 */
	public static void deslogar() {
		pessoa = null;
	}

	/**
	 * Recuperar o nível de acesso e privilégios do usuário logado
	 * 
	 * @return retorna uma String com o tipo de usuário logad (Aluno, Professor,
	 *         Administrador ou ProfessorAdministrador
	 */
	public static String runlevel() {
		return pessoa.getClass().getSimpleName();
	}

	/**
	 * Verificar se o usuário logado é o root (principal administrador)
	 * 
	 * @return retorna true caso seja root, false caso contrário
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
	 * Verificar se o usuário logado é um administrador
	 * 
	 * @return retorna true caso seja administrador, false caso contrário
	 */
	public static boolean isAdm() {
		if (Autenticacao.runlevel().equals("Administrador")
				|| Autenticacao.runlevel().equals("ProfessorAdministrador")) {
			return true;
		}
		return false;
	}
}
