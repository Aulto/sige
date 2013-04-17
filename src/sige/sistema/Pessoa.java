package sige.sistema;

public abstract class Pessoa {

	private static int numeroPessoa = 0;

	public final int idPessoa;

	protected String nome;
	protected String cpf;
	protected String senha;
	protected String rg;
	protected String sexo;
	protected String estadoCivil;
	protected String dataNascimento;
	protected String email;
	protected String telefone;
	protected String celular;
	protected Endere�o endere�o;

	public Pessoa(String nome, String cpf, String rg, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String celular, Endere�o endereco) {

		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.senha = senha;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.endere�o = endereco;
		this.idPessoa = Pessoa.numeroPessoa++;
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

	public Endere�o getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(Endere�o endere�o) {
		this.endere�o = endere�o;
	}

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