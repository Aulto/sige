package sige.gui;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import sige.sistema.Administrador;
import sige.sistema.AutenticacaoException;
import sige.sistema.ISige;
import sige.sistema.InicializacaoSistemaException;
import sige.sistema.ProblemaInterno;
import sige.sistema.Professor;
import sige.sistema.Sige;

public class Cadastrar extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JComboBox cbUf;
	private JButton btnCancelar;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JLabel lblEndereo;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JLabel lblSenha;
	private JPasswordField pwSenha;
	private JLabel lblRepetirSenha;
	private JPasswordField pwRepetirSenha;
	private JLabel lblComplemento;
	private JTextField txtComplemento;
	private JLabel lblCep;
	private JTextField txtCep;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblPas;
	private JTextField txtPais;
	private JLabel lblTelefone;
	private JTextField txtTelefone;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private ISige sistema;

	/**
	 * Create the frame.
	 */
	public Cadastrar() {
		try {
			sistema = Sige.getInstance();
		} catch (InicializacaoSistemaException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		setResizable(false);
		setTitle("Cadastrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 10, 45, 15);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setText("nome");
		txtNome.setBounds(93, 10, 340, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 35, 46, 14);
		contentPane.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setText("cpf");
		txtCpf.setBounds(93, 35, 120, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(223, 35, 46, 14);
		contentPane.add(lblRg);

		txtRg = new JTextField();
		txtRg.setText("rg");
		txtRg.setBounds(314, 35, 120, 20);
		contentPane.add(txtRg);
		txtRg.setColumns(10);

		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(9, 135, 60, 14);
		contentPane.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setText("rua");
		txtEndereco.setBounds(92, 135, 340, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setText("email");
		txtEmail.setBounds(92, 110, 340, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					for (Component elemento : contentPane.getComponents()) {
						if (elemento instanceof JTextField) {
							if (((JTextField) elemento).getText().equals("")) {
								JOptionPane.showMessageDialog(null,
										"Preencha todos os campos.");
								break;
							}
						}
					}
					if (!(new String(pwSenha.getPassword())).equals(new String(
							pwRepetirSenha.getPassword()))) {
						JOptionPane.showMessageDialog(null,
								"As senhas devem ser iguais");
					}
					if (panel.isVisible()) {
						System.out.println("Panel visible true");
						if (!((JCheckBox) panel.getComponent(0)).isSelected()
								&& !((JCheckBox) panel.getComponent(1))
										.isSelected()) {
							JOptionPane.showMessageDialog(null,
									"Preencha todos os campos.");
						} else if (((JCheckBox) panel.getComponent(0))
								.isSelected()
								&& !((JCheckBox) panel.getComponent(1))
										.isSelected()) {
							System.out.println("Professor");
							sistema.adicionarProfessorAdm(Professor.class,
									txtNome.getText(),
									new String(pwSenha.getPassword()), "", "",
									"", txtEmail.getText(), txtTelefone
											.getText(), txtCelular.getText(),
									txtEndereco.getText(), txtBairro.getText(),
									txtCidade.getText(), cbUf.getSelectedItem()
											.toString(), txtComplemento
											.getText(), txtCep.getText(),
									txtNumero.getText(), txtPais.getText());
						} else if (!((JCheckBox) panel.getComponent(0))
								.isSelected()
								&& ((JCheckBox) panel.getComponent(1))
										.isSelected()) {
							System.out.println("Administrador");
							sistema.adicionarProfessorAdm(Administrador.class,
									  txtNome.getText(), new
									  String(pwSenha.getPassword()), "", "", "",
									  txtEmail.getText(), txtTelefone.getText(),
									  txtCelular.getText(), txtEndereco.getText(),
									  txtBairro.getText(), txtCidade.getText(), cbUf
									 .getSelectedItem().toString(),
									  txtComplemento.getText(), txtCep.getText(),
									  txtNumero.getText(), txtPais.getText());
							JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
							JFrame login = (JFrame) Login.getFrames()[0];
							login.setVisible(true);
							setVisible(false);
						}
					} else {
						System.out.println("Aluno");
						System.out.println("21323");
						sistema.adicionarAluno(txtNome.getText(), new String(
								pwSenha.getPassword()), "", "", "", txtEmail
								.getText(), txtTelefone.getText(), txtCelular
								.getText(), txtEndereco.getText(), txtBairro
								.getText(), txtCidade.getText(), cbUf
								.getSelectedItem().toString(), txtComplemento
								.getText(), txtCep.getText(), txtNumero
								.getText(), txtPais.getText());
					}

				} catch (ProblemaInterno e) {
					JOptionPane.showMessageDialog(null, e);
				} catch (AutenticacaoException e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnCadastrar.setBounds(224, 237, 100, 23);
		contentPane.add(btnCadastrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame login = (JFrame) Login.getFrames()[0];
				login.setVisible(true);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(334, 237, 100, 23);
		contentPane.add(btnCancelar);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(9, 110, 46, 14);
		contentPane.add(lblEmail);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(8, 160, 46, 14);
		contentPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setText("bair");
		txtBairro.setBounds(92, 160, 120, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(222, 160, 46, 14);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setText("ct");
		txtCidade.setBounds(312, 160, 120, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(9, 60, 46, 14);
		contentPane.add(lblSenha);

		pwSenha = new JPasswordField();
		pwSenha.setBounds(93, 60, 120, 20);
		contentPane.add(pwSenha);

		lblRepetirSenha = new JLabel("Repetir Senha:");
		lblRepetirSenha.setBounds(223, 60, 100, 14);
		contentPane.add(lblRepetirSenha);

		pwRepetirSenha = new JPasswordField();
		pwRepetirSenha.setBounds(313, 60, 120, 20);
		contentPane.add(pwRepetirSenha);

		cbUf = new JComboBox();
		cbUf.setBounds(371, 210, 60, 20);
		cbUf.addItem("AC");
		cbUf.addItem("AL");
		cbUf.addItem("AP");
		cbUf.addItem("AM");
		cbUf.addItem("BA");
		cbUf.addItem("CE");
		cbUf.addItem("DF");
		cbUf.addItem("ES");
		cbUf.addItem("GO");
		cbUf.addItem("MA");
		cbUf.addItem("MT");
		cbUf.addItem("MS");
		cbUf.addItem("MG");
		cbUf.addItem("PA");
		cbUf.addItem("PB");
		cbUf.addItem("PR");
		cbUf.addItem("PE");
		cbUf.addItem("PI");
		cbUf.addItem("RJ");
		cbUf.addItem("RN");
		cbUf.addItem("RS");
		cbUf.addItem("RO");
		cbUf.addItem("RR");
		cbUf.addItem("SC");
		cbUf.addItem("SP");
		cbUf.addItem("SE");
		cbUf.addItem("TO");
		contentPane.add(cbUf);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(333, 210, 46, 14);
		contentPane.add(lblUf);

		txtComplemento = new JTextField();
		txtComplemento.setText("comple");
		txtComplemento.setBounds(92, 185, 161, 20);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(8, 181, 82, 14);
		contentPane.add(lblComplemento);

		lblCep = new JLabel("Cep:");
		lblCep.setBounds(8, 210, 46, 14);
		contentPane.add(lblCep);

		txtCep = new JTextField();
		txtCep.setText("asd");
		txtCep.setBounds(91, 210, 120, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(221, 210, 53, 14);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setText("numero");
		txtNumero.setBounds(277, 210, 45, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(263, 185, 46, 14);
		contentPane.add(lblPas);

		txtPais = new JTextField();
		txtPais.setText("pa\u00EDs");
		txtPais.setBounds(293, 185, 138, 20);
		contentPane.add(txtPais);
		txtPais.setColumns(10);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 85, 80, 14);
		contentPane.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setText("tel");
		txtTelefone.setBounds(93, 85, 120, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(223, 85, 46, 14);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setText("cel");
		txtCelular.setBounds(314, 85, 119, 20);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);

		panel = new JPanel();
		panel.setBounds(10, 237, 203, 23);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);

		JCheckBox chckbxProfessor = new JCheckBox("Professor");
		chckbxProfessor.setBounds(0, 0, 90, 23);
		panel.add(chckbxProfessor);

		JCheckBox chckbxAdministrador = new JCheckBox("Administrador");
		chckbxAdministrador.setBounds(90, 0, 120, 23);
		panel.add(chckbxAdministrador);
	}

	public void primeiroCadastro() {
		panel.setVisible(true);
		JCheckBox cp = (JCheckBox) panel.getComponent(1);
		cp.setSelected(true);
		cp.setEnabled(false);
		btnCancelar.setEnabled(false);
	}
}
