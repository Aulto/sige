package sige.sistema;

/**
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Aluno: usuário com o nível mais baixo no sistema
 */
public class Aluno extends Pessoa {

	private static int alunoMatricula = 1000000;

	protected int matricula;

	public Aluno(String nome, String cpf, String rg, String senha, String sexo,
			String estadoCivil, String dataNascimento, String email,
			String telefone, String celular, Endereco endereco) {

		super(nome, cpf, rg, senha, sexo, estadoCivil, dataNascimento, email,
				telefone, celular, endereco);

		this.matricula = Aluno.alunoMatricula++;
	}
}