package sige.sistema;

import java.util.ArrayList;

/**
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Atividade representa as atividades propostas pelo professor
 * 
 */
public class Atividade {
	/**
	 * Guarda o número de atividades instanciadas
	 */
	private static int numeroAtividades = 0;
	/**
	 * Id da atividade
	 */
	private int idAtividade;
	/**
	 * Nome da atividade
	 */
	private String nome;
	/**
	 * id da matéria a qual a atividade pertence
	 */
	private int idMateria;
	/**
	 * Questões da atividade
	 */
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
