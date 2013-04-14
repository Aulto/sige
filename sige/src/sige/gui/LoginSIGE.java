package sige.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sige.sige.ISige;
import sige.sige.InicializacaoSistemaException;
import sige.sige.Sige;

public class LoginSIGE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lbCpf, lbSenha;
	private JTextField txtCpf;
	private JPasswordField pwSenha;
	private JButton btEntrar, btCadastrar;
	private ISige sige;
	
	public LoginSIGE() {
		this.setSize(450, 70);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Login SIGE");
		
		lbCpf = new JLabel("CPF:");
		txtCpf = new JTextField(6);
		lbSenha = new JLabel("Senha:");
		pwSenha = new JPasswordField(6);
		btEntrar = new JButton("Entrar");
		btCadastrar = new JButton("Cadastrar");
		this.add(lbCpf);
		this.add(txtCpf);
		this.add(lbSenha);
		this.add(pwSenha);
		this.add(btEntrar);
		this.add(btCadastrar);
		init();
	}
	
	private void init(){
		try {
			this.sige = Sige.getInstance();
		} catch (InicializacaoSistemaException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível iniciar");
			e.printStackTrace(); System.exit(ERROR);
		}
		
		this.sige.adicionarAluno("luiz", "123", "123", null, null, null, null, null, null, null, null, null, null, null, null);
	}
	
	public static void main(String[] args) {
		LoginSIGE ls = new LoginSIGE();
		ls.setVisible(true);
	}
	
}
