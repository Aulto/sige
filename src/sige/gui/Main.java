package sige.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sige.repositorio.RepositorioException;
import sige.sistema.AutenticacaoException;
import sige.sistema.ISige;
import sige.sistema.ProblemaInterno;
import sige.sistema.Sige;

public class Main {

	private FachadaAdm fachadaAdm;
	private FachadaAluno fachadaAluno;
	private FachadaProfessor fachadaProf;
	private FachadaProfessorAdm fachadaProfAdm;
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

		/*
		 * cadastrar.setVisible(true); login.setVisible(true);
		 * fachadaAdm.setVisible(true);
		 */
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
