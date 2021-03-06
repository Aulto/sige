package sige.sistema;

/**
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Endere�o: classe com atributos do endere�o
 * 
 */
public class Endereco {

	/**
	 * Rua, logradouro
	 */
	protected String rua;
	/**
	 * Bairro
	 */
	protected String bairro;
	/**
	 * Cidade
	 */
	protected String cidade;
	/**
	 * Unidade Federativa
	 */
	protected String uf;
	/**
	 * Complemento do endere�o
	 */
	protected String complemento;
	/**
	 * CEP da rua
	 */
	protected String cep;
	/**
	 * N�mero da resid�ncia
	 */
	protected String numero;
	/**
	 * Pa�s
	 */
	protected String pais;

	public Endereco(String rua, String bairro, String cidade, String uf,
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Retornar o endere�o em forma de String, delimitado por |
	 */
	@Override
	public String toString() {
		return this.rua + "|" + this.bairro + "|" + this.cidade + "|" + this.uf
				+ "|" + this.complemento + "|" + this.cep + "|" + this.numero
				+ "|" + this.pais;
	}

	/**
	 * M�todo est�tico para criar uma inst�ncia de Endereco a partir de uma
	 * String (delimitada por |)
	 * 
	 * @param strEndere�o
	 *            endere�o serializado com |
	 * @return retorna objeto do tipo Endereco
	 */
	public static Endereco getEndere�o(String strEndere�o) {
		String[] endere�oArr = strEndere�o.split("\\|");
		if (endere�oArr.length == 8) {
			return new Endereco(endere�oArr[0], endere�oArr[1], endere�oArr[2],
					endere�oArr[3], endere�oArr[4], endere�oArr[5],
					endere�oArr[6], endere�oArr[7]);
		} else {
			return null;
		}
	}
}
