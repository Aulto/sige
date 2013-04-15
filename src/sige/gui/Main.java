package sige.gui;

import javax.swing.JOptionPane;

public class Main{
	
	private FachadaAdm fachadaAdm;
	private FachadaAluno fachadaAluno;
	private FachadaProfessor fachadaProf;
	private FachadaProfessorAdm fachadaProfAdm;	
	private Cadastrar cadastrar;
	private Login login;
	
	public Main(){
		init();
	}
	
	public void sistema(){
		cadastrar.setVisible(true);
		login.setVisible(true);
		fachadaAdm.setVisible(true);
	}
	
	private void init(){
		try {
			//sistema = Sige.getInstance();
			
			login = new Login();
			cadastrar = new Cadastrar();
			fachadaAdm = new FachadaAdm();
			fachadaAluno = new FachadaAluno();
			fachadaProf = new FachadaProfessor();
			fachadaProfAdm = new FachadaProfessorAdm();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
