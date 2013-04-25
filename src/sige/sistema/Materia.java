package sige.sistema;

import java.util.ArrayList;

/**
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Classe que representa uma mat�ria lecionada por um professor
 * 
 */
public class Materia {

	/**
	 * N�mero de mat�rias instanciadas
	 */
	private static int numeroMaterias = 0;

	/**
	 * Id que representa a mat�ria
	 */
	private final int idMateria;

	/**
	 * Nome da mat�ria
	 */
	private String nome;
	/**
	 * Id do professor que leciona a mat�ria
	 */
	private int idProfessor;
	/**
	 * Notas dos alunos na mat�ria
	 */
	private ArrayList<Nota> notas;
	/**
	 * Atividades da mat�ria
	 */
	private ArrayList<Atividade> atividades;

	/**
	 * Id dos alunos cuja aprova��o (de ingresso) est� pendente na mat�ria
	 */
	private ArrayList<Integer> idAlunosPendentes;
	/**
	 * Id dos alunos cujo ingresso na mat�ria j� foi aprovado por um professor
	 */
	private ArrayList<Integer> idAluno;

	public Materia(String nome, int idProfessor) {
		this.setNome(nome);
		this.setIdProfessor(idProfessor);
		this.idMateria = Materia.numeroMaterias++;
		this.notas = new ArrayList<Nota>();
		this.atividades = new ArrayList<Atividade>();
		this.idAlunosPendentes = new ArrayList<Integer>();
		this.idAluno = new ArrayList<Integer>();
	}

	/**
	 * Adicionar aluno na mat�ria
	 * 
	 * @param id
	 *            id do aluno a ser adicionado
	 */
	public void adicionarAluno(int id) {
		this.idAlunosPendentes.add(id);
	}

	public int getIdMateria() {
		return idMateria;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}

	public ArrayList<Integer> getIdAlunosPendentes() {
		return idAlunosPendentes;
	}

	public ArrayList<Integer> getIdAluno() {
		return idAluno;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
