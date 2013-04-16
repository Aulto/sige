package sige.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExibirPerfil extends JFrame {

	private JPanel panelPerfil;
	private JTextField txtBuscarAluno;
	private JTextField txtNome;
	private JTextField textField;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JTextField textEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JTextField txtCep;
	private JTextField txtPais;
	private JTextField txtNumero;
	private JTextField txtUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirPerfil frame = new ExibirPerfil();
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
	public ExibirPerfil() {
		setTitle("Perfil");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		panelPerfil = new JPanel();
		panelPerfil.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPerfil);
		panelPerfil.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(25, 20, 60, 14);
		panelPerfil.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(110, 20, 300, 20);
		panelPerfil.add(txtNome);
		txtNome.setText("Luiz Daniel ramos Fran\u00E7a");
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(25, 45, 60, 14);
		panelPerfil.add(lblCpf);
		
		textField = new JTextField();
		textField.setBounds(110, 45, 300, 20);
		panelPerfil.add(textField);
		textField.setEditable(false);
		textField.setText("082.323.434-78");
		textField.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(25, 70, 60, 14);
		panelPerfil.add(lblRg);
		
		txtRg = new JTextField();
		txtRg.setText("8.049.539");
		txtRg.setEditable(false);
		txtRg.setBounds(110, 70, 300, 17);
		panelPerfil.add(txtRg);
		txtRg.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(25, 95, 60, 14);
		panelPerfil.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText("luizdaniel.r.f@gmail.com");
		txtEmail.setEditable(false);
		txtEmail.setBounds(110, 95, 300, 20);
		panelPerfil.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(25, 120, 60, 14);
		panelPerfil.add(lblEndereco);
		
		textEndereco = new JTextField();
		textEndereco.setText("Avenida Beberibe");
		textEndereco.setEditable(false);
		textEndereco.setColumns(10);
		textEndereco.setBounds(110, 120, 300, 20);
		panelPerfil.add(textEndereco);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(25, 145, 46, 14);
		panelPerfil.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setText("\u00C1gua-Fria");
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(110, 145, 120, 20);
		panelPerfil.add(txtBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(240, 145, 46, 14);
		panelPerfil.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setText("Recife");
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(290, 145, 120, 20);
		panelPerfil.add(txtCidade);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(25, 170, 82, 14);
		panelPerfil.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setText("Bloco C; Apartamento 106");
		txtComplemento.setEditable(false);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(110, 170, 170, 20);
		panelPerfil.add(txtComplemento);
		
		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setBounds(25, 220, 46, 14);
		panelPerfil.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setText("Brasil");
		txtPais.setEditable(false);
		txtPais.setColumns(10);
		txtPais.setBounds(110, 220, 120, 20);
		panelPerfil.add(txtPais);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(25, 195, 46, 14);
		panelPerfil.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setText("52130-000");
		txtCep.setEditable(false);
		txtCep.setColumns(10);
		txtCep.setBounds(110, 195, 120, 20);
		panelPerfil.add(txtCep);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(240, 195, 53, 14);
		panelPerfil.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setText("2530");
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(290, 192, 120, 20);
		panelPerfil.add(txtNumero);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(240, 220, 46, 14);
		panelPerfil.add(lblUf);
	}
}
