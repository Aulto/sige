package sige.sige;

import java.util.ArrayList;

public class Materia {
	
	private static int numeroMaterias = 0;
	
	private final int idMaterias;
	private String nome;
	private int idProfessor;
	private ArrayList<Nota> notas;
	private ArrayList<Atividade> atividades;
	private ArrayList<Integer> idAlunosPendentes;
	private ArrayList<Integer> idAluno;
	
	public Materia(String nome, int idProfessor){
		this.setNome(nome);
		this.setIdProfessor(idProfessor);
		this.idMaterias= Materia.numeroMaterias++;
		this.notas = new ArrayList<Nota>();
		this.atividades = new ArrayList<Atividade>();
		this.idAlunosPendentes = new ArrayList<Integer>();
		this.idAluno = new ArrayList<Integer>();
	}
	
	public void adicionarAluno(int id){
		this.idAlunosPendentes.add(id);
	}
	
	public boolean buscarAlunosPendentes(int id){
		boolean resutado = false;
		for (Integer elemento : this.idAlunosPendentes) {
			if (elemento == id) {
				resutado = true;
				break;
			}
		}
		return resutado;
	}		

	public int getIdMaterias() {
		return idMaterias;
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
