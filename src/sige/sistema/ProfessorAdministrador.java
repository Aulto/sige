package sige.sistema;

public class ProfessorAdministrador extends Professor implements IAdministrador {

	public boolean root;
	
	public ProfessorAdministrador(String nome, String senha, String sexo,
			String estadoCivil, String dataNascimento, String email,
			String telefone, String celular, Endereço endereco) {

		super(nome, senha, sexo, estadoCivil, dataNascimento, email, telefone,
				celular, endereco);
	}

	@Override
	public boolean isRoot() {
		return root;
	}
}
