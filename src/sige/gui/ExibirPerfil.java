package sige.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import sige.sistema.Pessoa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class ExibirPerfil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPerfil;
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
	private JTextField textField;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtDataNascimento;
	private JTextField txtSexo;

	/**
	 * Create the frame.
	 */
	public ExibirPerfil() {
		setResizable(false);
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 370);
		panelPerfil = new JPanel();
		panelPerfil.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPerfil);
		panelPerfil.setLayout(null);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(25, 20, 60, 14);
		panelPerfil.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(150, 20, 300, 20);
		panelPerfil.add(txtNome);
		txtNome.setEditable(false);
		txtNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(25, 45, 60, 14);
		panelPerfil.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setBounds(150, 45, 300, 20);
		panelPerfil.add(txtCpf);
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(25, 70, 60, 14);
		panelPerfil.add(lblRg);

		txtRg = new JTextField();
		txtRg.setEditable(false);
		txtRg.setBounds(150, 70, 300, 17);
		panelPerfil.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(25, 95, 60, 14);
		panelPerfil.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(150, 95, 300, 20);
		panelPerfil.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(25, 170, 60, 14);
		panelPerfil.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(150, 170, 300, 20);
		panelPerfil.add(txtEndereco);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(25, 195, 46, 14);
		panelPerfil.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(150, 195, 120, 20);
		panelPerfil.add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(280, 195, 46, 14);
		panelPerfil.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(330, 195, 120, 20);
		panelPerfil.add(txtCidade);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(25, 220, 82, 14);
		panelPerfil.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setEditable(false);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(150, 220, 170, 20);
		panelPerfil.add(txtComplemento);

		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setBounds(25, 270, 46, 14);
		panelPerfil.add(lblPais);

		txtPais = new JTextField();
		txtPais.setEditable(false);
		txtPais.setColumns(10);
		txtPais.setBounds(150, 270, 120, 20);
		panelPerfil.add(txtPais);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(25, 245, 46, 14);
		panelPerfil.add(lblCep);

		txtCep = new JTextField();
		txtCep.setEditable(false);
		txtCep.setColumns(10);
		txtCep.setBounds(150, 245, 120, 20);
		panelPerfil.add(txtCep);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(280, 245, 53, 14);
		panelPerfil.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(330, 242, 120, 20);
		panelPerfil.add(txtNumero);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(280, 270, 46, 14);
		panelPerfil.add(lblUf);

		txtUf = new JTextField();
		txtUf.setEditable(false);
		txtUf.setBounds(330, 270, 120, 20);
		panelPerfil.add(txtUf);
		txtUf.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(25, 120, 60, 14);
		panelPerfil.add(lblTelefone);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(280, 120, 46, 14);
		panelPerfil.add(lblCelular);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(25, 145, 120, 14);
		panelPerfil.add(lblDataDeNascimento);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(280, 145, 46, 14);
		panelPerfil.add(lblSexo);

		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		txtTelefone.setBounds(150, 120, 120, 20);
		panelPerfil.add(txtTelefone);
		txtTelefone.setColumns(10);

		txtCelular = new JTextField();
		txtCelular.setEditable(false);
		txtCelular.setColumns(10);
		txtCelular.setBounds(330, 120, 120, 20);
		panelPerfil.add(txtCelular);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setEditable(false);
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(150, 145, 120, 20);
		panelPerfil.add(txtDataNascimento);

		txtSexo = new JTextField();
		txtSexo.setEditable(false);
		txtSexo.setColumns(10);
		txtSexo.setBounds(330, 145, 120, 20);
		panelPerfil.add(txtSexo);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(460, 40, 100, 20);
		panelPerfil.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(460, 70, 100, 20);
		panelPerfil.add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main.historico.setEnabled(true);
				Main.historico.setVisible(true);
				((IFachadas) Main.historico).carregarListas();
			}
		});
		btnVoltar.setBounds(460, 295, 100, 23);
		panelPerfil.add(btnVoltar);
	}

	public void carregarPerfil(Pessoa pessoa) {
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
}
