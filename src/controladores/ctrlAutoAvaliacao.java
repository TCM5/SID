package controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import dados.Curso;
import dados.Modulo;
import dados.Nivel_Dificuldade;
import dados.Questao;
import dados.Resposta;
import dados.Sub_Modulo;
import dados.UC;

public class ctrlAutoAvaliacao {

	private Connection con;
	
	private ArrayList<Modulo> modulos;
	private ArrayList<Sub_Modulo> sub_modulos;
	private ArrayList<Nivel_Dificuldade> niveis;
	private ArrayList<Curso> cursos;
	private ArrayList<UC> ucs;
	private ArrayList<Questao>questoes;
	private Questao questao;

	private void loadFromDb() {


		try {
			Statement s = con.createStatement();
			String query;
			ResultSet rs;
			Modulo m = new Modulo(con);
			modulos= m.fazArrayModulo();
			Sub_Modulo sub=new Sub_Modulo(con);
			sub_modulos=sub.fazArraySubModulo();
			Nivel_Dificuldade n = new Nivel_Dificuldade(con);
			niveis=n.fazArrayNiveis();
			Curso c=new Curso(con);
			cursos=c.fazArrayCurso();

			UC uc = new UC(con);
			ucs=uc.fazArrayUC();

			query = "select * from Questoes;";
			rs = s.executeQuery(query);
			questoes= new Questao().fazerArray(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}


	public ArrayList<Modulo> getModulos() {
		return modulos;
	}


	public ArrayList<Sub_Modulo> getSub_modulos() {
		return sub_modulos;
	}


	public ArrayList<Nivel_Dificuldade> getNiveis() {
		return niveis;
	}


	public ArrayList<UC> getUcs() {
		return ucs;
	}


	public ArrayList<Questao> getQuestoes() {
		return questoes;
	}


	public ArrayList<Curso> getCursos() {
		return cursos;
	}


	public ctrlAutoAvaliacao(Connection con){
		this.con = con;
		
		loadFromDb();
		
	}
//alteracao do metodo para receber o email afim de criar a nova rsp
	public void enviarRespostaEscolhida(int resposta, String email){
//ver como enviar a data para o construtor
		Resposta r = new Resposta(email, null, 
				getQuestao().getISQuetao(), resposta);
		
		r.insert(con);
	}

	
	//tem de ser alterda para ir smp a bd buscar uma questao com base no que se introduziu nas combo box
	//para diferenciar o tipo de buscar poderiamos por no 1º param o a strin do enum e fazer o seguite comando
	//str1.toLowerCase().contains(str2.toLowerCase()) e fazer if else 


	public void ObterQuestao(String um, String dois, int trez){
		/*ORDER BY RAND()
		LIMIT 1*/
		
	}

	public  Questao getQuestaoUC(String text) {
		ArrayList<Questao> auxiliar=null;
		try{
			String aux = null;
			for(int i = 0; i < ucs.size(); i++){
				if(ucs.get(i).getDesignacaoUC().equals(text)){
					aux= ucs.get(i).getSiglaUC();
				}
			}
		
			auxiliar = new ArrayList<Questao>();
			String query = new String("select * from Questoes where Sigla_UC = '"+aux+"'");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){
				auxiliar.add(new Questao(rs.getString("Texto"), rs.getString("Explicacao"),rs.getString("Resposta").charAt(0), 
						rs.getInt("ID_Questao"), rs.getString("LinkFicheiro"),rs.getString("Email_Docente"), rs.getInt("ID_Nivel")));
			}
		}catch(Exception e){}
		Random r = new Random();
		int r1 = r.nextInt(auxiliar.size());
		questao=auxiliar.get(r1);
		return auxiliar.get(r1);
	}



	public  Questao getQuestaoModulo(String selectedItem,String selectedItem2, String selectedItem3) {
		ArrayList<Questao> auxiliar=null;
		try{
		auxiliar = new ArrayList<Questao>();
		String query = new String("select * from Questoes,Modulo,Sub_Modulo,Nivel_Dificuldade where Modulo.Designacao_Modulo = '"+selectedItem+"' and " +
				"Sub_Modulo.Designacao_Sub_Modulo='"+selectedItem2+"' and Modulo.Designacao_Modulo=Sub_Modulo.Designacao_Modulo and Questoes.ID_Questao" +
						"=Sub_Modulo.ID_Questao");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			auxiliar.add(new Questao(rs.getString("Texto"), rs.getString("Explicacao"),rs.getString("Resposta").charAt(0), 
					rs.getInt("ID_Questao"), rs.getString("LinkFicheiro"),rs.getString("Email_Docente"), rs.getInt("ID_Nivel")));
		}
		}catch(Exception e){}
		Random r = new Random();
		int r1 = r.nextInt(auxiliar.size());
		questao=auxiliar.get(r1);
		return auxiliar.get(r1);
		

	}

	public  Questao getQuestaoCurso(String selectedItem) {
		ArrayList<Questao> auxiliar=null;
		try{
			String aux = null;
			for(int i = 0; i < ucs.size(); i++){
				if(ucs.get(i).getDesignacaoUC().equals(selectedItem)){
					aux= ucs.get(i).getSiglaUC();
				}
			}
		auxiliar = new ArrayList<Questao>();
		String query = new String("select * from Questoes where Sigla_UC = '"+aux+"'");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			auxiliar.add(new Questao(rs.getString("Texto"), rs.getString("Explicacao"),rs.getString("Resposta").charAt(0), 
					rs.getInt("ID_Questao"), rs.getString("LinkFicheiro"),rs.getString("Email_Docente"), rs.getInt("ID_Nivel")));
		}
		}catch(Exception e){}
		Random r = new Random();
		int r1 = r.nextInt(auxiliar.size());
		questao=auxiliar.get(r1);
		return auxiliar.get(r1);

	}
	
	//funcao alterada para receber a rsp que um int e devolver a string da avaliaçao
	public String obeterAvalaicao(int respostaR){
		System.out.println(questao.getResposta());
	if(respostaR==questao.getResposta()){
		return "Correcto";
	}
	return "Incorrecto";
	}
	//funcao alterada para nao receber argumentos e dar a explicasao
	public String obeterExplicacao(){	
	return getQuestao().getExplicação();
	}
	
	
	
	public boolean respostaCorreta(int respostaR){
		System.out.println(questao.getResposta());
		if(respostaR==questao.getResposta()){
			return true;
		}
		return false;
	}
	
	public Questao getQuestao() {
		return questao;
	}

//funcao responsavel por ir buscr todas as ucs relacionadas a um curso
	public ResultSet obterUCCurso(Object selected) {
		UC uc = new UC(con);
		uc.Select(con, selected);
		return uc.getRs();
		
	}
}
