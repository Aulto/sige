package sige.gui;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
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
import sige.sistema.ProfessorAdministrador;
import sige.sistema.Sige;

public class Cadastrar extends JFrame {

<<<<<<< HEAD
	private JPanel contentPane;
	private JPanel panel;
	private JComboBox cbUf;
	private JButton btnCancelar;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtRg;
	private JFormattedTextField txtDataNiver;
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
	private JFormattedTextField txtCep;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblPas;
	private JTextField txtPais;
	private JLabel lblTelefone;
	private JFormattedTextField txtCelular;
	private JLabel lblCelular;
	private JFormattedTextField txtTelefone;
	private ISige sistema;
	private JTextField textField;
	public JComboBox cbSexo;

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
		setBounds(100, 100, 500, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 10, 45, 15);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(120, 10, 340, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 35, 46, 14);
		contentPane.add(lblCpf);

		MaskFormatter txtFormatCpf;
		try {
			txtFormatCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(txtFormatCpf);
			txtCpf.setSize(120, 20);
			txtCpf.setLocation(120, 35);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatação.");
		}
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(250, 35, 46, 14);
		contentPane.add(lblRg);

		MaskFormatter txtFormatRg;
		try {
			txtFormatRg = new MaskFormatter("#.###.###");
			txtRg = new JFormattedTextField(txtFormatRg);
			txtRg.setSize(120, 20);
			txtRg.setLocation(340, 35);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatação.");
		}
		contentPane.add(txtRg);
		txtRg.setColumns(10);

		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 160, 60, 14);
		contentPane.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(120, 160, 340, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(120, 110, 340, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (validar()) {
						if (panel.isVisible()) {
							if (tipo() == Professor.class) {
								sistema.adicionarProfessorAdm(Professor.class,
										txtNome.getText(), txtCpf.getText(),
										txtRg.getText(),
										new String(pwSenha.getPassword()),
										cbSexo.getSelectedItem().toString(),
										"", txtDataNiver.getText(), txtEmail
												.getText(), txtCelular
												.getText(), txtTelefone
												.getText(), txtEndereco
												.getText(),
										txtBairro.getText(), txtCidade
												.getText(), cbUf
												.getSelectedItem().toString(),
										txtComplemento.getText(), txtCep
												.getText(),
										txtNumero.getText(), txtPais.getText());
							} else if (!((JCheckBox) panel.getComponent(0))
									.isSelected()
									&& ((JCheckBox) panel.getComponent(1))
											.isSelected()) {
								sistema.adicionarProfessorAdm(
										Administrador.class, txtNome.getText(),
										txtCpf.getText(), txtRg.getText(),
										new String(pwSenha.getPassword()),
										cbSexo.getSelectedItem().toString(),
										"", txtDataNiver.getText(), txtEmail
												.getText(), txtCelular
												.getText(), txtTelefone
												.getText(), txtEndereco
												.getText(),
										txtBairro.getText(), txtCidade
												.getText(), cbUf
												.getSelectedItem().toString(),
										txtComplemento.getText(), txtCep
												.getText(),
										txtNumero.getText(), txtPais.getText());
								JFrame login = (JFrame) Login.getFrames()[0];
								login.setVisible(true);
								setVisible(false);
							}
						} else {
							sistema.adicionarAluno(txtNome.getText(), txtCpf
									.getText(), txtRg.getText(), new String(
									pwSenha.getPassword()), cbSexo
									.getSelectedItem().toString(), "",
									txtDataNiver.getText(), txtEmail.getText(),
									txtCelular.getText(),
									txtTelefone.getText(),
									txtEndereco.getText(), txtBairro.getText(),
									txtCidade.getText(), cbUf.getSelectedItem()
											.toString(), txtComplemento
											.getText(), txtCep.getText(),
									txtNumero.getText(), txtPais.getText());
						}
					}
					JOptionPane.showMessageDialog(null,
							"Cadastro Realizado com sucesso");
					resetar();
					setVisible(false);
					Main.historico.setVisible(true);
					if (Main.historico.getClass() != Login.class) {
						Main.historico.setEnabled(true);
						((IFachadas)Main.historico).carregarListas();
					}
				} catch (ProblemaInterno e) {
					JOptionPane.showMessageDialog(null, e);
				} catch (AutenticacaoException e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnCadastrar.setBounds(250, 266, 100, 23);
		contentPane.add(btnCadastrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetar();
				Main.historico.setVisible(true);
				if (Main.historico.getClass() != Login.class) {
					Main.historico.setEnabled(true);
					((IFachadas)Main.historico).carregarListas();
				}
				setVisible(false);				
			}
		});
		btnCancelar.setBounds(360, 266, 100, 23);
		contentPane.add(btnCancelar);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(9, 110, 46, 14);
		contentPane.add(lblEmail);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(9, 185, 46, 14);
		contentPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(120, 185, 120, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(250, 185, 46, 14);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(340, 185, 120, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(9, 60, 46, 14);
		contentPane.add(lblSenha);

		pwSenha = new JPasswordField();
		pwSenha.setBounds(120, 60, 120, 20);
		contentPane.add(pwSenha);

		lblRepetirSenha = new JLabel("Repetir Senha:");
		lblRepetirSenha.setBounds(250, 60, 100, 14);
		contentPane.add(lblRepetirSenha);

		pwRepetirSenha = new JPasswordField();
		pwRepetirSenha.setBounds(340, 60, 120, 20);
		contentPane.add(pwRepetirSenha);

		cbUf = new JComboBox();
		cbUf.setBounds(400, 235, 60, 20);
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
		lblUf.setBounds(360, 235, 46, 14);
		contentPane.add(lblUf);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(120, 210, 161, 20);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(9, 206, 82, 14);
		contentPane.add(lblComplemento);

		lblCep = new JLabel("Cep:");
		lblCep.setBounds(9, 235, 46, 14);
		contentPane.add(lblCep);

		MaskFormatter txtFormatCep;
		try {
			txtFormatCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(txtFormatCep);
			txtCep.setSize(120, 20);
			txtCep.setLocation(120, 235);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatação.");
		}
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(250, 235, 53, 14);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(310, 235, 45, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(290, 210, 46, 14);
		contentPane.add(lblPas);

		txtPais = new JTextField();
		txtPais.setBounds(320, 210, 140, 20);
		contentPane.add(txtPais);
		txtPais.setColumns(10);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 85, 80, 14);
		contentPane.add(lblTelefone);

		MaskFormatter txtFormatNumero;
		try {
			txtFormatNumero = new MaskFormatter("(##)####-####");
			txtCelular = new JFormattedTextField(txtFormatNumero);
			txtCelular.setSize(120, 20);
			txtCelular.setLocation(340, 85);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatação.");
		}
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);

		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(250, 85, 46, 14);
		contentPane.add(lblCelular);
		try {
			txtFormatNumero = new MaskFormatter("(##)####-####");
			txtTelefone = new JFormattedTextField(txtFormatNumero);
			txtTelefone.setSize(120, 20);
			txtTelefone.setLocation(120, 85);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatação.");
		}
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		panel = new JPanel();
		panel.setBounds(27, 266, 203, 23);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);

		JCheckBox chckbxProfessor = new JCheckBox("Professor");
		chckbxProfessor.setBounds(0, 0, 90, 23);
		panel.add(chckbxProfessor);

		JCheckBox chckbxAdministrador = new JCheckBox("Administrador");
		chckbxAdministrador.setBounds(90, 0, 120, 23);
		panel.add(chckbxAdministrador);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(10, 135, 109, 14);
		contentPane.add(lblDataDeNascimento);

		MaskFormatter txtFormatDataNiver;
		try {
			txtFormatDataNiver = new MaskFormatter("##/##/####");
			txtDataNiver = new JFormattedTextField(txtFormatDataNiver);
			txtDataNiver.setSize(120, 20);
			txtDataNiver.setLocation(120, 135);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatação.");
		}
		contentPane.add(txtDataNiver);
		txtDataNiver.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(250, 135, 46, 14);
		contentPane.add(lblSexo);

		cbSexo = new JComboBox();
		cbSexo.setBounds(340, 135, 120, 20);
		contentPane.add(cbSexo);

		cbSexo.addItem("Masculino");
		cbSexo.addItem("Feminino");
	}
	
	public Class<?> tipo() {
		if (((JCheckBox) panel.getComponent(0)).isSelected()
				&& !((JCheckBox) panel.getComponent(1)).isSelected()) {
			return Professor.class;
		} else if (!((JCheckBox) panel.getComponent(0)).isSelected()
				&& ((JCheckBox) panel.getComponent(1)).isSelected()) {
			return Administrador.class;
		} else {
			return ProfessorAdministrador.class;
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public boolean validar() {
		for (Component elemento : contentPane.getComponents()) {
			if (elemento instanceof JTextField) {
				if (((JTextField) elemento).getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos.");
					return false;
				}
			}
		}
		if (!(new String(pwSenha.getPassword())).equals(new String(
				pwRepetirSenha.getPassword()))) {
			JOptionPane.showMessageDialog(null, "As senhas devem ser iguais");
			return false;
		}
		if (txtTelefone.getText().equals("") && txtCep.getText().equals("")
				&& txtCpf.getText().equals("")
				&& txtDataNiver.getText().equals("")
				&& txtRg.getText().equals("")
				&& txtCelular.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
			return false;
		}
		if (panel.isVisible()) {
			if (!((JCheckBox) panel.getComponent(0)).isSelected()
					&& !((JCheckBox) panel.getComponent(1)).isSelected()) {
				JOptionPane
						.showMessageDialog(null, "Preencha todos os campos.");
				return false;
			}
		}
		return true;
	}

	public void resetar() {
		for (Component elemento : contentPane.getComponents()) {
			if (elemento instanceof JTextField) {
				((JTextField) elemento).setText("");
			}
		}
		txtTelefone.setText("");
		txtCep.setText("");
		txtCpf.setText("");
		txtDataNiver.setText("");
		txtRg.setText("");
		txtCelular.setText("");
		((JCheckBox) panel.getComponent(0)).setSelected(false);
		((JCheckBox) panel.getComponent(1)).setSelected(false);
		panel.setVisible(false);
		btnCancelar.setEnabled(true);
	}

	public void primeiroCadastro() {
		panel.setVisible(true);
		JCheckBox cp = (JCheckBox) panel.getComponent(1);
		cp.setSelected(true);
		cp.setEnabled(false);
		btnCancelar.setEnabled(false);
	}
=======
private JPanel contentPane;
private JPanel panel;
private JComboBox cbUf;
private JButton btnCancelar;
private JTextField txtNome;
private JFormattedTextField txtCpf;
private JFormattedTextField txtRg;
private JFormattedTextField txtDataNiver;
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
private JFormattedTextField txtCep;
private JLabel lblNumero;
private JTextField txtNumero;
private JLabel lblPas;
private JTextField txtPais;
private JLabel lblTelefone;
private JFormattedTextField txtCelular;
private JLabel lblCelular;
private JFormattedTextField txtTelefone;
private ISige sistema;
private JTextField textField;
public JComboBox cbSexo;

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
setBounds(100, 100, 500, 325);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNome = new JLabel("Nome:");
lblNome.setBounds(10, 10, 45, 15);
contentPane.add(lblNome);

txtNome = new JTextField();
txtNome.setBounds(120, 10, 340, 20);
contentPane.add(txtNome);
txtNome.setColumns(10);

JLabel lblCpf = new JLabel("CPF:");
lblCpf.setBounds(10, 35, 46, 14);
contentPane.add(lblCpf);

MaskFormatter txtFormatCpf;
try {
txtFormatCpf = new MaskFormatter("###.###.###-##");
txtCpf = new JFormattedTextField(txtFormatCpf);
txtCpf.setSize(120, 20);
txtCpf.setLocation(120, 35);
} catch (ParseException e1) {
JOptionPane.showMessageDialog(null,
"Ocorreu um problema na formatação.");
}
contentPane.add(txtCpf);
txtCpf.setColumns(10);

JLabel lblRg = new JLabel("RG:");
lblRg.setBounds(250, 35, 46, 14);
contentPane.add(lblRg);

MaskFormatter txtFormatRg;
try {
txtFormatRg = new MaskFormatter("#.###.###");
txtRg = new JFormattedTextField(txtFormatRg);
txtRg.setSize(120, 20);
txtRg.setLocation(340, 35);
} catch (ParseException e1) {
JOptionPane.showMessageDialog(null,
"Ocorreu um problema na formatação.");
}
contentPane.add(txtRg);
txtRg.setColumns(10);

lblEndereo = new JLabel("Endere\u00E7o:");
lblEndereo.setBounds(10, 160, 60, 14);
contentPane.add(lblEndereo);

txtEndereco = new JTextField();
txtEndereco.setBounds(120, 160, 340, 20);
contentPane.add(txtEndereco);
txtEndereco.setColumns(10);

txtEmail = new JTextField();
txtEmail.setBounds(120, 110, 340, 20);
contentPane.add(txtEmail);
txtEmail.setColumns(10);

JButton btnCadastrar = new JButton("Cadastrar");
btnCadastrar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
try {
if (validar()) {
if (panel.isVisible()) {
if (tipo() == Professor.class) {
sistema.adicionarProfessorAdm(Professor.class,
txtNome.getText(), txtCpf.getText(),
txtRg.getText(),
new String(pwSenha.getPassword()),
cbSexo.getSelectedItem().toString(),
"", txtDataNiver.getText(), txtEmail
.getText(), txtCelular
.getText(), txtTelefone
.getText(), txtEndereco
.getText(),
txtBairro.getText(), txtCidade
.getText(), cbUf
.getSelectedItem().toString(),
txtComplemento.getText(), txtCep
.getText(),
txtNumero.getText(), txtPais.getText());
} else if (!((JCheckBox) panel.getComponent(0))
.isSelected()
&& ((JCheckBox) panel.getComponent(1))
.isSelected()) {
sistema.adicionarProfessorAdm(
Administrador.class, txtNome.getText(),
txtCpf.getText(), txtRg.getText(),
new String(pwSenha.getPassword()),
cbSexo.getSelectedItem().toString(),
"", txtDataNiver.getText(), txtEmail
.getText(), txtCelular
.getText(), txtTelefone
.getText(), txtEndereco
.getText(),
txtBairro.getText(), txtCidade
.getText(), cbUf
.getSelectedItem().toString(),
txtComplemento.getText(), txtCep
.getText(),
txtNumero.getText(), txtPais.getText());
JFrame login = (JFrame) Login.getFrames()[0];
login.setVisible(true);
setVisible(false);
}
} else {
sistema.adicionarAluno(txtNome.getText(), txtCpf
.getText(), txtRg.getText(), new String(
pwSenha.getPassword()), cbSexo
.getSelectedItem().toString(), "",
txtDataNiver.getText(), txtEmail.getText(),
txtCelular.getText(),
txtTelefone.getText(),
txtEndereco.getText(), txtBairro.getText(),
txtCidade.getText(), cbUf.getSelectedItem()
.toString(), txtComplemento
.getText(), txtCep.getText(),
txtNumero.getText(), txtPais.getText());
}
}
JOptionPane.showMessageDialog(null,
"Cadastro Realizado com sucesso");
resetar();
setVisible(false);
Main.historico.setVisible(true);
} catch (ProblemaInterno e) {
JOptionPane.showMessageDialog(null, e);
} catch (AutenticacaoException e) {
JOptionPane.showMessageDialog(null, e);
}
}
});
btnCadastrar.setBounds(250, 266, 100, 23);
contentPane.add(btnCadastrar);

