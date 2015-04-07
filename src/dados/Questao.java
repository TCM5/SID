package dados;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Questao {
	private String Texto;
	private String Explica��o;
	private int Resposta;
	private int ISQuetao;
	private String LinkFicheiro;
//	private String DesignacaoModulo;
//	private String DesignacaoSubModulo;
	private String EmailDocente;
	private int IDNivel;
	
	
	
	public Questao(){}
	public Questao(String texto, String explica��o, int resposta,
			int iSQuetao, String linkFicheiro, String emailDocente, int iDNivel) {
		Texto = texto;
		Explica��o = explica��o;
		Resposta = resposta-48;
		ISQuetao = iSQuetao;
		LinkFicheiro = linkFicheiro;
//		DesignacaoModulo = designacaoModulo;
//		DesignacaoSubModulo = designacaoSubModulo;
		EmailDocente = emailDocente;
		IDNivel = iDNivel;
	}


	public String getTexto() {
		return Texto;
	}


	public void setTexto(String texto) {
		Texto = texto;
	}


	public String getExplica��o() {
		return Explica��o;
	}


	public void setExplica��o(String explica��o) {
		Explica��o = explica��o;
	}


	public int getResposta() {
		return Resposta;
	}


	public void setResposta(char resposta) {
		Resposta = resposta;
	}


	public int getISQuetao() {
		return ISQuetao;
	}


	public void setISQuetao(int iSQuetao) {
		ISQuetao = iSQuetao;
	}


	public String getLinkFicheiro() {
		return LinkFicheiro;
	}


	public void setLinkFicheiro(String linkFicheiro) {
		LinkFicheiro = linkFicheiro;
	}


//	public String getDesignacaoModulo() {
//		return DesignacaoModulo;
//	}
//
//
//	public void setDesignacaoModulo(String designacaoModulo) {
//		DesignacaoModulo = designacaoModulo;
//	}
//
//
//	public String getDesignacaoSubModulo() {
//		return DesignacaoSubModulo;
//	}
//
//
//	public void setDesignacaoSubModulo(String designacaoSubModulo) {
//		DesignacaoSubModulo = designacaoSubModulo;
//	}


	public String getEmailDocente() {
		return EmailDocente;
	}


	public void setEmailDocente(String emailDocente) {
		EmailDocente = emailDocente;
	}


	public int getIDNivel() {
		return IDNivel;
	}


	public void setIDNivel(int iDNivel) {
		IDNivel = iDNivel;
	}

//tem de ser alterado pois isto ja sabe a partida o id da questao e na 1� X nao sabemos nada 
	//talvs devam de existeir mais que um selec pois teos vairas pesquisas
	public void Select(int id){
		
	}


	public ArrayList<Questao> fazerArray(ResultSet rs) {
		ArrayList<Questao>questoes =  new ArrayList<Questao>();
		try{
			while(rs.next()){
				questoes.add(new Questao(rs.getString("Texto") , rs.getString("Explicacao"), rs.getInt("Resposta"), 
						rs.getInt("ID_Questao"), rs.getString("LinkFicheiro"), rs.getString("Email_Docente"), rs.getInt("ID_Nivel")));
			}
		}catch(Exception e){		}
		return questoes;
	}
	
}
