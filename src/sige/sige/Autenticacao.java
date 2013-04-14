package sige.sige;

import java.util.ArrayList;

import sige.repositorio.Repositorio;
import sige.repositorio.RepositorioException;

public class Autenticacao {

	private static Pessoa pessoa;
	private static Repositorio repo = new Repositorio("jdbc:mysql://localhost:3306/sige", "root", "");
	
	public static boolean AdministradorExists(Repositorio repositorio) {
		for (Pessoa elemento : repositorio.recuperarPessoas()) {
			if (elemento instanceof Administrador
					|| elemento instanceof ProfessorAdministrador) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean logado(String user, String pass){
		ArrayList<Pessoa> pessoas = repo.buscarPessoaCpf(user);
		if(!pessoas.isEmpty()){
			pessoa = pessoas.get(0);
			return pessoa.senha.equals(pass);
		}
		return false;
	}
	
	public static String runlevel(){
		return pessoa.getClass().getSimpleName();
	}
}