btnCancelar = new JButton("Cancelar");
btnCancelar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
Main.historico.setVisible(true);
setVisible(false);	
}
});
btnCancelar.setBounds(360, 266, 100, 23);
contentPane.add(btnCancelar);

lblEmail = new JLabel("Email:");
lblEmail.setBounds(9, 110, 46, 14);
contentPane.add(lblEmail);

lblBairro = new JLabel("Bairro:");
lblBairro.setBounds(9, 185, 46, 14);
contentPane.add(lblBairro);

txtBairro = new JTextField();
txtBairro.setBounds(120, 185, 120, 20);
contentPane.add(txtBairro);
txtBairro.setColumns(10);

lblCidade = new JLabel("Cidade:");
lblCidade.setBounds(250, 185, 46, 14);
contentPane.add(lblCidade);

txtCidade = new JTextField();
txtCidade.setBounds(340, 185, 120, 20);
contentPane.add(txtCidade);
txtCidade.setColumns(10);

lblSenha = new JLabel("Senha:");
lblSenha.setBounds(9, 60, 46, 14);
contentPane.add(lblSenha);

pwSenha = new JPasswordField();
pwSenha.setBounds(120, 60, 120, 20);
contentPane.add(pwSenha);

lblRepetirSenha = new JLabel("Repetir Senha:");
lblRepetirSenha.setBounds(250, 60, 100, 14);
contentPane.add(lblRepetirSenha);

