package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controladores.ctrlAutoAvaliacao;

import dados.Resposta;

public class PainelQuestao extends JPanel  {
	
	
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel label_questao, label_imagemAuxiliar, label_resposta, label_avaliacao, label_explicacao;
	private JTextArea textArea_questao, textArea_explicacao;

	//Imagem necessita disto tudo:
	//private BufferedImage img = ImageIO.read(new File("")); // não sei se com a DB funciona, pelo menos em paths locais é assim.
	private ImageIcon imageIcon_imagem;
	private JLabel label_imagem;
	
	//
	private JTextField textField_reposta;
	private JButton button_enviarResposta, button_pedirQuestao, button_abandonar,button_limpar;

	private Connection con;
	private ctrlAutoAvaliacao ctrlAutoAvaliacao;
	
	//experimental emai aluno
	private String email="docente@iscte.pt";

	public PainelQuestao(Connection con,ctrlAutoAvaliacao ctrlAutoAvaliacao) {
		this.ctrlAutoAvaliacao=ctrlAutoAvaliacao;
		this.con= con;
		setup();
	}


	private void setup(){
		init();
		setLayout(new GridBagLayout());
		configCimaEsquerda();
		configCimaDireita();
		configBaixo();
	}

	public JTextArea getTextQuestao(){
		return textArea_questao;
	}

	private void init(){
		gbc = new GridBagConstraints();

		label_questao = new JLabel("Questão:");
		label_imagemAuxiliar = new JLabel("Image Auxiliar:");
		label_resposta = new JLabel("Resposta:");
		label_avaliacao = new JLabel("Avaliação: --------/---------");
		label_explicacao = new JLabel("Explicação");

		textArea_questao = new JTextArea();
		textArea_questao.setEditable(false);

		imageIcon_imagem = new ImageIcon();
		label_imagem = new JLabel(imageIcon_imagem);

		textField_reposta = new JTextField("",1);


		button_enviarResposta = new JButton("Enviar resposta");

		button_enviarResposta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO Auto-generated method stub
				ctrlAutoAvaliacao.enviarRespostaEscolhida(Integer.parseInt(textField_reposta.getText()),email);
		
				
				/*	Resposta r = new Resposta("docente@iscte.pt", null, 
						ctrlAutoAvaliacao.getQuestao().getISQuetao(), Integer.parseInt(textField_reposta.getText()));	
				r.insert(con);
				*/
				//Integer.parseInt(textField_reposta.getText()) PASSAR A RSP DO TXT PARA INTEIRO
			
				label_avaliacao.setText(ctrlAutoAvaliacao.obeterAvalaicao(Integer.parseInt(textField_reposta.getText())));
			
				textArea_explicacao.setText(ctrlAutoAvaliacao.obeterExplicacao());
			}
		});

		button_pedirQuestao = new JButton("Pedir Nova Questão");

		textArea_explicacao = new JTextArea();
		textArea_explicacao.setEditable(false);

		button_abandonar = new JButton("Abandonar");
		button_abandonar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);

			}
		});

		button_limpar = new JButton("Limpar");

	}

	private void configCimaEsquerda(){


		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 20;
		gbc.ipadx = 20;

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(label_questao,gbc);


		gbc.ipady = 100;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		gbc.gridheight = 3;
		textArea_questao.setBorder(BorderFactory.createLineBorder(Color.black));
		add(textArea_questao, gbc);

		gbc.insets = new Insets(10,10,0,0);
		gbc.ipady = 10;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(label_resposta, gbc);

		gbc.gridx = 1;
		textField_reposta.setPreferredSize(new Dimension(100, 20));

		add(textField_reposta, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10,10,0,0);
		add(button_enviarResposta, gbc);
	}

	private void configCimaDireita(){
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(label_imagemAuxiliar, gbc);

		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		add(label_imagem, gbc);

		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(button_pedirQuestao,gbc);
	}

	private void configBaixo(){
		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(label_avaliacao,gbc);

		gbc.gridy = 6;
		add(label_explicacao,gbc);

		gbc.gridwidth = 5;
		gbc.gridheight = 2;
		gbc.gridx= 1;

		textArea_explicacao.setPreferredSize(new Dimension(100, 40));
		textArea_explicacao.setBorder(BorderFactory.createLineBorder(Color.black));
		add(textArea_explicacao, gbc);

		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 8;
		gbc.gridx = 3;
		add(button_abandonar, gbc);

		gbc.gridx = 2;
		add(button_limpar, gbc);
	}


	public JButton getButton_limpar() {
		return button_limpar;
	}

}





