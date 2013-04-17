package sige.sistema;

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

	public boolean autenticarSistema() throws RepositorioException {
		return Autenticacao.AdministradorExists(this.repositorio);
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
	public void adicionarAluno(String nome, String cpf, String rg,
			String senha, String sexo, String estadoCivil,
			String dataNascimento, String email, String telefone,
			String celular, String rua, String bairro, String cidade,
			String uf, String complemento, String cep, String numero,
			String pais) throws ProblemaInterno {
		Aluno aluno = new Aluno(nome, cpf, rg, senha, sexo, estadoCivil,
				dataNascimento, email, telefone, celular, new Endereço(rua,
						bairro, cidade, uf, complemento, cep, numero, pais));
		try {
			repositorio.adicionarPessoa(aluno);
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public void adicionarProfessorAdm(Class<?> tipo, String nome, String cpf,
			String rg, String senha, String sexo, String estadoCivil,
			String dataNascimento, String email, String telefone,
			String celular, String rua, String bairro, String cidade,
			String uf, String complemento, String cep, String numero,
			String pais) throws AutenticacaoException, ProblemaInterno {
		
		Pessoa pessoa = null;
		if (tipo == Professor.class) {
			pessoa = new Professor(nome, cpf, rg, senha, sexo, estadoCivil,
					dataNascimento, email, telefone, celular, new Endereço(rua,
							bairro, cidade, uf, complemento, cep, numero, pais));
		} else if (tipo == Administrador.class) {
			pessoa = new Administrador(nome, cpf, rg, senha, sexo, estadoCivil,
					dataNascimento, email, telefone, celular, new Endereço(rua,
							bairro, cidade, uf, complemento, cep, numero, pais));
		} else if (tipo == ProfessorAdministrador.class) {
			pessoa = new ProfessorAdministrador(nome, cpf, rg, senha, sexo,
					estadoCivil, dataNascimento, email, telefone, celular,
					new Endereço(rua, bairro, cidade, uf, complemento, cep,
							numero, pais));
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
	public ArrayList<Pessoa> buscaAdm() throws AutenticacaoException,
			ProblemaInterno {

		/*if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}*/
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
	public ArrayList<Pessoa> buscaAdmNome(String nome)
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
	public ArrayList<Pessoa> buscaAdmCpf(String cpf)
			throws AutenticacaoException, ProblemaInterno {
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
	public ArrayList<Pessoa> buscaAdmId(int id) throws AutenticacaoException,
			ProblemaInterno {
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
	public ArrayList<Pessoa> buscaProfessor() throws AutenticacaoException,
			ProblemaInterno {
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
	public ArrayList<Pessoa> buscaProfessorNome(String nome)
			throws AutenticacaoException, ProblemaInterno {
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
	public ArrayList<Pessoa> buscaProfessorCpf(String cpf)
			throws AutenticacaoException, ProblemaInterno {
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
	public ArrayList<Pessoa> buscaProfessorId(int id)
			throws AutenticacaoException, ProblemaInterno {
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
	public ArrayList<Pessoa> buscaAluno() throws AutenticacaoException,
			ProblemaInterno {
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
	public ArrayList<Pessoa> buscaAlunoNome(String nome)
			throws AutenticacaoException, ProblemaInterno {
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
	public ArrayList<Pessoa> buscaAlunoId(int id) throws AutenticacaoException,
			ProblemaInterno {
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

	@Override
	public void removerAluno(int id) throws AutenticacaoException,
			ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")) {
			throw new AutenticacaoException();
		}
		try {
			repositorio.removerPessoa(id);
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public void removerProfessor(int id) throws AutenticacaoException,
			ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		try {
			if (!repositorio.buscarPessoaId(id).get(0).getClass()
					.getSimpleName().equals("Professor")) {
				IAdministrador adm = (IAdministrador) repositorio
						.buscarPessoaId(id).get(0);
				if (adm.isRoot()) {
					throw new AutenticacaoException();
				} else {
					repositorio.removerPessoa(id);
				}
			} else {
				repositorio.removerPessoa(id);
			}
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public void removerAdm(int id) throws AutenticacaoException,
			ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
			throw new AutenticacaoException();
		}
		try {
			IAdministrador adm = (IAdministrador) repositorio
					.buscarPessoaId(id).get(0);
			if (Autenticacao.isRoot() && !adm.isRoot()) {
				repositorio.removerPessoa(id);
			} else {
				throw new AutenticacaoException();
			}
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	public Repositorio getRepositorio() {
		return this.repositorio;
	}
}