pwRepetirSenha = new JPasswordField();
pwRepetirSenha.setBounds(340, 60, 120, 20);
contentPane.add(pwRepetirSenha);

cbUf = new JComboBox();
cbUf.setBounds(400, 235, 60, 20);
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
lblUf.setBounds(360, 235, 46, 14);
contentPane.add(lblUf);

txtComplemento = new JTextField();
txtComplemento.setBounds(120, 210, 161, 20);
contentPane.add(txtComplemento);
txtComplemento.setColumns(10);

lblComplemento = new JLabel("Complemento:");
lblComplemento.setBounds(9, 206, 82, 14);
contentPane.add(lblComplemento);

lblCep = new JLabel("Cep:");
lblCep.setBounds(9, 235, 46, 14);
contentPane.add(lblCep);

MaskFormatter txtFormatCep;
try {
txtFormatCep = new MaskFormatter("#####-###");
txtCep = new JFormattedTextField(txtFormatCep);
txtCep.setSize(120, 20);
txtCep.setLocation(120, 235);
} catch (ParseException e1) {
JOptionPane.showMessageDialog(null,
"Ocorreu um problema na formatação.");
}
contentPane.add(txtCep);
txtCep.setColumns(10);

lblNumero = new JLabel("Numero:");
lblNumero.setBounds(250, 235, 53, 14);
contentPane.add(lblNumero);

