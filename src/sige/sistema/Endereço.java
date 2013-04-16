package sige.sistema;

public class Endereço {

	protected String rua;
	protected String bairro;
	protected String cidade;
	protected String uf;
	protected String complemento;
	protected String cep;
	protected String numero;
	protected String pais;

	public Endereço(String rua, String bairro, String cidade, String uf,
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

	public static Endereço getEndereço(String strEndereço) {
		String[] endereçoArr = strEndereço.split("\\|");
		return new Endereço(endereçoArr[0], endereçoArr[1], endereçoArr[2],
				endereçoArr[3], endereçoArr[4], endereçoArr[5], endereçoArr[6],
				endereçoArr[7]);
	}
}
