package sige.repositorio;

import java.util.ArrayList;

import sige.sistema.*;

public interface IRepositorio {
	
	//m�todos para gerenciar pessoas (Alunos, profs, adms, admprofs)
	void adicionarPessoa(Pessoa pessoa) throws RepositorioException;
	
	void removerPessoa(int id) throws RepositorioException;
	
	void atualizarPessoa(int id, Pessoa pessoa) throws RepositorioException;
	
	//m�todos para buscar pessoas
	ArrayList<Pessoa> recuperarPessoas() throws RepositorioException;
	
	ArrayList<Pessoa> buscarPessoaId(int id) throws RepositorioException;
	
	ArrayList<Pessoa> buscarPessoaNome(String nome) throws RepositorioException;
	
	ArrayList<Pessoa> buscarPessoaCpf(String cpf) throws RepositorioException;
	
	//m�todos para gerenciar mat�rias
	void adicionarMateria(Materia materia) throws RepositorioException;
	
	void removerMateria(int id) throws RepositorioException;
	
	void atualizarMateria(int id, Materia materia) throws RepositorioException;
	
	//m�todos para buscar mat�rias
	ArrayList<Materia> recuperarMaterias() throws RepositorioException;
	
	ArrayList<Materia> buscarMateriaId(int id) throws RepositorioException;
	
	ArrayList<Materia> buscarMateriaNome(String nome) throws RepositorioException;
	
	//m�todos para gerenciar atividades
	void adicionarAtividade(Atividade atividade) throws RepositorioException;
	
	void removerAtividade(int id) throws RepositorioException;
	
	void atualizarAtividade(int id, Atividade atividade) throws RepositorioException;
	
	//m�todos para buscar atividades
	ArrayList<Atividade> recuperarAtividades() throws RepositorioException;
	
	ArrayList<Atividade> buscarAtividadeId(int id) throws RepositorioException;
}
