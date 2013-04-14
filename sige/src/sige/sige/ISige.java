package sige.sige;

import java.util.ArrayList;

import sige.repositorio.RepositorioException;

public interface ISige {
	
	ArrayList<Pessoa> buscarCpf(String cpf) throws RepositorioException;

	ArrayList<Pessoa> buscarId(int id);
	
	boolean autenticarSistema();

	boolean adicionarAluno(String nome, String senha, String sexo,
			String estadoCivil, String dataNascimento, String email,
			String telefone, String rua, String bairro, String cidade,
			String uf, String complemento, String cep, String numero,
			String pais);

	boolean adicionarProfessorAdm(Class<?> tipo, String nome, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String rua, String bairro,
			String cidade, String uf, String complemento, String cep,
			String numero, String pais);
	
	ArrayList<Pessoa> buscarAdm();
	
	ArrayList<Pessoa> buscarAdmNome(String nome);
	
	ArrayList<Pessoa> buscarAdmCpf(String cpf);
	
	ArrayList<Pessoa> buscarAdmId(int id);
	
	ArrayList<Pessoa> buscaProfessor();	

	ArrayList<Pessoa> buscaProfessorNome(String nome);

	ArrayList<Pessoa> buscaProfessorCpf(String cpf);

	ArrayList<Pessoa> buscaProfessorId(int id);
	
	ArrayList<Pessoa> buscaAluno();
	
	ArrayList<Pessoa> buscaAlunoNome(String nome);
	
	ArrayList<Pessoa> buscaAlunoId(int id);
	
//	ArrayList<Pessoa> buscaAlunoMatricula(int matricula);
	
	boolean removerAluno(int id);
}

