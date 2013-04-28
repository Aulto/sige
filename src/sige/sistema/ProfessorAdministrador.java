package sige.sistema;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 * Professor e Administrador do sistema
 *
 */
public class ProfessorAdministrador extends Professor implements IAdministrador {

	/**
	 * Root
	 */
	public boolean root;

	public ProfessorAdministrador(int id, String nome, String cpf, String rg,
			String senha, String sexo, String estadoCivil,
			String dataNascimento, String email, String telefone,
			String celular, Endereco endereco) {

		super(id, nome, cpf, rg, senha, sexo, estadoCivil, dataNascimento, email,
				telefone, celular, endereco);
	}

	@Override
	public boolean isRoot() {
		return root;
	}
}
