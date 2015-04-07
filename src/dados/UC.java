package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UC {
	private String DesignacaoUC;
	private String siglaUC;
	private ResultSet rs;
	
	public UC(Connection con){
		Select(con);
	}
	
	
	public ArrayList<UC> fazArrayUC(){
		ArrayList<UC> array = new ArrayList<UC>();

		try {
			while(rs.next()){
				array.add(new UC( rs.getString("Designacao_UC"), rs.getString("Sigla_UC")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro a correr a query no UC");

		}
		return array;

	}
	
	@Override
	public String toString() {
		return getDesignacaoUC();
	}
	
	public String getDesignacaoUC() {
		return DesignacaoUC;
	}

	public void setDesignacaoUC(String designacaoUC) {
		DesignacaoUC = designacaoUC;
	}

	public String getSiglaUC() {
		return siglaUC;
	}

	public void setSiglaUC(String siglaUC) {
		this.siglaUC = siglaUC;
	}

	public UC(String designacaoUC, String siglaUC) {
		super();
		DesignacaoUC = designacaoUC;
		this.siglaUC = siglaUC;
	}

	public void Select(Connection con){
		Statement s;
		try {
			s = con.createStatement();
			String query = "select * from UC;" ;
			rs = s.executeQuery(query) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void Select(Connection con,Object selected){
		Statement s;
		try {
			s = con.createStatement();
			String query = "select Designacao_UC from UC,UC_Curso where Sigla_Curso = '"+selected.toString()+"' and UC.Sigla_UC=UC_Curso.Sigla_UC;" ;
			rs = s.executeQuery(query) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


	public ResultSet getRs() {
		return rs;
	}
}
