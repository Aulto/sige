package sige.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class Cadastrar extends JFrame {

	private JPanel contentPane;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar frame = new Cadastrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastrar() {
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
		txtNome.setBounds(93, 10, 340, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 35, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(93, 35, 120, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(223, 35, 46, 14);
		contentPane.add(lblRg);
		
		txtRg = new JTextField();
		txtRg.setBounds(314, 35, 120, 20);
		contentPane.add(txtRg);
		txtRg.setColumns(10);
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(9, 135, 60, 14);
		contentPane.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(92, 135, 340, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(92, 110, 340, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(224, 237, 100, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(334, 237, 100, 23);
		contentPane.add(btnCancelar);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(9, 110, 46, 14);
		contentPane.add(lblEmail);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(8, 160, 46, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(92, 160, 120, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(222, 160, 46, 14);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
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
		
		JComboBox cbUf = new JComboBox();
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
		txtCep.setBounds(91, 210, 120, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(221, 210, 53, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(277, 210, 45, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(263, 185, 46, 14);
		contentPane.add(lblPas);
		
		txtPais = new JTextField();
		txtPais.setBounds(293, 185, 138, 20);
		contentPane.add(txtPais);
		txtPais.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 85, 80, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(93, 85, 120, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(223, 85, 46, 14);
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(314, 85, 119, 20);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		JPanel panel = new JPanel();
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
}
