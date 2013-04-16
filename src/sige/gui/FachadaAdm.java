package sige.gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxEditor;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JViewport;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class FachadaAdm extends JFrame {

	private JPanel contentPane;
	private JPanel panelBuscaAluno;
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
	private JLabel lblBuscarProf;
	private JTextField txtBuscarProf;
	private JTextField txtBuscarAdm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FachadaAdm frame = new FachadaAdm();
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
	public FachadaAdm() {
		setTitle("SIGE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 579, 356);
		contentPane.add(tabbedPane);

		JPanel panelPerfil = new JPanel();
		panelPerfil.setLayout(null);
		tabbedPane.addTab("Perfil", null, panelPerfil, null);

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

		txtUf = new JTextField();
		txtUf.setText("Pe");
		txtUf.setEditable(false);
		txtUf.setBounds(290, 217, 120, 20);
		panelPerfil.add(txtUf);
		txtUf.setColumns(10);

		panelBuscaAluno = new JPanel();
		tabbedPane.addTab("Buscar Aluno", null, panelBuscaAluno, null);
		panelBuscaAluno.setLayout(null);

		JLabel lblBuscarAluno = new JLabel("Buscar:");
		lblBuscarAluno.setBounds(30, 14, 60, 14);
		panelBuscaAluno.add(lblBuscarAluno);

		txtBuscarAluno = new JTextField();
		txtBuscarAluno.setBounds(89, 11, 260, 20);
		txtBuscarAluno.setColumns(10);
		panelBuscaAluno.add(txtBuscarAluno);

		JLabel lblPorAluno = new JLabel("Por:");
		lblPorAluno.setBounds(359, 14, 39, 14);
		panelBuscaAluno.add(lblPorAluno);

		JComboBox cbPorAluno = new JComboBox();
		cbPorAluno.setBounds(399, 11, 60, 20);
		panelBuscaAluno.add(cbPorAluno);

		cbPorAluno.addItem("Nome");
		cbPorAluno.addItem("CPF");

		JButton btnBucarAluno = new JButton("Buscar");
		btnBucarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cp = (JComboBox) panelBuscaAluno.getComponentAt(399,
						11);
				String item = cp.getSelectedItem().toString();

			}
		});
		btnBucarAluno.setBounds(469, 11, 80, 20);
		panelBuscaAluno.add(btnBucarAluno);

		
		String[] o = new String[30];
		for (int i = 0; i < 30; i++) {
			o[i] = " " + i;
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(70, 40, 420, 250);
		panelBuscaAluno.add(scrollPane);
		
		JList listAluno = new JList(o);
		listAluno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAluno.setBounds(70, 40, 420, 250);
		//panelBuscaAluno.add(listAluno);
		
		scrollPane.setViewportView(listAluno);
		
		JButton btnExibirPerfilAluno = new JButton("Exibir Perfil");
		btnExibirPerfilAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JList cp = (JList) panelBuscaAluno.getComponentAt(70, 40).getComponentAt(70, 40).getComponentAt(70, 40);
								
				if (!cp.isSelectionEmpty()) {
					String item = cp.getSelectedValue().toString();
					txtBuscarAluno.setText(item);
					
				}
			}
		});
		btnExibirPerfilAluno.setBounds(230, 300, 100, 20);
		panelBuscaAluno.add(btnExibirPerfilAluno);

		JPanel panelBuscaProfessor = new JPanel();
		tabbedPane.addTab("Buscar Professor", null, panelBuscaProfessor, null);
		panelBuscaProfessor.setLayout(null);

		lblBuscarProf = new JLabel("Buscar:");
		lblBuscarProf.setBounds(30, 14, 60, 14);
		panelBuscaProfessor.add(lblBuscarProf);

		txtBuscarProf = new JTextField();
		txtBuscarProf.setText("");
		txtBuscarProf.setBounds(89, 11, 260, 20);
		panelBuscaProfessor.add(txtBuscarProf);
		txtBuscarProf.setColumns(10);

		JLabel lblPorProf = new JLabel("Por:");
		lblPorProf.setBounds(359, 14, 39, 14);
		panelBuscaProfessor.add(lblPorProf);

		JComboBox cbPorProf = new JComboBox();
		cbPorProf.setBounds(399, 11, 60, 20);
		panelBuscaProfessor.add(cbPorProf);

		cbPorProf.addItem("Nome");
		cbPorProf.addItem("CPF");

		JButton btnBuscarProf = new JButton("Buscar");
		btnBuscarProf.setBounds(469, 11, 80, 20);
		panelBuscaProfessor.add(btnBuscarProf);

		JList listProf = new JList();
		listProf.setBounds(70, 40, 420, 250);
		panelBuscaProfessor.add(listProf);

		JButton btnExibirPerfilProf = new JButton("Exibir Perfil");
		btnExibirPerfilProf.setBounds(230, 300, 100, 20);
		panelBuscaProfessor.add(btnExibirPerfilProf);

		JPanel panelAdm = new JPanel();
		tabbedPane.addTab("Buscar Administrador", null, panelAdm, null);
		panelAdm.setLayout(null);

		JLabel lblBuscarAdm = new JLabel("Buscar:");
		lblBuscarAdm.setBounds(30, 14, 60, 14);
		panelAdm.add(lblBuscarAdm);

		txtBuscarAdm = new JTextField();
		txtBuscarAdm.setBounds(89, 11, 260, 20);
		panelAdm.add(txtBuscarAdm);
		txtBuscarAdm.setColumns(10);

		JLabel lblPorAdm = new JLabel("Por:");
		lblPorAdm.setBounds(359, 14, 39, 14);
		panelAdm.add(lblPorAdm);

		JComboBox cbPorAdm = new JComboBox();
		cbPorAdm.setBounds(399, 11, 60, 20);
		panelAdm.add(cbPorAdm);

		cbPorAdm.addItem("Nome");
		cbPorAdm.addItem("CPF");

		JButton btnBuscarAdm = new JButton("Buscar");
		btnBuscarAdm.setBounds(469, 11, 80, 20);
		panelAdm.add(btnBuscarAdm);

		JList listAdm = new JList();
		listAdm.setBounds(70, 40, 420, 250);
		panelAdm.add(listAdm);

		JButton btnExibirPerfilAdm = new JButton("Exibir Perfil");
		btnExibirPerfilAdm.setBounds(230, 300, 100, 20);
		panelAdm.add(btnExibirPerfilAdm);
	}
}
