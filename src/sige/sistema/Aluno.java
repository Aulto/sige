package sige.sistema;

public class Aluno extends Pessoa {
	
	private static int alunoMatricula = 1000000;
	
	protected int matricula;
	
	public Aluno(String nome, String senha, String sexo,
			String estadoCivil, String dataNascimento, String email,
			String telefone, String celular, String rua, String bairro,
			String cidade, String uf, String complemento, String cep,
			String numero, String pais) {

		super(nome, senha, sexo, estadoCivil, dataNascimento, email, telefone,
				celular, rua, bairro, cidade, uf, complemento, cep, numero,
				pais);
		
		this.matricula = Aluno.alunoMatricula++;
	}
}