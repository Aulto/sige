package sige.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;

public class testes extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testes frame = new testes();
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
	public testes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 400);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel jlSistemaDeAlocao = new JLabel("Sistema de aloca\u00E7\u00E3o de professores");
		jlSistemaDeAlocao.setFont(new Font("Verdana", Font.BOLD, 26));
		jlSistemaDeAlocao.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jlSistemaDeAlocao);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		JPanel jpCursos = new JPanel();
		tabbedPane.addTab("Cursos", null, jpCursos, null);
		jpCursos.setLayout(new BoxLayout(jpCursos, BoxLayout.X_AXIS));
		
		JButton jbCadastrarCurso = new JButton("Cadastrar Curso");
		jpCursos.add(jbCadastrarCurso);
		
		JButton jbBuscarCurso = new JButton("Buscar Curso");
		jpCursos.add(jbBuscarCurso);
		
		JButton jbEditarCurso = new JButton("Editar Curso");
		jpCursos.add(jbEditarCurso);
		
		JButton jbRemoverCurso = new JButton("Remover Curso");
		jpCursos.add(jbRemoverCurso);
		
		JPanel jpProfessores = new JPanel();
		tabbedPane.addTab("Professores", null, jpProfessores, null);
		
		Box horizontalBox = Box.createHorizontalBox();
		jpProfessores.add(horizontalBox);
		
		JButton btnCadastrarProfessor = new JButton("Cadastrar Professor");
		horizontalBox.add(btnCadastrarProfessor);
		
		JButton btnBuscarProfesso = new JButton("Buscar Professo");
		horizontalBox.add(btnBuscarProfesso);
		
		JButton btnRemoverProfessor = new JButton("Remover Professor");
		horizontalBox.add(btnRemoverProfessor);
		
		JPanel jpDisciplinas = new JPanel();
		tabbedPane.addTab("Disciplinas", null, jpDisciplinas, null);
		GroupLayout gl_jpDisciplinas = new GroupLayout(jpDisciplinas);
		gl_jpDisciplinas.setHorizontalGroup(
			gl_jpDisciplinas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 429, Short.MAX_VALUE)
		);
		gl_jpDisciplinas.setVerticalGroup(
			gl_jpDisciplinas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 234, Short.MAX_VALUE)
		);
		jpDisciplinas.setLayout(gl_jpDisciplinas);
	}
}
