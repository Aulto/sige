package sige.sistema;

import java.util.ArrayList;

public class TestePergunta {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Pergunta p = new Pergunta("Sera que essa pergunta vai funcionar?",
				new String[] { "A", "B", "C", "D", "E" });
		ArrayList<Pergunta> perguntas = Pergunta
				.stringToPerguntas("Sera que essa pergunta vai funcionar?,A,B,C,D,E|Sera que essa pergunta vai funcionar?,A,B,C,D,E");
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta);
		}
	}
}
