package sige.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JPasswordField pwSenha;

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("SIGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(58, 100, 100, 30);
		contentPane.add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Cadastrar.getFrames().length);
				JFrame cadastrar = (JFrame) Cadastrar.getFrames()[1];
				cadastrar.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrar.setBounds(168, 100, 100, 30);
		contentPane.add(btnCadastrar);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(44, 31, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(44, 56, 46, 14);
		contentPane.add(lblSenha);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(100, 29, 150, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		
		pwSenha = new JPasswordField();
		pwSenha.setBounds(100, 54, 150, 20);
		contentPane.add(pwSenha);


	}
}
