package sige.sistema;

import java.util.ArrayList;

import sige.repositorio.Repositorio;
import sige.repositorio.RepositorioException;

public interface ISige {

	ArrayList<Pessoa> buscarCpf(String cpf) throws ProblemaInterno;

	ArrayList<Pessoa> buscarId(int id) throws ProblemaInterno;

	boolean autenticarSistema() throws RepositorioException;

	void adicionarAluno(String nome, String senha, String sexo,
			String estadoCivil, String dataNascimento, String email,
			String telefone, String celular, String rua, String bairro,
			String cidade, String uf, String complemento, String cep,
			String numero, String pais) throws ProblemaInterno;

	void adicionarProfessorAdm(Class<?> tipo, String nome, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String celular, String rua,
			String bairro, String cidade, String uf, String complemento,
			String cep, String numero, String pais)
			throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscarAdm() throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscarAdmNome(String nome) throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscarAdmCpf(String cpf) throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscarAdmId(int id) throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscaProfessor() throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscaProfessorNome(String nome) throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscaProfessorCpf(String cpf) throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscaProfessorId(int id) throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscaAluno() throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscaAlunoNome(String nome) throws AutenticacaoException, ProblemaInterno;

	ArrayList<Pessoa> buscaAlunoId(int id) throws AutenticacaoException, ProblemaInterno;

	void removerAluno(int id) throws AutenticacaoException, ProblemaInterno;

	void removerProfessor(int id) throws AutenticacaoException, ProblemaInterno;
	
	void removerAdm(int id) throws AutenticacaoException, ProblemaInterno;
	
	Repositorio getRepositorio();
}
