package sige.sistema;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Classe abstrata que representa a pessoa
 * 
 */
public abstract class Pessoa {

	/**
	 * Contador de inst�ncias
	 */
	private static int numeroPessoa = 0;

	/**
	 * Id da pessoa
	 */
	public final int idPessoa;

	/**
	 * Nome
	 */
	protected String nome;
	/**
	 * CPF
	 */
	protected String cpf;
	/**
	 * Senha
	 */
	protected String senha;
	/**
	 * Registro Geral
	 */
	protected String rg;
	/**
	 * Sexo
	 */
	protected String sexo;
	/**
	 * Estado Civil
	 */
	protected String estadoCivil;
	/**
	 * Data de nascimento
	 */
	protected String dataNascimento;
	/**
	 * Email de registro
	 */
	protected String email;
	/**
	 * N�mero de telefone
	 */
	protected String telefone;
	/**
	 * N�mero de celular
	 */
	protected String celular;
	/**
	 * Endere�o
	 */
	protected Endereco endere�o;

	public Pessoa(int id, String nome, String cpf, String rg, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String celular, Endereco endereco) {
		this.idPessoa = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.senha = senha;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.endere�o = endereco;
//		this.idPessoa = Pessoa.numeroPessoa++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Endereco getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(Endereco endere�o) {
		this.endere�o = endere�o;
	}

	/**
	 * Definir endere�o a partir de um Endere�o serializado em String
	 * 
	 * @param endere�o
	 *            endere�o em forma de string
	 */
	public void setEndere�o(String endere�o) {
		String[] endere�oArr = endere�o.split("\\|");
		this.endere�o.setRua(endere�oArr[0]);
		this.endere�o.setBairro(endere�oArr[1]);
		this.endere�o.setCidade(endere�oArr[2]);
		this.endere�o.setUf(endere�oArr[3]);
		this.endere�o.setComplemento(endere�oArr[4]);
		this.endere�o.setCep(endere�oArr[5]);
		this.endere�o.setNumero(endere�oArr[6]);
		this.endere�o.setPais(endere�oArr[7]);
	}

	public int getIdPessoa() {
		return idPessoa;
	}
}