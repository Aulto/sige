package sige.sige;

public class ProfessorAdministrador extends Professor implements IAdministrador {

	public ProfessorAdministrador(String nome, String senha, String sexo, String estadoCivil,
			String dataNascimento, String email, String telefone, String rua,
			String bairro, String cidade, String uf, String complemento,
			String cep, String numero, String pais) {
		
		super(nome, senha, sexo, estadoCivil, dataNascimento, email, telefone,
				rua, bairro, cidade, uf, complemento, cep, numero, pais);
	}
}
