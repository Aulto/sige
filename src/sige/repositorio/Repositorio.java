package sige.repositorio;

import java.sql.*;
import java.util.ArrayList;

import sige.sistema.Administrador;
import sige.sistema.Aluno;
import sige.sistema.Atividade;
import sige.sistema.Endereco;
import sige.sistema.Materia;
import sige.sistema.Pergunta;
import sige.sistema.Pessoa;
import sige.sistema.Professor;
import sige.sistema.ProfessorAdministrador;

/**
 * Implementa��o do reposit�rio utilizando o Driver JDBC para se conectar a um
 * servidor MySQL
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 */
public class Repositorio implements IRepositorio {
	/**
	 * Vari�vel de conex�o
	 */
	Connection conn;
	/**
	 * Vari�vel que armazena as consultas SQL
	 */
	Statement stm;
	/**
	 * Vari�vel que armazena os resultados retornados pelas consultas
	 */
	ResultSet rs;

	/**
	 * Construtor do reposit�rio
	 * 
	 * @param host
	 *            host que aponta para o servidor MySQL (ex:
	 *            jdbc:mysql://localhost:3306/sige, onde <i>sige</i> � o banco
	 *            de dados
	 * @param user
	 *            usu�rio de login no servidor
	 * @param pass
	 *            senha do usu�rio
	 * @throws RepositorioException
	 *             lan�ado quando h� algum problema na conex�o com o banco de
	 *             dados
	 */
	public Repositorio(String host, String user, String pass)
			throws RepositorioException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host, user, pass);
			stm = conn.createStatement();
		} catch (Exception e) {
			throw new RepositorioException();
		}
	}

	/**
	 * Fazer busca por pessoas no banco de dados utilizando um filtro numa
	 * consulta Esta fun��o � privativa e utilizada apenas por outros m�todos
	 * para formatar os resultados da busca
	 * 
	 * @param query
	 *            consulta SQL que filtra os resultados
	 * @return retorna uma ArrayList de Pessoa com os resultados da busca
	 * @throws RepositorioException
	 *             lan�ado quando h� um erro de conex�o ou na consulta SQL
	 *             enviada
	 */
	private ArrayList<Pessoa> buscarSQL(String query)
			throws RepositorioException {
		ArrayList<Pessoa> res = new ArrayList<Pessoa>();
		try {
			rs = stm.executeQuery(query);
			while (rs.next()) {
				String tipo = rs.getString("tipo");
				if (tipo.equals("Aluno")) {
					res.add(new Aluno(rs.getInt("id"), rs.getString("nome"), rs
							.getString("cpf"), rs.getString("rg"), rs
							.getString("senha"), rs.getString("sexo"), rs
							.getString("estadoCivil"), rs
							.getString("dataNascimento"),
							rs.getString("email"), rs.getString("telefone"), rs
									.getString("celular"), Endereco
									.getEndere�o(rs.getString("endereco"))));
				} else if (tipo.equals("Professor")) {
					res.add(new Professor(rs.getInt("id"),
							rs.getString("nome"), rs.getString("cpf"), rs
									.getString("rg"), rs.getString("senha"), rs
									.getString("sexo"), rs
									.getString("estadoCivil"), rs
									.getString("dataNascimento"), rs
									.getString("email"), rs
									.getString("telefone"), rs
									.getString("celular"), Endereco
									.getEndere�o(rs.getString("endereco"))));
				} else if (tipo.equals("Administrador")) {
					res.add(new Administrador(rs.getInt("id"), rs
							.getString("nome"), rs.getString("cpf"), rs
							.getString("rg"), rs.getString("senha"), rs
							.getString("sexo"), rs.getString("estadoCivil"), rs
							.getString("dataNascimento"),
							rs.getString("email"), rs.getString("telefone"), rs
									.getString("celular"), Endereco
									.getEndere�o(rs.getString("endereco"))));
				} else if (tipo.equals("ProfessorAdministrador")) {
					res.add(new ProfessorAdministrador(rs.getInt("id"), rs
							.getString("nome"), rs.getString("cpf"), rs
							.getString("rg"), rs.getString("senha"), rs
							.getString("sexo"), rs.getString("estadoCivil"), rs
							.getString("dataNascimento"),
							rs.getString("email"), rs.getString("telefone"), rs
									.getString("celular"), Endereco
									.getEndere�o(rs.getString("endereco"))));
				}
			}
			return res;
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public void adicionarPessoa(Pessoa pessoa) throws RepositorioException {
		try {
			stm.executeUpdate("INSERT INTO pessoas (id, nome, cpf, senha, rg, sexo, estadoCivil, dataNascimento, email, telefone, celular, endereco, tipo) VALUES"
					+ "('"
					+ pessoa.getIdPessoa()
					+ "', '"
					+ pessoa.getNome()
					+ "', '"
					+ pessoa.getCpf()
					+ "', '"
					+ pessoa.getSenha()
					+ "', '"
					+ pessoa.getRg()
					+ "', '"
					+ pessoa.getSexo()
					+ "', '"
					+ pessoa.getEstadoCivil()
					+ "', '"
					+ pessoa.getDataNascimento()
					+ "', '"
					+ pessoa.getEmail()
					+ "', '"
					+ pessoa.getTelefone()
					+ "', '"
					+ pessoa.getCelular()
					+ "', '"
					+ pessoa.getEndere�o()
					+ "', '" + pessoa.getClass().getSimpleName() + "')");
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public void removerPessoa(int id) throws RepositorioException {
		try {
			stm.executeUpdate("REMOVE * FROM pessoas WHERE id Like '" + id
					+ "'");
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public void atualizarPessoa(int id, Pessoa pessoa)
			throws RepositorioException {
		try {
			stm.executeUpdate("UPDATE pessoas SET nome=" + pessoa.getNome()
					+ ", cpf=" + pessoa.getCpf() + ", senha="
					+ pessoa.getSenha() + ", rg=" + pessoa.getRg() + ", sexo="
					+ pessoa.getSexo() + ", estadoCivil="
					+ pessoa.getEstadoCivil() + ", dataNascimento="
					+ pessoa.getDataNascimento() + ", email="
					+ pessoa.getEmail() + ", telefone=" + pessoa.getTelefone()
					+ ", endere�o=" + pessoa.getEndere�o() + " WHERE id Like '"
					+ id + "'");
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public ArrayList<Pessoa> recuperarPessoas() throws RepositorioException {
		return buscarSQL("SELECT * FROM pessoas");
	}

	@Override
	public ArrayList<Pessoa> buscarPessoaId(int id) throws RepositorioException {
		return buscarSQL("SELECT * FROM pessoas WHERE id LIKE '" + id + "'");
	}

	@Override
	public ArrayList<Pessoa> buscarPessoaNome(String nome)
			throws RepositorioException {
		return buscarSQL("SELECT * FROM pessoas WHERE nome LIKE '%" + nome
				+ "%'");
	}

	@Override
	public ArrayList<Pessoa> buscarPessoaCpf(String cpf)
			throws RepositorioException {
		return buscarSQL("SELECT * FROM pessoas WHERE cpf LIKE '" + cpf + "'");
	}

	@Override
	public void adicionarMateria(Materia materia) throws RepositorioException {
		try {
			stm.executeUpdate("INSERT INTO materias (id, nome, idProfessor) VALUES ('"
					+ materia.getIdMateria()
					+ "', '"
					+ materia.getNome()
					+ "', '" + materia.getIdProfessor() + "')");
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public void removerMateria(int id) throws RepositorioException {
		try {
			stm.executeUpdate("REMOTE * FROM materias WHERE id LIKE '" + id
					+ "'");
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public void atualizarMateria(int id, Materia materia)
			throws RepositorioException {
		try {
			stm.executeUpdate("UPDATE materias SET nome='" + materia.getNome()
					+ "', idProfessor='" + materia.getIdProfessor()
					+ "' WHERE id LIKE '" + id + "'");
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public ArrayList<Materia> recuperarMaterias() throws RepositorioException {
		ArrayList<Materia> res = new ArrayList<Materia>();
		String[] idAlunos;
		try {
			rs = stm.executeQuery("SELECT * FROM materias");
			while (rs.next()) {
				idAlunos = rs.getString("idAlunos").split("\\|");
				res.add(new Materia(rs.getString("nome"), rs
						.getInt("idProfessor"), idAlunos));
			}
			return res;
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public ArrayList<Materia> buscarMateriaId(int id)
			throws RepositorioException {
		ArrayList<Materia> res = new ArrayList<Materia>();
		for (Materia m : this.recuperarMaterias()) {
			if (m.getIdMateria() == id) {
				res.add(m);
			}
		}
		return res;
	}

	@Override
	public ArrayList<Materia> buscarMateriaNome(String nome)
			throws RepositorioException {
		ArrayList<Materia> res = new ArrayList<Materia>();
		for (Materia m : this.recuperarMaterias()) {
			if (m.getNome().equals(nome)) {
				res.add(m);
			}
		}
		return res;
	}

	@Override
	public void adicionarAtividade(Atividade atividade)
			throws RepositorioException {
		try {
			stm.executeUpdate("INSERT INTO atividades (id, nome, materiaId, perguntas) VALUES ('"
					+ atividade.getIdAtividade()
					+ "', '"
					+ atividade.getNome()
					+ "' ,'"
					+ atividade.getIdMateria()
					+ "', '"
					+ atividade.getPerguntas() + "')");
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public void removerAtividade(int id) throws RepositorioException {
		try {
			stm.executeUpdate("REMOVE * FROM atividades WHERE id LIKE '" + id
					+ "'");
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public void atualizarAtividade(int id, Atividade atividade)
			throws RepositorioException {
		try {
			stm.executeUpdate("UPDATE atividades SET nome='"
					+ atividade.getNome() + "', materiaId='"
					+ atividade.getIdMateria() + "', perguntas='"
					+ atividade.getPerguntas() + "' WHERE id LIKE '" + id + "'");
		} catch (SQLException e) {
			throw new RepositorioException();
		}
	}

	@Override
	public ArrayList<Atividade> recuperarAtividades()
			throws RepositorioException {
		ArrayList<Atividade> res = new ArrayList<Atividade>();
		try {
			rs = stm.executeQuery("SELECT * FROM atividades");
			while (rs.next()) {
				res.add(new Atividade(rs.getString("nome"), rs
						.getInt("materiaId"), Pergunta.stringToPerguntas(rs
						.getString("perguntas"))));
			}
			return res;
		} catch (SQLException e) {
			// e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Atividade> buscarAtividadeId(int id)
			throws RepositorioException {
		ArrayList<Atividade> res = new ArrayList<Atividade>();
		for (Atividade atividade : this.recuperarAtividades()) {
			if (atividade.getIdAtividade() == id) {
				res.add(atividade);
			}
		}
		return res;
	}

	public int proximoId() throws RepositorioException {
		return buscarSQL("SELECT * FROM pessoas ORDER BY id DESC").get(0).getIdPessoa();
	}

}
