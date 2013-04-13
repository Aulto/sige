package sige.repositorio;

import java.util.ArrayList;
import sige.sige.*;

public interface IRepositorio {
	
	boolean adicionar(Pessoa pessoa);
	
	boolean remover(int id);
	
	boolean atualizar(int id, Pessoa pessoa);
	
	ArrayList<Pessoa> buscarNome(String nome);
	
	ArrayList<Pessoa> buscarCpf(String cpf);
	
	ArrayList<Pessoa> buscarId(int id);
	
	ArrayList<Pessoa> buscarPessoas();
	
	ArrayList<Pessoa> buscarMatricula(int matricula);
	
	boolean adicionarMateria(Materia materia);
	
	boolean removerMateria(int id);
	
	boolean atualizarMateria(int id, Materia materia);
	
	ArrayList<Materia> buscarMateriaNome(String chave);
	
	ArrayList<Materia> buscarMateriaId(String id);
	
	ArrayList<Materia> buscarMateriaProfessor(String idProfessor);
	
	ArrayList<Materia> buscarMateria();
	
	boolean adicionarAtividade(Atividade atividade);
	
	boolean removerAtividade(int id);
	
	boolean atualizarAtividade(int id, Atividade atividade);
	
	ArrayList<Atividade> buscarAtividadeId(String id);
	
	ArrayList<Atividade> buscarAtividadeMateria(String idMateria);
		
	ArrayList<Atividade> buscarAtividade();
}
