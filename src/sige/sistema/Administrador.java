package sige.sistema;

public class Administrador extends Pessoa implements IAdministrador {

	public boolean root;

	public Administrador(String nome, String cpf, String rg, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String celular, Endereco endereco) {

		super(nome, cpf, rg, senha, sexo, estadoCivil, dataNascimento, email,
				telefone, celular, endereco);
	}

	@Override
	public boolean isRoot() {
		return root;
	}

}