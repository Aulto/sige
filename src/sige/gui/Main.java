package sige.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sige.sistema.ISige;
import sige.sistema.ProblemaInterno;
import sige.sistema.Sige;

public class Main {

	@SuppressWarnings("unused")
	private FachadaAdm fachadaAdm;
	@SuppressWarnings("unused")
	private FachadaAluno fachadaAluno;
	@SuppressWarnings("unused")
	private FachadaProfessor fachadaProf;
	@SuppressWarnings("unused")
	private FachadaProfessorAdm fachadaProfAdm;
	@SuppressWarnings("unused")
	private ExibirPerfil exibirPerfil;
	private Cadastrar cadastrar;
	private Login login;
	private ISige sistema;
	public static JFrame historico;

	public Main() {
		init();
	}

	public void sistema() {
		try {
			if (sistema.autenticarSistema()) {
				login.setVisible(true);
				Main.historico = login;
			} else {
				cadastrar.setVisible(true);
				cadastrar.primeiroCadastro();
				Main.historico = login;
			}
		} catch (ProblemaInterno e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private void init() {
		try {
			sistema = Sige.getInstance();
			login = new Login();
			cadastrar = new Cadastrar();
			fachadaAdm = new FachadaAdm();
			exibirPerfil = new ExibirPerfil();
		} catch (Exception e) {e.printStackTrace();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
