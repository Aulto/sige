package sige.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import sige.repositorio.RepositorioException;
import sige.sistema.Autenticacao;
import sige.sistema.ISige;
import sige.sistema.Sige;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JPasswordField pwSenha;
	private ISige sistema;

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
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Autenticacao.logado(txtCpf.getText(), new String(
							pwSenha.getPassword()), sistema.getRepositorio())) {
						System.out.println("logado com sucesso");
					} else {
						System.out.println("Falha no login");
					}
				} catch (RepositorioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEntrar.setBounds(58, 100, 100, 30);
		contentPane.add(btnEntrar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		init();
	}

	private void init() {
		try {
			sistema = Sige.getInstance();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
