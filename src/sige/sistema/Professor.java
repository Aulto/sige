package sige.sistema;

import java.util.ArrayList;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Professor
 * 
 */
public class Professor extends Pessoa {

	/**
	 * Ids das mat�rias as quais o professor leciona
	 */
	ArrayList<Integer> idMaterias;

	public Professor(int id, String nome, String cpf, String rg, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String celular, Endereco endereco) {

		super(id, nome, cpf, rg, senha, sexo, estadoCivil, dataNascimento, email,
				telefone, celular, endereco);

		this.idMaterias = new ArrayList<>();
	}

	/**
	 * Adicionar mat�ria (id) � lista de mat�rias que o professor leciona
	 */
	public void adicionarMateria(Materia materia) {
		this.idMaterias.add(materia.getIdMateria());
	}
}
