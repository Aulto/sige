package sige.sistema;

import java.util.ArrayList;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Classe Nota. Representa as notas do aluno em uma mat�ria
 * 
 */
public class Nota {

	/**
	 * Id do aluno ao qual a nota pertence
	 */
	int idAluno;
	/**
	 * Notas na mat�ria
	 */
	ArrayList<Double> notas;
	/**
	 * Id da mat�ria a qual as notas pertencem
	 */
	int idMateria;

	public Nota(int idAluno, int idMateria) {
		this.idAluno = idAluno;
		this.notas = new ArrayList<Double>();
		this.idMateria = idMateria;
	}
}
