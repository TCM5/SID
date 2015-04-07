package dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.crypto.Data;

public class Resposta {
	private String Email_Aluno;
	private Date Data_Resposta;
	private int IDQuestao;
	private int RespostaEscolhida;
	private Connection conn;
	
	
	public Resposta(String email_Aluno, Date data_Resposta, int iDQuestao,
			int respostaEscolhida) {
		
		// fazer com que isto seja introduzido na bd neste formato 2015-04-06 18:41:39.000 
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		Email_Aluno = email_Aluno;
		Data_Resposta = sqlDate;
		IDQuestao = iDQuestao;
		RespostaEscolhida = respostaEscolhida;
		
	}

	//* responsavel por ir buscar a questão a base de dados pelo id 
	public void Select(int Id){
		
	}
	
	//funçao nao utilizada por n faz sentido usar esta query para buscar a avaliaçao, faz sentido ir bucar a pergunta e realizar as opeçoes necessarias
	public void Select(String query){
		
	}
	
	//funçao utilizada para inserir uma nova resposta na base de dados
	public void insert(Connection con){
		try {
			
			PreparedStatement s = con.prepareStatement("BEGIN TRANSACTION TRAN_01 " +  
		                            "insert into Resposta (Email_Aluno, ID_Questao, Resposta_Escolhida, Data_Resposta)values(?,?,?,?)"+
			                            "COMMIT TRANSACTION TRAN_01 ");
			s.setString(1, Email_Aluno);
			s.setInt(2, IDQuestao);
			s.setInt(3, RespostaEscolhida);
			s.setDate(4, Data_Resposta);
			
			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public Date getData_Resposta() {
		return Data_Resposta;
	}

	public int getRespostaEscolhida() {
		return RespostaEscolhida;
	}
	
	
}
