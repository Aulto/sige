package sige.gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginSIGE extends JFrame {
	
	private JTextField cpf;
	private JPasswordField senha;
	private JButton botaoLogin, botaoCadastrar;
	private JLabel labelCpf, labelSenha;
	
	public LoginSIGE(){
		super();
		this.setSize(200, 150);
		this.setTitle("Login");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cpf = new JTextField(10);
		senha = new JPasswordField(10);
		labelCpf = new JLabel("CPF:     ");
		labelSenha = new JLabel("Senha: ");
		botaoLogin = new JButton("Login");
		botaoCadastrar = new JButton("Cadastrar");
		this.add(labelCpf);
		this.add(cpf);
		this.add(labelSenha);
		this.add(senha);
		this.add(botaoLogin);
		this.add(botaoCadastrar);
	}	
}
