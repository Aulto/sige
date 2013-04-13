package sige.sige;

import java.util.ArrayList;

import sige.repositorio.*;

public class Sige implements ISige {

	private Repositorio repositorio;

	public Sige() {
		this.repositorio = new Repositorio("jdbc:mysql://localhost:3306/sige",
				"root", "");
	}

	@Override
	public ArrayList<Pessoa> buscarCpf(String cpf) {
		return repositorio.buscarCpf(cpf);
	}
	
	public boolean autenticarSistema(){
		return Autenticacao.AdministradorExists(this.repositorio);
	}

	@Override
	public ArrayList<Pessoa> buscarId(int id) {
		return repositorio.buscarId(id);
	}

	@Override
	public boolean adicionarAluno(String nome, String senha, String sexo,
			String estadoCivil, String dataNascimento, String email,
			String telefone, String rua, String bairro, String cidade,
			String uf, String complemento, String cep, String numero,
			String pais) {
		Aluno aluno = new Aluno(nome, senha, sexo, estadoCivil, dataNascimento,
				email, telefone, rua, bairro, cidade, uf, complemento, cep,
				numero, pais);
		return repositorio.adicionar(aluno);
	}

	@Override
	public boolean adicionarProfessorAdm(Class<?> tipo, String nome, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String rua, String bairro,
			String cidade, String uf, String complemento, String cep,
			String numero, String pais) {
		if (Autenticacao.runlevel().equals("Aluno") || Autenticacao.runlevel().equals("Professor")) {
			return false;
		}
		Pessoa pessoa = null;
		if (tipo == Professor.class){
			pessoa = new Professor(nome, senha, sexo, estadoCivil,
					dataNascimento, email, telefone, rua, bairro, cidade, uf,
					complemento, cep, numero, pais);
		} else if (tipo == Administrador.class) {
			pessoa = new Administrador(nome, senha, sexo, estadoCivil,
					dataNascimento, email, telefone, rua, bairro, cidade, uf,
					complemento, cep, numero, pais);
		} else if (tipo == ProfessorAdministrador.class) {
			pessoa = new ProfessorAdministrador(nome, senha, sexo, estadoCivil,
					dataNascimento, email, telefone, rua, bairro, cidade, uf,
					complemento, cep, numero, pais);
		}
		if (pessoa != null) {
			repositorio.adicionar(pessoa);
		}
		return true;
	}

	@Override
	public ArrayList<Pessoa> buscarAdm() {
		if (Autenticacao.runlevel().equals("Aluno") || Autenticacao.runlevel().equals("Professor")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarPessoas()) {
			if (elemento instanceof Administrador || elemento instanceof ProfessorAdministrador) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}
	
	@Override
	public ArrayList<Pessoa> buscarAdmNome(String nome) {
		if (Autenticacao.runlevel().equals("Aluno") || Autenticacao.runlevel().equals("Professor")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarNome(nome)) {
			if (elemento instanceof Administrador || elemento instanceof ProfessorAdministrador) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}

	@Override
	public ArrayList<Pessoa> buscarAdmCpf(String cpf) {
		if (Autenticacao.runlevel().equals("Aluno") || Autenticacao.runlevel().equals("Professor")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarCpf(cpf)) {
			if (elemento instanceof Administrador || elemento instanceof ProfessorAdministrador) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}
	
	@Override
	public ArrayList<Pessoa> buscarAdmId(int id) {
		if (Autenticacao.runlevel().equals("Aluno") || Autenticacao.runlevel().equals("Professor")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarId(id)) {
			if (elemento instanceof Administrador || elemento instanceof ProfessorAdministrador) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}

	@Override
	public ArrayList<Pessoa> buscaProfessor() {
		if (Autenticacao.runlevel().equals("Aluno") || Autenticacao.runlevel().equals("Professor")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarPessoas()) {
			if (elemento instanceof Professor || elemento instanceof ProfessorAdministrador) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}
	
	@Override
	public ArrayList<Pessoa> buscaProfessorNome(String nome) {
		if (Autenticacao.runlevel().equals("Aluno") || Autenticacao.runlevel().equals("Professor")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarNome(nome)) {
			if (elemento instanceof Professor || elemento instanceof ProfessorAdministrador) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}

	@Override
	public ArrayList<Pessoa> buscaProfessorCpf(String cpf) {
		if (Autenticacao.runlevel().equals("Aluno") || Autenticacao.runlevel().equals("Professor")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarCpf(cpf)) {
			if (elemento instanceof Professor || elemento instanceof ProfessorAdministrador) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}
	
	@Override
	public ArrayList<Pessoa> buscaProfessorId(int id) {
		if (Autenticacao.runlevel().equals("Aluno") || Autenticacao.runlevel().equals("Professor")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarId(id)) {
			if (elemento instanceof Professor || elemento instanceof ProfessorAdministrador) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}
	
	@Override
	public ArrayList<Pessoa> buscaAluno() {
		if (Autenticacao.runlevel().equals("Aluno")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarPessoas()) {
			if (elemento instanceof Aluno) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}

	@Override
	public ArrayList<Pessoa> buscaAlunoNome(String nome) {
		if (Autenticacao.runlevel().equals("Aluno")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarNome(nome)) {
			if (elemento instanceof Aluno) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}

	@Override
	public ArrayList<Pessoa> buscaAlunoId(int id) {
		if (Autenticacao.runlevel().equals("Aluno")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarId(id)) {
			if (elemento instanceof Aluno) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}
	
	@Override
	public ArrayList<Pessoa> buscaAlunoMatricula(int matricula) {
		if (Autenticacao.runlevel().equals("Aluno")) {
			return null;
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Pessoa elemento : repositorio.buscarMatricula(matricula)) {
			if (elemento instanceof Aluno) {
				pessoas.add(elemento);
			}
		}
		return pessoas;
	}

	@Override
	public boolean removerAluno(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	/*
	@Override
	public boolean removerAluno(int id) {
		if (Autenticacao.runlevel().equals("Aluno")) {
			return false;
		}
		Pessoa pessoa = repositorio.buscarId(id).get(0);
		for (Materia materia : pessoa.get) {
			
		}
		return true;
	}
	*/
}