package sige.sistema;

import java.util.ArrayList;

import sige.repositorio.Repositorio;
import sige.repositorio.RepositorioException;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 */
public interface ISige {

	/**
	 * Buscar pessoa por cpf
	 * 
	 * @param cpf
	 *            cpf a ser pesquisado
	 * @return retorna arraylist com os resultados da busca
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarCpf(String cpf) throws ProblemaInterno;

	/**
	 * Buscar pessoa por id
	 * 
	 * @param id
	 *            id a ser pesquisado
	 * @return retorna arraylist com os resultados da busca
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarId(int id) throws ProblemaInterno;

	/**
	 * Verificar se há ao menos um administrador registrado no sistema
	 * 
	 * @return retorna true caso haja ao menos um administrador registrado,
	 *         retorna false caso contrário
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	boolean autenticarSistema() throws ProblemaInterno;

	/**
	 * Adicionar aluno no sistema
	 * 
	 * @throws ProblemaInterno
	 *             lançado quando há um erro no sistema
	 */
	void adicionarAluno(int id, String nome, String cpf, String rg, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String celular, String rua,
			String bairro, String cidade, String uf, String complemento,
			String cep, String numero, String pais) throws ProblemaInterno;

	/**
	 * Adicionar professor administrador no sistema
	 * 
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	void adicionarProfessorAdm(Class<?> tipo, int id, String nome, String cpf,
			String rg, String senha, String sexo, String estadoCivil,
			String dataNascimento, String email, String telefone,
			String celular, String rua, String bairro, String cidade,
			String uf, String complemento, String cep, String numero,
			String pais) throws AutenticacaoException, ProblemaInterno;

	/**
	 * Buscar todos os administradores cadastrados no sistema
	 * 
	 * @return retorna arraylist de Pessoa com os resultados
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando ha um problema no sistema
	 */
	ArrayList<Pessoa> buscarAdm() throws AutenticacaoException, ProblemaInterno;

	/**
	 * Buscar administradores a partir do nome
	 * 
	 * @param nome
	 *            nome a ser buscado
	 * @return retorna arraylist com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarAdmNome(String nome) throws AutenticacaoException,
			ProblemaInterno;

	/**
	 * Buscar administradores a partir do cpf
	 * 
	 * @param cpf
	 *            cpf a ser buscado
	 * @return retorna arraylist com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarAdmCpf(String cpf) throws AutenticacaoException,
			ProblemaInterno;

	/**
	 * Buscar administradores a partir do id
	 * 
	 * @param id
	 *            id a ser buscado
	 * @return retorna arraylist com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarAdmId(int id) throws AutenticacaoException,
			ProblemaInterno;

	/**
	 * Buscar todos os professores cadastrados no sistema
	 * 
	 * @return retorna arraylist com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarProfessor() throws AutenticacaoException,
			ProblemaInterno;

	/**
	 * Buscar professores a partir do nome
	 * 
	 * @param nome
	 *            nome a ser buscado
	 * @return retorna arraylist de pessoa com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarProfessorNome(String nome)
			throws AutenticacaoException, ProblemaInterno;

	/**
	 * Buscar professor a partir do cpf
	 * 
	 * @param cpf
	 *            cpf a ser buscado
	 * @return retorna arraylist de pessoa com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarProfessorCpf(String cpf)
			throws AutenticacaoException, ProblemaInterno;

	/**
	 * Buscar professor a partir do id
	 * 
	 * @param id
	 *            id a ser buscado
	 * @return retorna arraylist de pessoa com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarProfessorId(int id) throws AutenticacaoException,
			ProblemaInterno;

	/**
	 * Buscar todos os alunos cadastrados no sistema
	 * 
	 * @return retorna arraylist de pessoa com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarAluno() throws AutenticacaoException,
			ProblemaInterno;

	/**
	 * Buscar aluno a partir do nome
	 * 
	 * @param nome
	 *            nome a ser buscado
	 * @return retorna arraylist de pessoa com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarAlunoNome(String nome)
			throws AutenticacaoException, ProblemaInterno;

	/**
	 * Buscar aluno a partir do cpf
	 * 
	 * @param cpf
	 *            cpf a ser buscado
	 * @return retorna arraylist de pessoa com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarAlunoCpf(String cpf) throws AutenticacaoException,
			ProblemaInterno;

	/**
	 * Buscar aluno a partir do id
	 * 
	 * @param id
	 *            id a ser buscado
	 * @return retorna arraylist de pessoa com os resultados da busca
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	ArrayList<Pessoa> buscarAlunoId(int id) throws AutenticacaoException,
			ProblemaInterno;

	/**
	 * Remover aluno do sistema
	 * 
	 * @param id
	 *            id do aluno a ser removido
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um problema no sistema
	 */
	void removerAluno(int id) throws AutenticacaoException, ProblemaInterno;

	/**
	 * Remover professor do sistema
	 * 
	 * @param id
	 *            id do professor a ser removido
	 * @throws AutenticacaoException
	 *             lançado quando o usuário que executa a ação não tem
	 *             privilégios para executá-la
	 * @throws ProblemaInterno
	 *             lançado quando há um erro no sistema
	 */
	void removerProfessor(int id) throws AutenticacaoException, ProblemaInterno;

	/**
	 * Remover administrador do sistema
	 * 
	 * @param id
	 * @throws AutenticacaoException
	 * @throws ProblemaInterno
	 */
	void removerAdm(int id) throws AutenticacaoException, ProblemaInterno;

	/**
	 * Buscar o repositório
	 * 
	 * @return retorna o Repositório instanciado na classe
	 */
	Repositorio getRepositorio();
	
	ArrayList<Materia> recuperarMateriasAluno(int id) throws ProblemaInterno;
	
	int proximoId();

	Materia buscarMateriaNome(String nome) throws ProblemaInterno;
}