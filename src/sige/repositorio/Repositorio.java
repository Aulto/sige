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

}
