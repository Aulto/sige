package sige.sistema;

import java.util.ArrayList;

public class Professor extends Pessoa {

	ArrayList<Integer> idMaterias;

	public Professor(String nome, String cpf, String rg, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String celular, Endereço endereco) {

		super(nome, cpf, rg, senha, sexo, estadoCivil, dataNascimento, email,
				telefone, celular, endereco);

		this.idMaterias = new ArrayList<>();
	}

	public void adicionarMateria(Materia materia) {
		this.idMaterias.add(materia.getIdMateria());
	}
}
