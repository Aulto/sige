package sige.gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CadastrarSIGE extends JFrame {

	private JLabel labelCpf, labelNome, labelSenha, labelRepetirSenha,
			labelEmail, labelEndereco, labelTelefone, labelCelular;
	private JTextField cpf, nome, email, endereco, telefone, celular;
	private JPasswordField senha, repetirSenha;
	private JRadioButton aluno, professor;
	private JButton botaoCadastrar, botaoCancelar;

	public CadastrarSIGE() {
		super();
		
		this.setSize(150, 500);
		this.setTitle("Cadastrar");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		labelCpf = new JLabel("CPF: ");
		labelNome = new JLabel("Nome: ");
		labelSenha = new JLabel("Senha: ");
		labelRepetirSenha = new JLabel("Repetir Senha: ");
		labelEmail = new JLabel("Email: ");
		labelEndereco = new JLabel("Endereço: ");
		labelTelefone = new JLabel("Telefone: ");
		labelCelular = new JLabel("Celular: ");
		cpf = new JTextField(10);
		nome = new JTextField(10);
		email = new JTextField(10);
		endereco = new JTextField(10);
		telefone = new JTextField(10);
		celular = new JTextField(10);
		senha = new JPasswordField(10);
		repetirSenha = new JPasswordField(10);
		aluno = new JRadioButton("Aluno");
		professor = new JRadioButton("Professor");
		botaoCadastrar = new JButton("Cadastrar");
		botaoCancelar = new JButton("Cancelar");
		
		this.add(labelCpf);
		this.add(cpf);
		this.add(labelNome);
		this.add(nome);
		this.add(labelSenha);
		this.add(senha);
		this.add(labelRepetirSenha);
		this.add(repetirSenha);
		this.add(labelEmail);
		this.add(email);
		this.add(labelEndereco);
		this.add(endereco);
		this.add(labelTelefone);
		this.add(telefone);
		this.add(labelCelular);
		this.add(celular);
		this.add(aluno);
		this.add(professor);
		this.add(botaoCadastrar);
		this.add(botaoCancelar);
	}
}
