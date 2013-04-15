package sige.sistema;

import java.util.ArrayList;

public class Atividade {

	private static int numeroAtividades = 0;

	private int idAtividade;
	private String nome;
	private int idMateria;
	ArrayList<Pergunta> perguntas;

	public int getIdAtividade() {
		return idAtividade;
	}

	public String getNome() {
		return nome;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public ArrayList<Pergunta> getPerguntas() {
		return this.perguntas;
	}

	public Atividade(String nome, int idMateria, ArrayList<Pergunta> perguntas) {
		this.idAtividade = Atividade.numeroAtividades++;
		this.idMateria = idMateria;
		this.perguntas = perguntas;
	}
}