txtNumero = new JTextField();
txtNumero.setBounds(310, 235, 45, 20);
contentPane.add(txtNumero);
txtNumero.setColumns(10);

lblPas = new JLabel("Pa\u00EDs:");
lblPas.setBounds(290, 210, 46, 14);
contentPane.add(lblPas);

txtPais = new JTextField();
txtPais.setBounds(320, 210, 140, 20);
contentPane.add(txtPais);
txtPais.setColumns(10);

lblTelefone = new JLabel("Telefone:");
lblTelefone.setBounds(10, 85, 80, 14);
contentPane.add(lblTelefone);

MaskFormatter txtFormatNumero;
try {
txtFormatNumero = new MaskFormatter("(##)####-####");
txtCelular = new JFormattedTextField(txtFormatNumero);
txtCelular.setSize(120, 20);
txtCelular.setLocation(340, 85);
} catch (ParseException e1) {
JOptionPane.showMessageDialog(null,
"Ocorreu um problema na formatação.");
}
contentPane.add(txtCelular);
txtCelular.setColumns(10);

lblCelular = new JLabel("Celular:");
lblCelular.setBounds(250, 85, 46, 14);
contentPane.add(lblCelular);
try {
txtFormatNumero = new MaskFormatter("(##)####-####");
txtTelefone = new JFormattedTextField(txtFormatNumero);
txtTelefone.setSize(120, 20);
txtTelefone.setLocation(120, 85);
} catch (ParseException e1) {
JOptionPane.showMessageDialog(null,
"Ocorreu um problema na formatação.");
}
contentPane.add(txtTelefone);
txtTelefone.setColumns(10);

