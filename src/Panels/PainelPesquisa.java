package Panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controladores.ctrlAutoAvaliacao;

import dados.Curso;
import dados.Modulo;
import dados.Nivel_Dificuldade;
import dados.Questao;
import dados.Sub_Modulo;
import dados.UC;

public class PainelPesquisa extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel label_pesquisaModulos, label_pesquisaUC, label_pesquisaCurso;
	private JLabel label_modulo, label_subModulo, label_nivelDificuldade, label_pesquisaUnidadeCurricular;
	private Pesquisa estado;


	private JComboBox comboBox_modulo, comboBox_subModulo, comboBox_nivelDificuldade, comboBox_curso;

	private ArrayList<Modulo> modulos;
	private ArrayList<Sub_Modulo> sub_modulos;
	private ArrayList<Nivel_Dificuldade> niveis;

	private ArrayList<UC> ucs;
	private ArrayList<Questao>questoes;

	private JTextArea textArea_pesquisa;

	private JScrollPane jScrollPane, jScrollPane2;
	private JList list_pesquisa, list_ucCurso; 
	private Connection conn;
	private JTextArea questao;

	private DefaultListModel listModel = new DefaultListModel();
	private DefaultListModel listModel2 = new DefaultListModel();
	private JButton button_obterQuestao;
	private JButton limpar;
	private String aux = new String("");

	private ctrlAutoAvaliacao ctrlAutoAvaliacao;

	//+++++  CLASS	+++++//

	public PainelPesquisa(Connection conn,JTextArea text,JButton limpar,ctrlAutoAvaliacao ctrlAutoAvaliacao) {
		this.ctrlAutoAvaliacao = ctrlAutoAvaliacao;
		this.limpar=limpar;
		this.conn=conn;
		questao=text;
		
	
		
		setup();

	}


	private void setup(){
		init();
		setLayout(new GridBagLayout());
		configEsquerda();
		configDireita();
	}

	private void init(){
		gbc = new GridBagConstraints();

		label_pesquisaModulos = new JLabel("Pesquisa por Módulos");
		label_pesquisaUC = new JLabel("Pesquisa por UC");
		label_pesquisaCurso = new JLabel("Pesquisa por Curso");

		label_modulo = new JLabel("Seleccione o Módulo:");
		label_subModulo = new JLabel("Seleccione o SubMódulo:");
		label_nivelDificuldade = new JLabel("Nível de dificuldade:");

		label_pesquisaUnidadeCurricular = new JLabel("Pesquisa por Unidade Curricular");
		comboBox_modulo = new JComboBox();
		comboBox_subModulo = new JComboBox();

		comboBox_subModulo.setEnabled(false);

		comboBox_nivelDificuldade = new JComboBox();
		comboBox_nivelDificuldade.setEnabled(false);
		carregaModuloBox(comboBox_modulo);
		comboBox_modulo.setSelectedIndex(-1);





		carregaSubModulo(comboBox_subModulo);
		comboBox_subModulo.setSelectedIndex(-1);

		carreganivelDificuldade(comboBox_nivelDificuldade);
		comboBox_nivelDificuldade.setSelectedIndex(-1);


		comboBox_modulo.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
				estado = Pesquisa.MODULO;
				comboBox_curso.setEnabled(false);
				list_pesquisa.setEnabled(false);
				textArea_pesquisa.setEnabled(false);
				list_ucCurso.setEnabled(false);
				comboBox_subModulo.setEnabled(true);
				comboBox_subModulo.setSelectedIndex(-1);
				comboBox_nivelDificuldade.setSelectedIndex(-1);

			}
		});


		comboBox_subModulo.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox_subModulo.getSelectedIndex()!=-1){
					comboBox_nivelDificuldade.setEnabled(true);
					comboBox_nivelDificuldade.setSelectedIndex(-1);
				}

			}
		});

		comboBox_curso = new JComboBox();
		carregaCurso(comboBox_curso);
		comboBox_curso.setSelectedIndex(-1);
		textArea_pesquisa = new JTextArea();
		textArea_pesquisa.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				estado = Pesquisa.UC;
				comboBox_curso.setEnabled(false);
				comboBox_modulo.setEnabled(false);
				comboBox_nivelDificuldade.setEnabled(false);
				listModel2.removeAllElements();
				if(arg0.getKeyCode() != KeyEvent.VK_BACK_SPACE ||
						arg0.getKeyCode() != KeyEvent.VK_ESCAPE){
					aux=textArea_pesquisa.getText();
					
					for ( int i=0; i< ctrlAutoAvaliacao.getUcs().size(); i++){
						if(ctrlAutoAvaliacao.getUcs().get(i).getDesignacaoUC().contains(aux)){
							listModel2.addElement(ctrlAutoAvaliacao.getUcs().get(i).getDesignacaoUC());
						}
					}
				}
				if(listModel2.size()!=0){
					list_pesquisa.setModel(listModel2);
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		list_ucCurso= new JList();
		list_pesquisa = new JList();

		jScrollPane = new JScrollPane(list_pesquisa);
		jScrollPane.setPreferredSize(new Dimension(100, 50));
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


		jScrollPane2 = new JScrollPane(list_ucCurso);
		jScrollPane2.setPreferredSize(new Dimension(100, 50));
		jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		button_obterQuestao = new JButton("Obter Questão");
		button_obterQuestao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Questao questaoaux;
				switch (estado) {
				case UC:
					questaoaux=ctrlAutoAvaliacao.getQuestaoUC(textArea_pesquisa.getText());
					questao.setText(questaoaux.getTexto());
					break;
				case CURSO:
					questaoaux=ctrlAutoAvaliacao.getQuestaoCurso((String)list_ucCurso.getSelectedValue());
					questao.setText(questaoaux.getTexto());
					break;
				case MODULO:
					questaoaux=ctrlAutoAvaliacao.getQuestaoModulo((String)comboBox_modulo.getSelectedItem(), 
							(String)comboBox_subModulo.getSelectedItem(), 
							(String)comboBox_nivelDificuldade.getSelectedItem()  );
					questao.setText(questaoaux.getTexto());
					break;

				default:
					break;
				}

			}
		});


		comboBox_curso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					estado = Pesquisa.CURSO;
					comboBox_modulo.setEnabled(false);
					textArea_pesquisa.setEnabled(false);
					list_ucCurso.setEnabled(true);
					listModel.removeAllElements();
					Object selected = comboBox_curso.getSelectedItem();

					ResultSet rs = ctrlAutoAvaliacao.obterUCCurso(selected) ;
					while(rs.next()){
						listModel.addElement(rs.getString("Designacao_UC"));
					}
					list_ucCurso.setModel(listModel);

				}catch(Exception e){}
			}
		});
		limpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBox_modulo.setSelectedIndex(-1);
				comboBox_subModulo.setSelectedIndex(-1);
				comboBox_curso.setSelectedIndex(-1);
				comboBox_subModulo.setEnabled(false);
				comboBox_curso.setEnabled(true);
				comboBox_modulo.setEnabled(true);
				textArea_pesquisa.setText("");
				textArea_pesquisa.setEnabled(true);
				list_pesquisa.setEnabled(true);
				listModel.removeAllElements();
				listModel2.removeAllElements();

			}
		});


	}

	private void carregaCurso(JComboBox comboBox_curso2) {
		for(int i=0;i<ctrlAutoAvaliacao.getCursos().size();i++)
			comboBox_curso2.addItem(ctrlAutoAvaliacao.getCursos().get(i).toString());

	}
	private void carreganivelDificuldade(JComboBox comboBox_nivelDificuldade2) {
		for(int i=0;i<ctrlAutoAvaliacao.getNiveis().size();i++)
			comboBox_nivelDificuldade2.addItem(ctrlAutoAvaliacao.getNiveis().get(i).toString());
	}
	private void carregaSubModulo(JComboBox comboBox_subModulo2) {
		for(int i=0;i<ctrlAutoAvaliacao.getSub_modulos().size();i++)
			comboBox_subModulo2.addItem(ctrlAutoAvaliacao.getSub_modulos().get(i).toString());

	}
	private void carregaModuloBox(JComboBox comboBox_modulo2) {

		for(int i=0;i<ctrlAutoAvaliacao.getModulos().size();i++)
			comboBox_modulo2.addItem(ctrlAutoAvaliacao.getModulos().get(i).toString());

	}
	private void configEsquerda(){
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;

		gbc.insets = new Insets(10,10,0,0);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.ipady = 10;
		gbc.ipadx = 50;
		label_pesquisaModulos.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_pesquisaModulos.setForeground(Color.BLUE);;
		add(label_pesquisaModulos,gbc);

		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(label_modulo,gbc);

		gbc.gridy = 2;
		comboBox_modulo.setPreferredSize(new Dimension(140, 20));
		add(comboBox_modulo,gbc);

		gbc.gridy = 3;
		add(label_nivelDificuldade, gbc);

		gbc.gridy = 4;
		gbc.gridwidth = 2;
		label_pesquisaCurso.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_pesquisaCurso.setForeground(Color.BLUE);
		add(label_pesquisaCurso,gbc);

		gbc.gridy = 5;
		gbc.gridwidth = 1;
		comboBox_curso.setPreferredSize(new Dimension(140, 20));
		add(comboBox_curso,gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		add(label_subModulo, gbc);

		gbc.gridy = 2;
		comboBox_subModulo.setPreferredSize(new Dimension(140, 20));
		add(comboBox_subModulo, gbc);

		gbc.gridy = 3;
		comboBox_nivelDificuldade.setPreferredSize(new Dimension(140, 20));

		add(comboBox_nivelDificuldade, gbc);


		gbc.gridy = 5;
		jScrollPane2.setPreferredSize(new Dimension(140, 60));
		add(jScrollPane2, gbc);


	}

	private void configDireita(){
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		label_pesquisaUC.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_pesquisaUC.setForeground(Color.BLUE);
		add(label_pesquisaUC, gbc);

		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(label_pesquisaUnidadeCurricular,gbc);

		gbc.gridy = 2;
		gbc.gridwidth = 2;
		textArea_pesquisa.setPreferredSize(new Dimension(140, 20));
		add(textArea_pesquisa, gbc);

		gbc.gridy = 3;
		gbc.ipadx = 100;
		add(jScrollPane, gbc);

		gbc.gridy = 5;
		gbc.ipadx = 20;
		gbc.insets = new Insets(20,50,0,0);
		add(button_obterQuestao, gbc);
	}
}


