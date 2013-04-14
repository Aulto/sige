package sige.sige;

import java.util.ArrayList;

import sige.repositorio.*;

public class Sige implements ISige {

	private Repositorio repositorio;
	private static ISige instance;

	public Sige() throws InicializacaoSistemaException {
		try {
			this.repositorio = new Repositorio(
					"jdbc:mysql://localhost:3306/sige", "root", "");
		} catch (RepositorioException e) {
			throw new InicializacaoSistemaException();
		}
	}

	public static ISige getInstance() throws InicializacaoSistemaException {
		if (Sige.instance == null) {
			try {
				Sige.instance = new Sige();
			} catch (Exception e) {
				e.printStackTrace();
				throw new InicializacaoSistemaException();
			}
		}
		return Sige.instance;
	}

	@Override
	public ArrayList<Pessoa> buscarCpf(String cpf) throws ProblemaInterno {
		try {
			return repositorio.buscarPessoaCpf(cpf);
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	public boolean autenticarSistema() throws AutenticacaoException {
		try {
			return Autenticacao.AdministradorExists(this.repositorio);
		} catch (RepositorioException e) {
			throw new AutenticacaoException();
		}
	}

	@Override
	public ArrayList<Pessoa> buscarId(int id) throws ProblemaInterno {
		try {
			return repositorio.buscarPessoaId(id);
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public void adicionarAluno(String nome, String senha, String sexo,
			String estadoCivil, String dataNascimento, String email,
			String telefone, String rua, String bairro, String cidade,
			String uf, String complemento, String cep, String numero,
			String pais) throws ProblemaInterno {
		Aluno aluno = new Aluno(nome, senha, sexo, estadoCivil, dataNascimento,
				email, telefone, rua, bairro, cidade, uf, complemento, cep,
				numero, pais);
		try {
			repositorio.adicionarPessoa(aluno);
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public void adicionarProfessorAdm(Class<?> tipo, String nome, String senha,
			String sexo, String estadoCivil, String dataNascimento,
			String email, String telefone, String rua, String bairro,
			String cidade, String uf, String complemento, String cep,
			String numero, String pais) throws AutenticacaoException,
			ProblemaInterno {

		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		Pessoa pessoa = null;
		if (tipo == Professor.class) {
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
			try {
				repositorio.adicionarPessoa(pessoa);
			} catch (RepositorioException e) {
				throw new ProblemaInterno();
			}
		}
	}

	@Override
	public ArrayList<Pessoa> buscarAdm() throws AutenticacaoException,
			ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.recuperarPessoas()) {
				if (elemento instanceof Administrador
						|| elemento instanceof ProfessorAdministrador) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscarAdmNome(String nome)
			throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.buscarPessoaNome(nome)) {
				if (elemento instanceof Administrador
						|| elemento instanceof ProfessorAdministrador) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscarAdmCpf(String cpf) throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.buscarPessoaCpf(cpf)) {
				if (elemento instanceof Administrador
						|| elemento instanceof ProfessorAdministrador) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscarAdmId(int id) throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.buscarPessoaId(id)) {
				if (elemento instanceof Administrador
						|| elemento instanceof ProfessorAdministrador) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscaProfessor() throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.recuperarPessoas()) {
				if (elemento instanceof Professor
						|| elemento instanceof ProfessorAdministrador) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscaProfessorNome(String nome) throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.buscarPessoaNome(nome)) {
				if (elemento instanceof Professor
						|| elemento instanceof ProfessorAdministrador) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscaProfessorCpf(String cpf) throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.buscarPessoaCpf(cpf)) {
				if (elemento instanceof Professor
						|| elemento instanceof ProfessorAdministrador) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscaProfessorId(int id) throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.buscarPessoaId(id)) {
				if (elemento instanceof Professor
						|| elemento instanceof ProfessorAdministrador) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscaAluno() throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.recuperarPessoas()) {
				if (elemento instanceof Aluno) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscaAlunoNome(String nome) throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.buscarPessoaNome(nome)) {
				if (elemento instanceof Aluno) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public ArrayList<Pessoa> buscaAlunoId(int id) throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.buscarPessoaId(id)) {
				if (elemento instanceof Aluno) {
					pessoas.add(elemento);
				}
			}
			return pessoas;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	// @Override
	// public ArrayList<Pessoa> buscaAlunoMatricula(int matricula) {
	// if (Autenticacao.runlevel().equals("Aluno")) {
	// return null;
	// }
	// ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	// for (Pessoa elemento : repositorio.buscarMatricula(matricula)) {
	// if (elemento instanceof Aluno) {
	// pessoas.add(elemento);
	// }
	// }
	// return pessoas;
	// }

	@Override
	public void removerAluno(int id) {
	}

	/*
	 * @Override public boolean removerAluno(int id) { if
	 * (Autenticacao.runlevel().equals("Aluno")) { return false; } Pessoa pessoa
	 * = repositorio.buscarId(id).get(0); for (Materia materia : pessoa.get) {
	 * 
	 * } return true; }
	 */
}