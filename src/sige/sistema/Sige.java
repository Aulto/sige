package sige.sistema;

import java.util.ArrayList;

import sige.repositorio.*;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 */
public class Sige implements ISige {

	/**
	 * Reposit�rio de dados
	 */
	private Repositorio repositorio;

	/**
	 * Inst�ncia do sistema
	 */
	private static ISige instance;

	/**
	 * Construtor do sistema
	 * 
	 * @throws InicializacaoSistemaException
	 *             Lan�ado quando h� um problema a inicializa��o do sistema
	 */
	public Sige() throws InicializacaoSistemaException {
		try {
			this.repositorio = new Repositorio(
					"jdbc:mysql://localhost:3306/sige", "root", "");
		} catch (RepositorioException e) {
			throw new InicializacaoSistemaException();
		}
	}

	/**
	 * Recuperar a inst�ncia sistema
	 * 
	 * @return retorna a inst�ncia incializada caso haja uma, ou cria uma
	 *         inst�ncia e retorna, caso contr�rio
	 * @throws InicializacaoSistemaException
	 *             lan�ado quando h� algum erro na inicializa��o do sistema
	 */
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

	public boolean autenticarSistema() throws ProblemaInterno {
		try {
			return Autenticacao.AdministradorExists(this.repositorio);
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
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
	public void adicionarAluno(int id, String nome, String cpf, String rg,
			String senha, String sexo, String estadoCivil,
			String dataNascimento, String email, String telefone,
			String celular, String rua, String bairro, String cidade,
			String uf, String complemento, String cep, String numero,
			String pais) throws ProblemaInterno {
		Aluno aluno = new Aluno(id, nome, cpf, rg, senha, sexo, estadoCivil,
				dataNascimento, email, telefone, celular, new Endereco(rua,
						bairro, cidade, uf, complemento, cep, numero, pais));
		try {
			repositorio.adicionarPessoa(aluno);
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public void adicionarProfessorAdm(Class<?> tipo, int id, String nome, String cpf,
			String rg, String senha, String sexo, String estadoCivil,
			String dataNascimento, String email, String telefone,
			String celular, String rua, String bairro, String cidade,
			String uf, String complemento, String cep, String numero,
			String pais) throws AutenticacaoException, ProblemaInterno {

		Pessoa pessoa = null;
		if (tipo == Professor.class) {
			pessoa = new Professor(id, nome, cpf, rg, senha, sexo, estadoCivil,
					dataNascimento, email, telefone, celular, new Endereco(rua,
							bairro, cidade, uf, complemento, cep, numero, pais));
		} else if (tipo == Administrador.class) {
			pessoa = new Administrador(id, nome, cpf, rg, senha, sexo, estadoCivil,
					dataNascimento, email, telefone, celular, new Endereco(rua,
							bairro, cidade, uf, complemento, cep, numero, pais));
		} else if (tipo == ProfessorAdministrador.class) {
			pessoa = new ProfessorAdministrador(id, nome, cpf, rg, senha, sexo,
					estadoCivil, dataNascimento, email, telefone, celular,
					new Endereco(rua, bairro, cidade, uf, complemento, cep,
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
	public ArrayList<Pessoa> buscarAdm() throws AutenticacaoException,
			ProblemaInterno {

		/*
		 * if (Autenticacao.runlevel().equals("Aluno") ||
		 * Autenticacao.runlevel().equals("Professor")) { throw new
		 * AutenticacaoException(); }
		 */
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
	public ArrayList<Pessoa> buscarAdmCpf(String cpf)
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
	public ArrayList<Pessoa> buscarAdmId(int id) throws AutenticacaoException,
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
	public ArrayList<Pessoa> buscarProfessor() throws AutenticacaoException,
			ProblemaInterno {
		/*
		 * if (Autenticacao.runlevel().equals("Aluno") ||
		 * Autenticacao.runlevel().equals("Professor")) { throw new
		 * AutenticacaoException(); }
		 */
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
	public ArrayList<Pessoa> buscarProfessorNome(String nome)
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
	public ArrayList<Pessoa> buscarProfessorCpf(String cpf)
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
	public ArrayList<Pessoa> buscarProfessorId(int id)
			throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")
				|| Autenticacao.runlevel().equals("Professor")) {
//			throw new AutenticacaoException();
//			alunos podem executar esta acao
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
	public ArrayList<Pessoa> buscarAluno() throws AutenticacaoException,
			ProblemaInterno {
		/*
		 * if (Autenticacao.runlevel().equals("Aluno")) { throw new
		 * AutenticacaoException(); }
		 */
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
	public ArrayList<Pessoa> buscarAlunoNome(String nome)
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
	public ArrayList<Pessoa> buscarAlunoId(int id)
			throws AutenticacaoException, ProblemaInterno {
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

	@Override
	public ArrayList<Pessoa> buscarAlunoCpf(String cpf)
			throws AutenticacaoException, ProblemaInterno {
		if (Autenticacao.runlevel().equals("Aluno")) {
			throw new AutenticacaoException();
		}
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			for (Pessoa elemento : repositorio.buscarPessoaCpf(cpf)) {
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
	public ArrayList<Materia> recuperarMateriasAluno(int id) throws ProblemaInterno {
		try {
			ArrayList<Materia> res = repositorio.recuperarMaterias();
			for (int i = 0; i < res.size(); i++) {
				if(!res.get(i).alunoCadastrado(id))
					res.remove(i);
			}
			return res;
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	public int proximoId(){
		try {
			return repositorio.proximoId();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<Materia> recuperarMaterias() throws ProblemaInterno{
		try {
			return repositorio.recuperarMaterias();
		} catch (RepositorioException e) {
			throw new ProblemaInterno();
		}
	}

	@Override
	public Materia buscarMateriaNome(String nome) throws ProblemaInterno {
		ArrayList<Materia> res = recuperarMaterias();
		for (Materia materia : res) {
			if(materia.getNome().equals(nome))
				return materia;
		}
		return null;
	}
}