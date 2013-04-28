package sige.gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sige.sistema.Autenticacao;
import sige.sistema.AutenticacaoException;
import sige.sistema.ISige;
import sige.sistema.InicializacaoSistemaException;
import sige.sistema.Materia;
import sige.sistema.Pessoa;
import sige.sistema.ProblemaInterno;
import sige.sistema.Sige;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FachadaAluno extends JFrame implements IFachadas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JTextField txtPais;
	private JTextField txtCep;
	private JTextField txtNumero;
	private JTextField txtUf;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtDataNascimento;
	private JTextField txtSexo;

	private ISige sistema;
	private static FachadaAluno instance;
	private JList listMaterias;

	/**
	 * Create the frame.
	 */
	public FachadaAluno() {
		try {
			sistema = Sige.getInstance();
		} catch (InicializacaoSistemaException e) {
			JOptionPane.showMessageDialog(null, e);
		}

		setTitle("Painel Aluno");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 744, 404);
		contentPane.add(tabbedPane);

		JPanel panelPerfil = new JPanel();
		panelPerfil.setLayout(null);
		tabbedPane.addTab("Perfil", null, panelPerfil, null);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(25, 20, 60, 14);
		panelPerfil.add(lblNome);

		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(151, 20, 300, 20);
		panelPerfil.add(txtNome);

		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(25, 45, 60, 14);
		panelPerfil.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(151, 45, 300, 20);
		panelPerfil.add(txtCpf);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(25, 70, 60, 14);
		panelPerfil.add(lblRg);

		txtRg = new JTextField();
		txtRg.setEditable(false);
		txtRg.setColumns(10);
		txtRg.setBounds(151, 70, 300, 20);
		panelPerfil.add(txtRg);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(25, 95, 60, 14);
		panelPerfil.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(151, 95, 300, 20);
		panelPerfil.add(txtEmail);

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
		txtUf.setColumns(10);
		txtUf.setBounds(331, 267, 120, 20);
		panelPerfil.add(txtUf);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(25, 120, 60, 14);
		panelPerfil.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(151, 120, 120, 20);
		panelPerfil.add(txtTelefone);

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

		JPanel panelMaterias = new JPanel();
		tabbedPane.addTab("Mat\u00E9rias", null, panelMaterias, null);
		panelMaterias.setLayout(null);

		JButton btnDetalhesDaMatria = new JButton("Detalhes da Mat\u00E9ria");
		btnDetalhesDaMatria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Materia m = sistema.buscarMateriaNome(listMaterias
							.getSelectedValue().toString());
					String profNome;
					try {
						profNome = sistema
								.buscarProfessorId(m.getIdProfessor()).get(0)
								.getNome();
						JOptionPane.showMessageDialog(null,
								"Materia: " + m.getNome() + "\nProfessor: "
										+ profNome);
					} catch (AutenticacaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ProblemaInterno e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDetalhesDaMatria.setBounds(165, 324, 134, 23);
		panelMaterias.add(btnDetalhesDaMatria);

		JButton btnAdicionarMatria = new JButton("Adicionar Mat\u00E9ria");
		btnAdicionarMatria.setBounds(309, 324, 128, 23);
		panelMaterias.add(btnAdicionarMatria);

		JButton btnRemoverMatria = new JButton("Remover Mat\u00E9ria");
		btnRemoverMatria.setBounds(447, 324, 134, 23);
		panelMaterias.add(btnRemoverMatria);

		JScrollPane scrollMaterias = new JScrollPane();
		scrollMaterias
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollMaterias.setBounds(10, 11, 719, 291);
		panelMaterias.add(scrollMaterias);

		listMaterias = new JList();
		scrollMaterias.setViewportView(listMaterias);

		JPanel panelAtividades = new JPanel();
		tabbedPane.addTab("Atividades", null, panelAtividades, null);
	}

	public static FachadaAluno getInstance()
			throws InicializacaoSistemaException {
		if (FachadaAluno.instance == null) {
			try {
				FachadaAluno.instance = new FachadaAluno();
			} catch (Exception e) {
				throw new InicializacaoSistemaException();
			}
		}
		return FachadaAluno.instance;
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

	@Override
	public void carregarListas() {
		try {
			ArrayList<Materia> materias = sistema
					.recuperarMateriasAluno(Autenticacao.getId());
			String[] alunoMaterias = new String[materias.size()];
			for (int i = 0; i < materias.size(); i++) {
				alunoMaterias[i] = materias.get(i).getNome();
			}
			listMaterias.setListData(alunoMaterias);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}

	}
}
