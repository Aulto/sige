package sige.sige;

import java.util.ArrayList;

public class Atividade {

	private static int numeroAtividades = 0;

	private int idAtividade;
	private String nome;
	private int idMateria;
	ArrayList<Pergunta> perguntas;
	boolean feita;

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
		this.feita = false;
	}

	// public boolean isFeita() {
	// return feita;
	// }
	// public void responder(ArrayList<String> repostas){
	// this.repostas = repostas;
	// this.feita = true;
	// }
	//
	// public int getScore(){
	// int certas = 0;
	// for (int i = 0; i < this.repostas.size(); i++) {
	// if (this.repostas.get(i) == this.alternativas.get(i)[0]) {
	// certas++;
	// }
	// }
	// return certas;
	// }
}
