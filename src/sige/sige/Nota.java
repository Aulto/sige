package sige.sige;

import java.util.ArrayList;

public class Nota {

	int idAluno;
	ArrayList<Double> notas;
	
	public Nota(int idAluno){
		this.idAluno = idAluno;
		this.notas = new ArrayList<Double>();
	}
}
