package sige.repositorio;

import java.sql.*;
import java.util.ArrayList;

import sige.sige.Administrador;
import sige.sige.Aluno;
import sige.sige.Atividade;
import sige.sige.Materia;
import sige.sige.Pergunta;
import sige.sige.Pessoa;
import sige.sige.Professor;
import sige.sige.ProfessorAdministrador;

public class Repositorio implements IRepositorio {
	Connection conn;
	Statement stm;
	ResultSet rs;

	public Repositorio(String host, String user, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host, user, pass);
			stm = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ArrayList<Pessoa> buscarSQL(String query) {
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
			return null;
		}
	}

	@Override
	public boolean adicionarPessoa(Pessoa pessoa) {
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
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removerPessoa(int id) {
		try {
			stm.executeUpdate("REMOVE * FROM pessoas WHERE id Like '" + id
					+ "'");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean atualizarPessoa(int id, Pessoa pessoa) {
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
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public ArrayList<Pessoa> recuperarPessoas() {
		return buscarSQL("SELECT * FROM pessoas");
	}

	@Override
	public ArrayList<Pessoa> buscarPessoaId(int id) {
		return buscarSQL("SELECT * FROM pessoas WHERE id LIKE '" + id + "'");
	}

	@Override
	public ArrayList<Pessoa> buscarPessoaNome(String nome) {
		return buscarSQL("SELECT * FROM pessoas WHERE nome LIKE '" + nome + "'");
	}

	@Override
	public ArrayList<Pessoa> buscarPessoaCpf(String cpf) {
		return buscarSQL("SELECT * FROM pessoas WHERE cpf LIKE '" + cpf + "'");
	}

	@Override
	public boolean adicionarMateria(Materia materia) {
		try {
			stm.executeUpdate("INSERT INTO materias (id, nome, idProfessor) VALUES ('"
					+ materia.getIdMateria()
					+ "', '"
					+ materia.getNome()
					+ "', '" + materia.getIdProfessor() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removerMateria(int id) {
		try {
			stm.executeUpdate("REMOTE * FROM materias WHERE id LIKE '" + id
					+ "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean atualizarMateria(int id, Materia materia) {
		try {
			stm.executeUpdate("UPDATE materias SET nome='" + materia.getNome()
					+ "', idProfessor='" + materia.getIdProfessor()
					+ "' WHERE id LIKE '" + id + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Materia> recuperarMaterias() {
		ArrayList<Materia> res = new ArrayList<Materia>();
		try {
			rs = stm.executeQuery("SELECT * FROM materias");
			while (rs.next()) {
				res.add(new Materia(rs.getString("nome"), rs
						.getInt("idProfessor")));
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Materia> buscarMateriaId(int id) {
		ArrayList<Materia> res = new ArrayList<Materia>();
		for (Materia m : this.recuperarMaterias()) {
			if (m.getIdMateria() == id) {
				res.add(m);
			}
		}
		return res;
	}

	@Override
	public ArrayList<Materia> buscarMateriaNome(String nome) {
		ArrayList<Materia> res = new ArrayList<Materia>();
		for (Materia m : this.recuperarMaterias()) {
			if (m.getNome().equals(nome)) {
				res.add(m);
			}
		}
		return res;
	}

	@Override
	public boolean adicionarAtividade(Atividade atividade) {
		try {
			stm.executeUpdate("INSERT INTO atividades (id, nome, materiaId, perguntas) VALUES ('"
					+ atividade.getIdAtividade()
					+ "', '"
					+ atividade.getNome()
					+ "' ,'"
					+ atividade.getIdMateria()
					+ "', '"
					+ atividade.getPerguntas() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removerAtividade(int id) {
		try {
			stm.executeUpdate("REMOVE * FROM atividades WHERE id LIKE '" + id
					+ "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean atualizarAtividade(int id, Atividade atividade) {
		try {
			stm.executeUpdate("UPDATE atividades SET nome='"
					+ atividade.getNome() + "', materiaId='"
					+ atividade.getIdMateria() + "', perguntas='"
					+ atividade.getPerguntas() + "' WHERE id LIKE '" + id + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Atividade> recuperarAtividades() {
		ArrayList<Atividade> res = new ArrayList<Atividade>();
		try {
			rs = stm.executeQuery("SELECT * FROM atividades");
			while (rs.next()) {
				res.add(new Atividade(rs.getString("nome"), rs
						.getInt("materiaId"), Pergunta.jsonToPerguntas(rs
						.getString("perguntas"))));
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Atividade> buscarAtividadeId(int id) {
		ArrayList<Atividade> res = new ArrayList<Atividade>();
		for(Atividade atividade : this.recuperarAtividades()){
			if(atividade.getIdAtividade() == id){
				res.add(atividade);
			}
		}
		return res;
	}

}
