package sige.repositorio;

import java.util.ArrayList;

import sige.sistema.*;

public interface IRepositorio {
	
	//métodos para gerenciar pessoas (Alunos, profs, adms, admprofs)
	void adicionarPessoa(Pessoa pessoa) throws RepositorioException;
	
	void removerPessoa(int id) throws RepositorioException;
	
	void atualizarPessoa(int id, Pessoa pessoa) throws RepositorioException;
	
	//métodos para buscar pessoas
	ArrayList<Pessoa> recuperarPessoas() throws RepositorioException;
	
	ArrayList<Pessoa> buscarPessoaId(int id) throws RepositorioException;
	
	ArrayList<Pessoa> buscarPessoaNome(String nome) throws RepositorioException;
	
	ArrayList<Pessoa> buscarPessoaCpf(String cpf) throws RepositorioException;
	
	//métodos para gerenciar matérias
	void adicionarMateria(Materia materia) throws RepositorioException;
	
	void removerMateria(int id) throws RepositorioException;
	
	void atualizarMateria(int id, Materia materia) throws RepositorioException;
	
	//métodos para buscar matérias
	ArrayList<Materia> recuperarMaterias() throws RepositorioException;
	
	ArrayList<Materia> buscarMateriaId(int id) throws RepositorioException;
	
	ArrayList<Materia> buscarMateriaNome(String nome) throws RepositorioException;
	
	//métodos para gerenciar atividades
	void adicionarAtividade(Atividade atividade) throws RepositorioException;
	
	void removerAtividade(int id) throws RepositorioException;
	
	void atualizarAtividade(int id, Atividade atividade) throws RepositorioException;
	
	//métodos para buscar atividades
	ArrayList<Atividade> recuperarAtividades() throws RepositorioException;
	
	ArrayList<Atividade> buscarAtividadeId(int id) throws RepositorioException;
}
