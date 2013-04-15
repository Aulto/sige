package sige.sistema;

import java.util.ArrayList;

public class Professor extends Pessoa {
	
	ArrayList<Integer> idMaterias;
	
	public Professor(String nome, String senha, String sexo,
			String estadoCivil, String dataNascimento, String email,
			String telefone, String celular, String rua, String bairro,
			String cidade, String uf, String complemento, String cep,
			String numero, String pais) {

		super(nome, senha, sexo, estadoCivil, dataNascimento, email, telefone,
				celular, rua, bairro, cidade, uf, complemento, cep, numero,
				pais);
		
		this.idMaterias = new ArrayList<>();
	}
	
	public void adicionarMateria(Materia materia){
		this.idMaterias.add(materia.getIdMateria()); 
	}
}
