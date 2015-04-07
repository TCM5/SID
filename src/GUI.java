import java.awt.FlowLayout;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;

import controladores.ctrlAutoAvaliacao;

import Panels.PainelPesquisa;
import Panels.PainelQuestao;


public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int LARGURA = 800, ALTURA = 700;
	private final String TITULO = "SID[A]";
	private Connection a;
	private ctrlAutoAvaliacao ctrlAutoAvaliacao;

	
	PainelPesquisa pp;
	PainelQuestao pq;
	
	public GUI(Connection a){
		this.a=a;
		ctrlAutoAvaliacao = new ctrlAutoAvaliacao(a);
		pq = new PainelQuestao(a,ctrlAutoAvaliacao);
		pp = new PainelPesquisa(a,pq.getTextQuestao(),pq.getButton_limpar(),ctrlAutoAvaliacao);
		setup();
		setVisible(true);
		
	}
	
	
	public void setup(){
		setSize(LARGURA, ALTURA);
		setTitle(TITULO);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(pp);
		add(pq);
			}

}
