package sige.sige;

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

	@Override
	public String toString() {
		return this.rua + "|" + this.bairro + "|" + this.cidade + "|" + this.uf
				+ "|" + this.complemento + "|" + this.cep + "|" + this.numero
				+ "|" + this.pais;
	}
}
