package sige.repositorio;

import java.sql.*;
import java.util.ArrayList;

import sige.sige.Administrador;
import sige.sige.Aluno;
import sige.sige.Atividade;
import sige.sige.Materia;
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
	public boolean adicionar(Pessoa pessoa) {
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
	public boolean remover(int id) {
		try {
			stm.executeUpdate("REMOVE * FROM pessoas WHERE id Like '" + id
					+ "'");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean atualizar(int id, Pessoa pessoa) {
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
	public ArrayList<Pessoa> buscarNome(String nome) {
		return buscarSQL("SELECT * FROM pessoas WHERE nome LIKE '" + nome + "'");
	}

	@Override
	public ArrayList<Pessoa> buscarCpf(String cpf) {
		return buscarSQL("SELECT * FROM pessoas WHERE cpf LIKE '" + cpf + "'");
	}

	@Override
	public ArrayList<Pessoa> buscarId(int id) {
		return buscarSQL("SELECT * FROM pessoas WHERE id LIKE '" + id + "'");
	}

	@Override
	public ArrayList<Pessoa> buscarPessoas() {
		return buscarSQL("SELECT * FROM pessoas");
	}

	@Override
	public boolean adicionarMateria(Materia materia) {
		try {
			rs = stm.executeQuery("INSERT INTO materias (id)");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean removerMateria(int id) {
		try {
			rs = stm.executeQuery("REMOVE * FROM materias WHERE id LIKE '" + id
					+ "'");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean atualizarMateria(int id, Materia materia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Materia> buscarMateriaNome(String chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Materia> buscarMateriaId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Materia> buscarMateriaProfessor(String idProfessor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Materia> buscarMateria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adicionarAtividade(Atividade atividade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerAtividade(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizarAtividade(int id, Atividade atividade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Atividade> buscarAtividadeId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Atividade> buscarAtividadeMateria(String idMateria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Atividade> buscarAtividade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pessoa> buscarMatricula(int matricula) {
		// TODO Auto-generated method stub
		return null;
	}
}
