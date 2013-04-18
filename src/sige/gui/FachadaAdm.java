package sige.gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxEditor;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JViewport;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JFormattedTextField;

import sige.sistema.Autenticacao;
import sige.sistema.AutenticacaoException;
import sige.sistema.ISige;
import sige.sistema.InicializacaoSistemaException;
import sige.sistema.Pessoa;
import sige.sistema.ProblemaInterno;
import sige.sistema.Sige;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;

public class FachadaAdm extends JFrame {

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
	private JScrollPane scrollAdm;

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

		JScrollPane scrollAluno = new JScrollPane();
		scrollAluno
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAluno.setBounds(70, 40, 420, 250);
		panelBuscaAluno.add(scrollAluno);
		
		JList listAluno = new JList();
		listAluno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAluno.setBounds(70, 40, 420, 250);
		// panelBuscaAluno.add(listAluno);

		scrollAluno.setViewportView(listAluno);

		JButton btnExibirPerfilAluno = new JButton("Exibir Perfil");
		btnExibirPerfilAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JList cp = (JList) panelBuscaAluno.getComponentAt(70, 40)
						.getComponentAt(70, 40).getComponentAt(70, 40);

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

		JButton btnExibirPerfilProf = new JButton("Exibir Perfil");
		btnExibirPerfilProf.setBounds(230, 300, 100, 20);
		panelBuscaProfessor.add(btnExibirPerfilProf);

		JScrollPane scrollProf = new JScrollPane();
		scrollProf.setBounds(70, 40, 420, 250);
		panelBuscaProfessor.add(scrollProf);
		scrollProf
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JList listProf = new JList();
		listProf.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProf.setBounds(70, 40, 420, 250);
		// panelBuscaAluno.add(listAluno);

		scrollProf.setViewportView(listProf);

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

		JButton btnExibirPerfilAdm = new JButton("Exibir Perfil");
		btnExibirPerfilAdm.setBounds(230, 300, 100, 20);
		panelAdm.add(btnExibirPerfilAdm);

		scrollAdm = new JScrollPane();
		scrollAdm.setBounds(70, 40, 420, 250);
		panelAdm.add(scrollAdm);
		scrollAdm
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		

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
				res = sistema.buscaAdm();
			} else {
				switch (tipo) {
				case "Administrador": {
					if (filtro.equals("Nome")) {
						res = sistema.buscaAdmNome(chave);
					} else {
						res = sistema.buscaAdmCpf(chave);
					}
				}
					break;
				default:
					res = null;
					break;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return res;
	}
	
	public void listarAdms(){
		String[] nomes;
		try {
			nomes = new String[sistema.buscaAdm().size()];
			int i = 0;
			for (Pessoa p : sistema.buscaAdm()) {
				nomes[i] = p.getNome();
				i++;
			}
			JList listAdm = new JList(nomes);
			//JList listAdm = new JList(preencher("", "", "Administrador"));
			listAdm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listAdm.setBounds(70, 40, 420, 250);
			// panelBuscaAluno.add(listAluno);
			scrollAdm.setViewportView(listAdm);
		} catch (AutenticacaoException | ProblemaInterno e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		String[] lista = new String[pesquisar("", "", "Administrador").size()];
		for (int i = 0; i < pesquisar(chave, filtro, tipo).size(); i++) {
			lista[i] = i + "";
		}
		return lista;
	}	
}