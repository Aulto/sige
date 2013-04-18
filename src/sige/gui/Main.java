package sige.gui;

import javax.swing.JOptionPane;

import sige.repositorio.RepositorioException;
import sige.sistema.AutenticacaoException;
import sige.sistema.ISige;
import sige.sistema.Sige;

public class Main {

	private FachadaAdm fachadaAdm;
	private FachadaAluno fachadaAluno;
	private FachadaProfessor fachadaProf;
	private FachadaProfessorAdm fachadaProfAdm;
	private Cadastrar cadastrar;
	private Login login;
	private ISige sistema;

	public Main() {
		init();
	}

	public void sistema() {
		try {
			if (sistema.autenticarSistema()) {
				login.setVisible(true);
			} else {
				cadastrar.setVisible(true);
				cadastrar.primeiroCadastro();
			}
		} catch (RepositorioException e) {
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
		} catch (Exception e) {e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
