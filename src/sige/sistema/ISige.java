package sige.sistema;

import java.util.ArrayList;

import sige.repositorio.Repositorio;
import sige.repositorio.RepositorioException;

public interface ISige {

	/**
	 * Buscar pessoas pelo cpf
	 * @param cpf
	 * 		cpf para buscar
	 * @return
	 * 		retorna arraylist com todos os resultados da busca
	 * @throws ProblemaInterno
	 * 		lançado quando ocorre algum problema no sistema
	 */
	ArrayList<Pessoa> buscarCpf(String cpf) throws ProblemaInterno;

	/**
	 * Buscar pessoas pelo id
	 * @param id
	 * 		id a ser buscado
	 * @return
	 * 		retorna arraylist com os resultados da busca
	 * @throws ProblemaInterno
	 * 		lançado quando ocorre algum problema no sistema
	 */
	ArrayList<Pessoa> buscarId(int id) throws ProblemaInterno;

	/**
	 * Verificar se há um administrador no sistema
	 * @return
	 * 		retorna true caso haja um, false caso contrário
	 * @throws RepositorioException
	 * 		lançado quando há problemas na conexão com o repositório
	 */
	boolean autenticarSistema() throws RepositorioException;

	/**
	 * Adicionar Aluno no repositório
	 * @throws ProblemaInterno
	 * 		lançado quando ocorre algum problema no sistema
	 */
	void adicionarAluno(String nome, String cpf, String rg, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String celular, String rua,
			String bairro, String cidade, String uf, String complemento,
			String cep, String numero, String pais) throws ProblemaInterno;

	/**
	 * Adicionar ProfessorAdministrador no repositório
	 * @throws AutenticacaoException
	 * @throws ProblemaInterno
	 * 		lançado quando há problemas na conexão com o repositório
	 */
	void adicionarProfessorAdm(Class<?> tipo, String nome, String cpf,
			String rg, String senha, String sexo, String estadoCivil,
			String dataNascimento, String email, String telefone,
			String celular, String rua, String bairro, String cidade,
			String uf, String complemento, String cep, String numero,
			String pais) throws AutenticacaoException, ProblemaInterno;

	/**
	 * Buscar os administradores registrados no sistema
	 * @return
	 * 		retorna uma arraylist de pessoas com todos os administradores cadastrados
	 * @throws AutenticacaoException
	 * @throws ProblemaInterno
	 * 		lançado quando há problemas na conexão com o repositório
	 */
	ArrayList<Pessoa> buscaAdm() throws AutenticacaoException, ProblemaInterno;

	/**
	 * Buscar administrador por nome
	 * @param nome
	 * 		nome a ser buscado
	 * @return
	 * 		retorna os resultados da busca em forma de arraylist
	 * @throws AutenticacaoException
	 * @throws ProblemaInterno
	 * 		lançado quando ocorre algum problema no sistema
	 */
	ArrayList<Pessoa> buscaAdmNome(String nome) throws AutenticacaoException,
			ProblemaInterno;

	/**
	 * Buscar administrador a partir do cpf
	 * @param cpf
	 * @return
	 * @throws AutenticacaoException
	 * @throws ProblemaInterno
	 */
	ArrayList<Pessoa> buscaAdmCpf(String cpf) throws AutenticacaoException,
			ProblemaInterno;

	ArrayList<Pessoa> buscaAdmId(int id) throws AutenticacaoException,
			ProblemaInterno;

	ArrayList<Pessoa> buscaProfessor() throws AutenticacaoException,
			ProblemaInterno;

	ArrayList<Pessoa> buscaProfessorNome(String nome)
			throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscaProfessorCpf(String cpf)
			throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscaProfessorId(int id) throws AutenticacaoException,
			ProblemaInterno;

	ArrayList<Pessoa> buscaAluno() throws AutenticacaoException,
			ProblemaInterno;

	ArrayList<Pessoa> buscaAlunoNome(String nome) throws AutenticacaoException,
			ProblemaInterno;

	ArrayList<Pessoa> buscaAlunoId(int id) throws AutenticacaoException,
			ProblemaInterno;

	void removerAluno(int id) throws AutenticacaoException, ProblemaInterno;

	void removerProfessor(int id) throws AutenticacaoException, ProblemaInterno;

	void removerAdm(int id) throws AutenticacaoException, ProblemaInterno;

	Repositorio getRepositorio();
}