panel = new JPanel();
panel.setBounds(27, 266, 203, 23);
contentPane.add(panel);
panel.setLayout(null);
panel.setVisible(false);

JCheckBox chckbxProfessor = new JCheckBox("Professor");
chckbxProfessor.setBounds(0, 0, 90, 23);
panel.add(chckbxProfessor);

JCheckBox chckbxAdministrador = new JCheckBox("Administrador");
chckbxAdministrador.setBounds(90, 0, 120, 23);
panel.add(chckbxAdministrador);

JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
lblDataDeNascimento.setBounds(10, 135, 109, 14);
contentPane.add(lblDataDeNascimento);

MaskFormatter txtFormatDataNiver;
try {
txtFormatDataNiver = new MaskFormatter("##/##/####");
txtDataNiver = new JFormattedTextField(txtFormatDataNiver);
txtDataNiver.setSize(120, 20);
txtDataNiver.setLocation(120, 135);
} catch (ParseException e1) {
JOptionPane.showMessageDialog(null,
"Ocorreu um problema na formatação.");
}
contentPane.add(txtDataNiver);
txtDataNiver.setColumns(10);

JLabel lblSexo = new JLabel("Sexo:");
lblSexo.setBounds(250, 135, 46, 14);
contentPane.add(lblSexo);

