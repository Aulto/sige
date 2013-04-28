package sige.sistema;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Administrador do sistema: responsável pelo gerenciamento dos alunos e
 *         professores
 */
public class Administrador extends Pessoa implements IAdministrador {

	public boolean root;

	public Administrador(int id, String nome, String cpf, String rg, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String celular, Endereco endereco) {

		super(id, nome, cpf, rg, senha, sexo, estadoCivil, dataNascimento, email,
				telefone, celular, endereco);
	}

	@Override
	public boolean isRoot() {
		return root;
	}

}