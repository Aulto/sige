package sige.repositorio;

import java.sql.*;

public class TesteRepositorio {
	public static void main(String[] args) throws Exception{
		Repositorio r = new Repositorio("jdbc:mysql://localhost:3306/sige", "root", "");
//		Pessoa gio = new Aluno("Giovanni", "123", "masculino", "solteiro", "03/05/1995", "giovanni1995@gmail.com", "32687489", "r. joao barbalho", "casa forte", "Recife", "PE", "", "52070090", "200", "Brasil");
//		
//		if (r.adicionar(gio)){
//			System.out.println("Aeee, rsrsrs");
//		} else {
//			System.out.println("well, fuck");
//		}
		
		ResultSet rs = r.stm.executeQuery("SELECT * FROM pessoas ORDER BY id DESC");
		while(rs.next()){
			System.out.println(rs.getInt("id"));
		}
		
	}
}
