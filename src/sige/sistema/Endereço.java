package sige.sistema;

public class Endere�o {

	protected String rua;
	protected String bairro;
	protected String cidade;
	protected String uf;
	protected String complemento;
	protected String cep;
	protected String numero;
	protected String pais;

	public Endere�o(String rua, String bairro, String cidade, String uf,
			String complemento, String cep, String numero, String pais) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
		this.cep = cep;
		this.numero = numero;
		this.pais = pais;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return this.rua + "|" + this.bairro + "|" + this.cidade + "|" + this.uf
				+ "|" + this.complemento + "|" + this.cep + "|" + this.numero
				+ "|" + this.pais;
	}

	public static Endere�o getEndere�o(String strEndere�o) {
		String[] endere�oArr = strEndere�o.split("\\|");
		return new Endere�o(endere�oArr[0], endere�oArr[1], endere�oArr[2],
				endere�oArr[3], endere�oArr[4], endere�oArr[5], endere�oArr[6],
				endere�oArr[7]);
	}
}
