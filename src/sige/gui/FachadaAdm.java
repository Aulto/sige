package sige.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import sige.sistema.Autenticacao;
import sige.sistema.ISige;
import sige.sistema.InicializacaoSistemaException;
import sige.sistema.Pessoa;
import sige.sistema.Sige;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class FachadaAdm extends JFrame implements IFachadas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelBuscaAluno;
	private JTextField txtBuscarAluno;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JTextField txtEndereco;
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
	private JTextField txtTelefone;
	private JTextField txtSexo;
	private JTextField txtCelular;
	private JTextField txtDataNascimento;
	private ISige sistema;
	private JPanel panelBuscaProfessor;
	private JPanel panelBuscaAdm;
	private JComboBox cbPorAdm;
	private JComboBox cbPorProf;
	private JComboBox cbPorAluno;
	private ArrayList<Pessoa> listaBuscaAluno;
	private ArrayList<Pessoa> listaBuscaProf;
	private ArrayList<Pessoa> listaBuscaAdm;
	private JList listAdm;
	private JList listProf;
	private JList listAluno;
	private JFormattedTextField txtCpfAdm;
	private JFormattedTextField txtCpfAluno;
	private JFormattedTextField txtCpfProf;
	private MaskFormatter txtFormatCpf;

	private static FachadaAdm instance;

	/**
	 * Create the frame.
	 */
	public FachadaAdm() {
		try {
			sistema = Sige.getInstance();
		} catch (InicializacaoSistemaException e) {
			JOptionPane.showMessageDialog(null, e);
		}

		setTitle("SIGE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 25, 579, 356);
		contentPane.add(tabbedPane);

		JPanel panelPerfil = new JPanel();
		panelPerfil.setLayout(null);
		tabbedPane.addTab("Perfil", null, panelPerfil, null);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(25, 20, 60, 14);
		panelPerfil.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(151, 20, 300, 20);
		panelPerfil.add(txtNome);
		txtNome.setEditable(false);
		txtNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(25, 45, 60, 14);
		panelPerfil.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setBounds(151, 45, 300, 20);
		panelPerfil.add(txtCpf);
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(25, 70, 60, 14);
		panelPerfil.add(lblRg);

		txtRg = new JTextField();
		txtRg.setEditable(false);
		txtRg.setBounds(151, 70, 300, 20);
		panelPerfil.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(25, 95, 60, 14);
		panelPerfil.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(151, 95, 300, 20);
		panelPerfil.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(25, 170, 60, 14);
		panelPerfil.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(151, 170, 300, 20);
		panelPerfil.add(txtEndereco);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(25, 195, 46, 14);
		panelPerfil.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(151, 195, 120, 20);
		panelPerfil.add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(281, 195, 46, 14);
		panelPerfil.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(331, 195, 120, 20);
		panelPerfil.add(txtCidade);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(25, 220, 82, 14);
		panelPerfil.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setEditable(false);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(151, 220, 300, 20);
		panelPerfil.add(txtComplemento);

		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setBounds(25, 270, 46, 14);
		panelPerfil.add(lblPais);

		txtPais = new JTextField();
		txtPais.setEditable(false);
		txtPais.setColumns(10);
		txtPais.setBounds(151, 270, 120, 20);
		panelPerfil.add(txtPais);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(25, 245, 46, 14);
		panelPerfil.add(lblCep);

		txtCep = new JTextField();
		txtCep.setEditable(false);
		txtCep.setColumns(10);
		txtCep.setBounds(151, 245, 120, 20);
		panelPerfil.add(txtCep);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(281, 245, 53, 14);
		panelPerfil.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(331, 242, 120, 20);
		panelPerfil.add(txtNumero);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(281, 270, 46, 14);
		panelPerfil.add(lblUf);

		txtUf = new JTextField();
		txtUf.setEditable(false);
		txtUf.setBounds(331, 267, 120, 20);
		panelPerfil.add(txtUf);
		txtUf.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(25, 120, 60, 14);
		panelPerfil.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		txtTelefone.setBounds(151, 120, 120, 20);
		panelPerfil.add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(281, 120, 46, 14);
		panelPerfil.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setEditable(false);
		txtCelular.setColumns(10);
		txtCelular.setBounds(331, 120, 120, 20);
		panelPerfil.add(txtCelular);

		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setBounds(25, 145, 120, 14);
		panelPerfil.add(lblDataNascimento);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setEditable(false);
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(151, 145, 120, 20);
		panelPerfil.add(txtDataNascimento);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(281, 145, 46, 14);
		panelPerfil.add(lblSexo);

		txtSexo = new JTextField();
		txtSexo.setEditable(false);
		txtSexo.setColumns(10);
		txtSexo.setBounds(331, 145, 120, 20);
		panelPerfil.add(txtSexo);

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

		try {
			txtFormatCpf = new MaskFormatter("###.###.###-##");
			txtCpfAluno = new JFormattedTextField(txtFormatCpf);
			txtCpfAluno.setEnabled(false);
			txtCpfAluno.setSize(260, 20);
			txtCpfAluno.setLocation(89, 11);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatação.");
		}
		panelBuscaAluno.add(txtCpfAluno);
		txtCpfAluno.setColumns(10);

		cbPorAluno = new JComboBox<String>();
		cbPorAluno.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbPorAluno.getSelectedItem().toString().equals("CPF")) {
					txtCpfAluno.setText("");
					txtCpfAluno.setEnabled(true);
					txtCpfAluno.setVisible(true);
					txtCpfAluno.setEditable(true);
					txtBuscarAluno.setEnabled(false);
					txtBuscarAluno.setVisible(false);
					txtBuscarAluno.setEditable(false);
				} else {
					txtCpfAluno.setEnabled(false);
					txtCpfAluno.setVisible(false);
					txtCpfAluno.setEditable(false);
					txtBuscarAluno.setText("");
					txtBuscarAluno.setEnabled(true);
					txtBuscarAluno.setVisible(true);
					txtBuscarAluno.setEditable(true);
				}
			}
		});
		cbPorAluno.setBounds(399, 11, 60, 20);
		panelBuscaAluno.add(cbPorAluno);

		cbPorAluno.addItem("Nome");
		cbPorAluno.addItem("CPF");

		JButton btnBucarAluno = new JButton("Buscar");
		btnBucarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbPorAluno.getSelectedItem().toString().equals("CPF")) {
					listAluno.setListData(preencher(txtCpfAluno.getText(),
							cbPorAluno.getSelectedItem().toString(), "Aluno"));
				} else {
					listAluno.setListData(preencher(txtBuscarAluno.getText(),
							cbPorAluno.getSelectedItem().toString(), "Aluno"));
				}
				txtCpfAluno.setText("");
				txtBuscarAluno.setText("");
			}
		});
		btnBucarAluno.setBounds(469, 11, 80, 20);
		panelBuscaAluno.add(btnBucarAluno);

		JScrollPane scrollAluno = new JScrollPane();
		scrollAluno
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAluno.setBounds(70, 40, 420, 250);
		panelBuscaAluno.add(scrollAluno);

		listAluno = new JList();
		listAluno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAluno.setBounds(70, 40, 420, 250);

		scrollAluno.setViewportView(listAluno);

		JButton btnExibirPerfilAluno = new JButton("Exibir Perfil");
		btnExibirPerfilAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JList cp = (JList) panelBuscaAluno.getComponentAt(70, 40)
						.getComponentAt(70, 40).getComponentAt(70, 40);
				if (!cp.isSelectionEmpty()) {
					ExibirPerfil ep = (ExibirPerfil) JFrame.getFrames()[3];
					int item = cp.getSelectedIndex();
					ep.carregarPerfil(listaBuscaAluno.get(item));
					ep.setVisible(true);
					Main.historico = (JFrame) JFrame.getFrames()[2];
					setEnabled(false);
				}
			}
		});
		btnExibirPerfilAluno.setBounds(300, 300, 100, 20);
		panelBuscaAluno.add(btnExibirPerfilAluno);

		JButton btnCadastrarAluno = new JButton("Cadastrar");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEnabled(false);
				Cadastrar ep = (Cadastrar) JFrame.getFrames()[1];
				Main.historico = (JFrame) JFrame.getFrames()[2];
				ep.getPanel().setVisible(false);
				ep.setVisible(true);
			}
		});
		btnCadastrarAluno.setBounds(170, 300, 100, 20);
		panelBuscaAluno.add(btnCadastrarAluno);

		panelBuscaProfessor = new JPanel();
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

		try {
			txtFormatCpf = new MaskFormatter("###.###.###-##");
			txtCpfProf = new JFormattedTextField(txtFormatCpf);
			txtCpfProf.setEnabled(false);
			txtCpfProf.setSize(260, 20);
			txtCpfProf.setLocation(89, 11);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatação.");
		}
		panelBuscaProfessor.add(txtCpfProf);
		txtCpfProf.setColumns(10);

		cbPorProf = new JComboBox();
		cbPorProf.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbPorProf.getSelectedItem().toString().equals("CPF")) {
					txtCpfProf.setText("");
					txtCpfProf.setEnabled(true);
					txtCpfProf.setVisible(true);
					txtCpfProf.setEditable(true);
					txtBuscarProf.setEnabled(false);
					txtBuscarProf.setVisible(false);
					txtBuscarProf.setEditable(false);
				} else {
					txtCpfProf.setEnabled(false);
					txtCpfProf.setVisible(false);
					txtCpfProf.setEditable(false);
					txtBuscarProf.setText("");
					txtBuscarProf.setEnabled(true);
					txtBuscarProf.setVisible(true);
					txtBuscarProf.setEditable(true);
				}
			}
		});
		cbPorProf.setBounds(399, 11, 60, 20);
		panelBuscaProfessor.add(cbPorProf);

		cbPorProf.addItem("Nome");
		cbPorProf.addItem("CPF");

		JButton btnBuscarProf = new JButton("Buscar");
		btnBuscarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbPorProf.getSelectedItem().toString().equals("CPF")) {
					listProf.setListData(preencher(txtCpfProf.getText(),
							cbPorProf.getSelectedItem().toString(), "Professor"));
				} else {
					listProf.setListData(preencher(txtBuscarProf.getText(),
							cbPorProf.getSelectedItem().toString(), "Professor"));
				}
				txtCpfProf.setText("");
				txtBuscarProf.setText("");
			}
		});
		btnBuscarProf.setBounds(469, 11, 80, 20);
		panelBuscaProfessor.add(btnBuscarProf);

		JButton btnExibirPerfilProf = new JButton("Exibir Perfil");
		btnExibirPerfilProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JList cp = (JList) panelBuscaProfessor.getComponentAt(70, 40)
						.getComponentAt(70, 40).getComponentAt(70, 40);
				if (!cp.isSelectionEmpty()) {
					ExibirPerfil ep = (ExibirPerfil) JFrame.getFrames()[3];
					int item = cp.getSelectedIndex();
					ep.carregarPerfil(listaBuscaProf.get(item));
					ep.setVisible(true);
					Main.historico = (JFrame) JFrame.getFrames()[2];
					setEnabled(false);
				}
			}
		});
		btnExibirPerfilProf.setBounds(300, 300, 100, 20);
		panelBuscaProfessor.add(btnExibirPerfilProf);

		JScrollPane scrollProf = new JScrollPane();
		panelBuscaProfessor.add(scrollProf);
		scrollProf
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollProf.setBounds(70, 40, 420, 250);

		listProf = new JList();
		listProf.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProf.setBounds(70, 40, 420, 250);

		scrollProf.setViewportView(listProf);

		JButton btnCadastrarProfessor = new JButton("Cadastrar");
		btnCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Cadastrar ep = (Cadastrar) JFrame.getFrames()[1];
				Main.historico = (JFrame) JFrame.getFrames()[2];
				ep.getPanel().setVisible(true);
				((JCheckBox) ep.getPanel().getComponent(0)).setSelected(true);
				ep.getPanel().getComponent(0).setEnabled(false);
				ep.setVisible(true);
			}
		});

		btnCadastrarProfessor.setBounds(170, 300, 100, 20);
		panelBuscaProfessor.add(btnCadastrarProfessor);

		panelBuscaAdm = new JPanel();
		tabbedPane.addTab("Buscar Administrador", null, panelBuscaAdm, null);
		panelBuscaAdm.setLayout(null);

		JLabel lblBuscarAdm = new JLabel("Buscar:");
		lblBuscarAdm.setBounds(30, 14, 60, 14);
		panelBuscaAdm.add(lblBuscarAdm);

		txtBuscarAdm = new JTextField();
		txtBuscarAdm.setBounds(89, 11, 260, 20);
		panelBuscaAdm.add(txtBuscarAdm);
		txtBuscarAdm.setColumns(10);

		JLabel lblPorAdm = new JLabel("Por:");
		lblPorAdm.setBounds(359, 14, 39, 14);
		panelBuscaAdm.add(lblPorAdm);

		try {
			txtFormatCpf = new MaskFormatter("###.###.###-##");
			txtCpfAdm = new JFormattedTextField(txtFormatCpf);
			txtCpfAdm.setEnabled(false);
			txtCpfAdm.setSize(260, 20);
			txtCpfAdm.setLocation(89, 11);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatação.");
		}
		panelBuscaAdm.add(txtCpfAdm);
		txtCpfAdm.setColumns(10);

		cbPorAdm = new JComboBox();
		cbPorAdm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbPorAdm.getSelectedItem().toString().equals("CPF")) {
					txtCpfAdm.setText("");
					txtCpfAdm.setEnabled(true);
					txtCpfAdm.setVisible(true);
					txtCpfAdm.setEditable(true);
					txtBuscarAdm.setEnabled(false);
					txtBuscarAdm.setVisible(false);
					txtBuscarAdm.setEditable(false);
				} else {
					txtCpfAdm.setEnabled(false);
					txtCpfAdm.setVisible(false);
					txtCpfAdm.setEditable(false);
					txtBuscarAdm.setText("");
					txtBuscarAdm.setEnabled(true);
					txtBuscarAdm.setVisible(true);
					txtBuscarAdm.setEditable(true);
				}
			}
		});
		cbPorAdm.setBounds(399, 11, 60, 20);
		panelBuscaAdm.add(cbPorAdm);

		cbPorAdm.addItem("Nome");
		cbPorAdm.addItem("CPF");

		JButton btnBuscarAdm = new JButton("Buscar");
		btnBuscarAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbPorAdm.getSelectedItem().toString().equals("CPF")) {
					listAdm.setListData(preencher(txtCpfAdm.getText(), cbPorAdm
							.getSelectedItem().toString(), "Administrador"));
				} else {
					listAdm.setListData(preencher(txtBuscarAdm.getText(),
							cbPorAdm.getSelectedItem().toString(),
							"Administrador"));
				}
				txtCpfAdm.setText("");
				txtBuscarAdm.setText("");
			}
		});
		btnBuscarAdm.setBounds(469, 11, 80, 20);
		panelBuscaAdm.add(btnBuscarAdm);

		JButton btnExibirPerfilAdm = new JButton("Exibir Perfil");
		btnExibirPerfilAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JList cp = (JList) panelBuscaAdm.getComponentAt(70, 40)
						.getComponentAt(70, 40).getComponentAt(70, 40);
				if (!cp.isSelectionEmpty()) {
					ExibirPerfil ep = (ExibirPerfil) JFrame.getFrames()[3];
					int item = cp.getSelectedIndex();
					ep.carregarPerfil(listaBuscaAdm.get(item));
					ep.setVisible(true);
					Main.historico = (JFrame) JFrame.getFrames()[2];
					setEnabled(false);
				}
			}
		});
		btnExibirPerfilAdm.setBounds(300, 300, 100, 20);
		panelBuscaAdm.add(btnExibirPerfilAdm);

		JScrollPane scrollAdm = new JScrollPane();
		scrollAdm.setBounds(70, 40, 420, 250);
		panelBuscaAdm.add(scrollAdm);
		scrollAdm
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		listAdm = new JList();
		listAdm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAdm.setBounds(70, 40, 420, 250);
		scrollAdm.setViewportView(listAdm);

		JButton btnCadastrarAdm = new JButton("Cadastrar");
		btnCadastrarAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Cadastrar ep = (Cadastrar) JFrame.getFrames()[1];
				Main.historico = (JFrame) JFrame.getFrames()[2];
				ep.getPanel().setVisible(true);
				((JCheckBox) ep.getPanel().getComponent(1)).setSelected(true);
				ep.getPanel().getComponent(1).setEnabled(false);
				ep.setVisible(true);
			}
		});
		btnCadastrarAdm.setBounds(170, 300, 100, 20);
		panelBuscaAdm.add(btnCadastrarAdm);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 594, 20);
		contentPane.add(menuBar);

		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);

		JMenuItem mntmDeslogar = new JMenuItem("Deslogar");
		mntmDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Autenticacao.deslogar();
				JFrame.getFrames()[0].setVisible(true);
				setVisible(false);
			}
		});
		mnSistema.add(mntmDeslogar);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnSistema.add(mntmSair);
	}

	public ArrayList<Pessoa> pesquisar(String chave, String filtro, String tipo) {
		ArrayList<Pessoa> res = new ArrayList<Pessoa>();
		try {
			if (chave.equals("")) {
				res = sistema.buscarAluno();
				if (tipo.equals("Administrador")) {
					res = sistema.buscarAdm();
				} else if (tipo.equals("Aluno")) {
					res = sistema.buscarAluno();
				} else {
					res = sistema.buscarProfessor();
				}
			} else {
				switch (tipo) {
				case "Administrador": {
					if (filtro.equals("Nome")) {
						res = sistema.buscarAdmNome(chave);
					} else {
						res = sistema.buscarAdmCpf(chave);
					}
				}
					break;
				case "Professor": {
					if (filtro.equals("Nome")) {
						res = sistema.buscarProfessorNome(chave);
					} else {
						res = sistema.buscarProfessorCpf(chave);
					}
				}
					break;
				case "Aluno": {
					if (filtro.equals("Nome")) {
						res = sistema.buscarAlunoNome(chave);
					} else {
						res = sistema.buscarAlunoCpf(chave);
					}
				}
					break;
				default:
					res = null;
					break;
				}
			}
			if (tipo.equals("Professor")) {
				listaBuscaProf = res;
			} else if (tipo.equals("Aluno")) {
				listaBuscaAluno = res;
			} else {
				listaBuscaAdm = res;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return res;
	}

	public void setPerfil(Pessoa pessoa) {
		txtNome.setText(pessoa.getNome());
		txtCpf.setText(pessoa.getCpf());
		txtRg.setText(pessoa.getRg());
		txtEmail.setText(pessoa.getEmail());
		txtTelefone.setText(pessoa.getTelefone());
		txtCelular.setText(pessoa.getCelular());
		txtDataNascimento.setText(pessoa.getDataNascimento());
		txtSexo.setText(pessoa.getSexo());
		txtEndereco.setText(pessoa.getEndereço().getRua());
		txtBairro.setText(pessoa.getEndereço().getBairro());
		txtCidade.setText(pessoa.getEndereço().getCidade());
		txtComplemento.setText(pessoa.getEndereço().getComplemento());
		txtCep.setText(pessoa.getEndereço().getCep());
		txtNumero.setText(pessoa.getEndereço().getNumero());
		txtPais.setText(pessoa.getEndereço().getPais());
		txtUf.setText(pessoa.getEndereço().getUf());
	}

	public String[] preencher(String chave, String filtro, String tipo) {
		String[] lista = new String[pesquisar(chave, filtro, tipo).size()];
		for (int i = 0; i < pesquisar(chave, filtro, tipo).size(); i++) {
			lista[i] = pesquisar(chave, filtro, tipo).get(i).getNome();
		}
		return lista;
	}

	public void carregarListas() {
		listAdm.setListData(preencher("", "", "Administrador"));
		listProf.setListData(preencher("", "", "Professor"));
		listAluno.setListData(preencher("", "", "Aluno"));
	}

	public static FachadaAdm getInstance() {
		if (FachadaAdm.instance == null) {
			FachadaAdm.instance = new FachadaAdm();
		}
		return FachadaAdm.instance;
	}
}