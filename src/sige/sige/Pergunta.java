package sige.sige;

import java.util.ArrayList;
import java.util.Arrays;

public class Pergunta {
	String pergunta;
	String[] alternativas;

	public Pergunta(String pergunta, String[] alternativas) {
		this.pergunta = pergunta;
		this.alternativas = alternativas;
	}

	// perguntas delimitadas por | no parametro str
	public static ArrayList<Pergunta> stringToPerguntas(String str) {
		String[] perguntas = str.split("\\|");
		ArrayList<Pergunta> res = new ArrayList<Pergunta>();

		String pergunta;
		String[] alternativas;

		for (int i = 0; i < perguntas.length; i++) {
			alternativas = perguntas[i].split("\\,");
			pergunta = alternativas[0];
			alternativas = Arrays.copyOfRange(alternativas, 1,
					alternativas.length);
			res.add(new Pergunta(pergunta, alternativas));
		}

		return res;
	}

	// retornar pergunta em formato string "pergunta,a,b,c,d,e"
	@Override
	public String toString() {
		String res = "";
		res += this.pergunta + ",";
		for (int i = 0; i < alternativas.length; i++) {
			if (alternativas[i] != null) {
				res += "" + alternativas[i] + "";
			}
			if (i != alternativas.length - 1) {
				res += ",";
			}
		}
		return res;
	}
}
