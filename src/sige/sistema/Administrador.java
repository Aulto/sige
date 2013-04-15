package sige.sistema;

public class Administrador extends Pessoa implements IAdministrador {

	public boolean root;

	public Administrador(String nome, String senha, String sexo,
			String estadoCivil, String dataNascimento, String email,
			String telefone, String celular, String rua, String bairro,
			String cidade, String uf, String complemento, String cep,
			String numero, String pais) {

		super(nome, senha, sexo, estadoCivil, dataNascimento, email, telefone,
				celular, rua, bairro, cidade, uf, complemento, cep, numero,
				pais);
	}

	@Override
	public boolean isRoot() {
		return root;
	}

}