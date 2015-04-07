package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Curso {

	private Connection conn;
	private String Sigla_Curso;
	private String Designacao_Curso;
	private 	ResultSet rs;

	public Curso(Connection con){
		select(con);

	}

	public Curso(String sigla_Curso, String designacao_Curso) {
		super();
		Sigla_Curso = sigla_Curso;
		Designacao_Curso = designacao_Curso;
	}
	


	public ArrayList<Curso> fazArrayCurso(){
		ArrayList<Curso> array = new ArrayList<Curso>();

		try {
			while(rs.next()){
				array.add(new Curso( rs.getString("Sigla_Curso"), rs.getString("Designacao_Curso")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro a correr a query no Modulo");

		}
		return array;

	}

	public void select(Connection con){
		Statement s;
		try {
			s = con.createStatement();
			String query = "select * from Curso;" ;
			rs = s.executeQuery(query) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return getSigla_Curso();
	}


	public String getSigla_Curso() {
		return Sigla_Curso;
	}
	public void setSigla_Curso(String sigla_Curso) {
		Sigla_Curso = sigla_Curso;
	}
	public String getDesignacao_Curso() {
		return Designacao_Curso;
	}
	public void setDesignacao_Curso(String designacao_Curso) {
		Designacao_Curso = designacao_Curso;
	}



}
