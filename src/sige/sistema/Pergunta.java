package sige.sistema;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Danilo Monteiro
 * @author Giovanni Paolo
 * @author Luiz Daniel
 * 
 *         Perguntas que compõem uma atividade
 * 
 */
public class Pergunta {
	/**
	 * Enunciado da pegunta
	 */
	String pergunta;
	/**
	 * Alternativas (a primeira sempre é a correta)
	 */
	String[] alternativas;

	public Pergunta(String pergunta, String[] alternativas) {
		this.pergunta = pergunta;
		this.alternativas = alternativas;
	}

	/**
	 * Retornar pergunta serializada em String no formato "pergunta,a,b,c,d,e"
	 */
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

	/**
	 * Retorna um objeto do tipo Pergunta a partir de uma String com perguntas
	 * (serializadas em string) e delimitadas por |
	 * 
	 * @param str
	 *            String delimitada por |
	 * @return ArrayList de Pergunta
	 */
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
}
