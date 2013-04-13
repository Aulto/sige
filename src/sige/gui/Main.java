package sige.gui;

public class Main{

	@SuppressWarnings("unused")
	private LoginSIGE login;
	@SuppressWarnings("unused")
	private CadastrarSIGE cadastrar;
	
	public Main(){
		this.login = new LoginSIGE();
		this.cadastrar = new CadastrarSIGE();
	}
}
