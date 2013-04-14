package sige.repositorio;

import java.util.ArrayList;
import sige.sige.*;

public interface IRepositorio {
	
	//m�todos para gerenciar pessoas (Alunos, profs, adms, admprofs)
	boolean adicionarPessoa(Pessoa pessoa);
	
	boolean removerPessoa(int id);
	
	boolean atualizarPessoa(int id, Pessoa pessoa);
	
	//m�todos para buscar pessoas
	ArrayList<Pessoa> recuperarPessoas();
	
	ArrayList<Pessoa> buscarPessoaId(int id);
	
	ArrayList<Pessoa> buscarPessoaNome(String nome);
	
	ArrayList<Pessoa> buscarPessoaCpf(String cpf);
	
	//m�todos para gerenciar mat�rias
	boolean adicionarMateria(Materia materia);
	
	boolean removerMateria(int id);
	
	boolean atualizarMateria(int id, Materia materia);
	
	//m�todos para buscar mat�rias
	ArrayList<Materia> recuperarMaterias();
	
	ArrayList<Materia> buscarMateriaId(int id);
	
	ArrayList<Materia> buscarMateriaNome(String nome);
	
	//m�todos para gerenciar atividades
	boolean adicionarAtividade(Atividade atividade);
	
	boolean removerAtividade(int id);
	
	boolean atualizarAtividade(int id, Atividade atividade);
	
	//m�todos para buscar atividades
	ArrayList<Atividade> recuperarAtividades();
	
	ArrayList<Atividade> buscarAtividadeId(int id);
}
