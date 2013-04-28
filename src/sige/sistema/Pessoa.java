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
	 * Contador de instâncias
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
	 * Número de telefone
	 */
	protected String telefone;
	/**
	 * Número de celular
	 */
	protected String celular;
	/**
	 * Endereço
	 */
	protected Endereco endereço;

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
		this.endereço = endereco;
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

	public Endereco getEndereço() {
		return endereço;
	}

	public void setEndereço(Endereco endereço) {
		this.endereço = endereço;
	}

	/**
	 * Definir endereço a partir de um Endereço serializado em String
	 * 
	 * @param endereço
	 *            endereço em forma de string
	 */
	public void setEndereço(String endereço) {
		String[] endereçoArr = endereço.split("\\|");
		this.endereço.setRua(endereçoArr[0]);
		this.endereço.setBairro(endereçoArr[1]);
		this.endereço.setCidade(endereçoArr[2]);
		this.endereço.setUf(endereçoArr[3]);
		this.endereço.setComplemento(endereçoArr[4]);
		this.endereço.setCep(endereçoArr[5]);
		this.endereço.setNumero(endereçoArr[6]);
		this.endereço.setPais(endereçoArr[7]);
	}

	public int getIdPessoa() {
		return idPessoa;
	}
}