package sige.repositorio;

import java.sql.*;
import java.util.ArrayList;

import sige.sistema.Administrador;
import sige.sistema.Aluno;
import sige.sistema.Atividade;
import sige.sistema.Materia;
import sige.sistema.Pergunta;
import sige.sistema.Pessoa;
import sige.sistema.Professor;
import sige.sistema.ProfessorAdministrador;

public class Repositorio implements IRepositorio {
	Connection conn;
	Statement stm;
	ResultSet rs;

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

	private ArrayList<Pessoa> buscarSQL(String query)
			throws RepositorioException {
		ArrayList<Pessoa> res = new ArrayList<Pessoa>();
		try {
			rs = stm.executeQuery(query);
			String tipo = rs.getString("tipo");
			while (rs.next()) {
				if (tipo.equals("Aluno")) {
					res.add(new Aluno(rs.getString("nome"), rs
							.getString("senha"), rs.getString("sexo"), rs
							.getString("estadoCivil"), rs
							.getString("dataNascimento"),
							rs.getString("email"), rs.getString("telefone"), rs
									.getString("rua"), rs.getString("bairro"),
							rs.getString("cidade"), rs.getString("uf"), rs
									.getString("complemento"), rs
									.getString("cep"), rs.getString("numero"),
							rs.getString("pais")));
				} else if (tipo.equals("Professor")) {
					res.add(new Professor(rs.getString("nome"), rs
							.getString("senha"), rs.getString("sexo"), rs
							.getString("estadoCivil"), rs
							.getString("dataNascimento"),
							rs.getString("email"), rs.getString("telefone"), rs
									.getString("rua"), rs.getString("bairro"),
							rs.getString("cidade"), rs.getString("uf"), rs
									.getString("complemento"), rs
									.getString("cep"), rs.getString("numero"),
							rs.getString("pais")));
				} else if (tipo.equals("Administrador")) {
					res.add(new Administrador(rs.getString("nome"), rs
							.getString("senha"), rs.getString("sexo"), rs
							.getString("estadoCivil"), rs
							.getString("dataNascimento"),
							rs.getString("email"), rs.getString("telefone"), rs
									.getString("rua"), rs.getString("bairro"),
							rs.getString("cidade"), rs.getString("uf"), rs
									.getString("complemento"), rs
									.getString("cep"), rs.getString("numero"),
							rs.getString("pais")));
				} else if (tipo.equals("ProfessorAdministrador")) {
					res.add(new ProfessorAdministrador(rs.getString("nome"), rs
							.getString("senha"), rs.getString("sexo"), rs
							.getString("estadoCivil"), rs
							.getString("dataNascimento"),
							rs.getString("email"), rs.getString("telefone"), rs
									.getString("rua"), rs.getString("bairro"),
							rs.getString("cidade"), rs.getString("uf"), rs
									.getString("complemento"), rs
									.getString("cep"), rs.getString("numero"),
							rs.getString("pais")));
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
			stm.executeUpdate("INSERT INTO pessoas (id, nome, cpf, senha, rg, sexo, estadoCivil, dataNascimento, email, telefone, endereco, tipo) VALUES"
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
					+ pessoa.getEndereço()
					+ "', '"
					+ pessoa.getClass().getSimpleName() + "')");
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
					+ ", endereço=" + pessoa.getEndereço() + " WHERE id Like '"
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
		return buscarSQL("SELECT * FROM pessoas WHERE nome LIKE '" + nome + "'");
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
		try {
			rs = stm.executeQuery("SELECT * FROM materias");
			while (rs.next()) {
				res.add(new Materia(rs.getString("nome"), rs
						.getInt("idProfessor")));
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
			e.printStackTrace();
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

}