cbSexo = new JComboBox();
cbSexo.setBounds(340, 135, 120, 20);
contentPane.add(cbSexo);

cbSexo.addItem("Masculino");
cbSexo.addItem("Feminino");
}

public Class<?> tipo() {
if (((JCheckBox) panel.getComponent(0)).isSelected()
&& !((JCheckBox) panel.getComponent(1)).isSelected()) {
return Professor.class;
} else if (!((JCheckBox) panel.getComponent(0)).isSelected()
&& ((JCheckBox) panel.getComponent(1)).isSelected()) {
return Administrador.class;
} else {
return ProfessorAdministrador.class;
}
}

public JPanel getPanel() {
return panel;
}

public boolean validar() {
for (Component elemento : contentPane.getComponents()) {
if (elemento instanceof JTextField) {
if (((JTextField) elemento).getText().equals("")) {
JOptionPane.showMessageDialog(null,
"Preencha todos os campos.");
return false;
}
}
}
if (!(new String(pwSenha.getPassword())).equals(new String(
pwRepetirSenha.getPassword()))) {
JOptionPane.showMessageDialog(null, "As senhas devem ser iguais");
return false;
}
if (txtTelefone.getText().equals("") && txtCep.getText().equals("")
&& txtCpf.getText().equals("")
&& txtDataNiver.getText().equals("")
&& txtRg.getText().equals("")
&& txtCelular.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
return false;
}
if (panel.isVisible()) {
if (!((JCheckBox) panel.getComponent(0)).isSelected()
&& !((JCheckBox) panel.getComponent(1)).isSelected()) {
JOptionPane
.showMessageDialog(null, "Preencha todos os campos.");
return false;
}
}
return true;
}

public void resetar() {
for (Component elemento : contentPane.getComponents()) {
if (elemento instanceof JTextField) {
((JTextField) elemento).setText("");
}
}
txtTelefone.setText("");
txtCep.setText("");
txtCpf.setText("");
txtDataNiver.setText("");
txtRg.setText("");
txtCelular.setText("");
((JCheckBox) panel.getComponent(0)).setSelected(false);
((JCheckBox) panel.getComponent(1)).setSelected(false);
panel.setVisible(false);
btnCancelar.setEnabled(true);
}

public void primeiroCadastro() {
panel.setVisible(true);
JCheckBox cp = (JCheckBox) panel.getComponent(1);
cp.setSelected(true);
cp.setEnabled(false);
btnCancelar.setEnabled(false);
}
>>>>>>> d9a103c05ec6680d2890d8ef9427a70ab24c0e63
}