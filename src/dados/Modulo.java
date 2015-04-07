package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modulo {

	private String Email_Docente;
	private String Designacao_Modulo;
	private ResultSet rs;

	public Modulo(String designacao_Modulo, String email_Docente) {

		Designacao_Modulo = designacao_Modulo;
		Email_Docente = email_Docente;
	}
	public Modulo(Connection con) {
		select(con);
	}

	public ArrayList<Modulo> fazArrayModulo(){
		ArrayList<Modulo> array = new ArrayList<Modulo>();

		try {
			while(rs.next()){
				array.add(new Modulo( rs.getString("Designacao_Modulo"), rs.getString("Email_Docente")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro a correr a query no Modulo");

		}
		return array;

	}

	public void select(Connection con){
		try{
		Statement s = con.createStatement();
		String query = "select * from Modulo;" ;
		 rs = s.executeQuery(query) ;
		}
		catch(SQLException e){e.printStackTrace();}
		
	}

	@Override
	public String toString(){
		return getDesignacao_Modulo();
	}
	public String getEmail_Docente() {
		return Email_Docente;
	}

	public void setEmail_Docente(String email_Docente) {
		Email_Docente = email_Docente;
	}

	public String getDesignacao_Modulo() {
		return Designacao_Modulo;
	}

	public void setDesignacao_Modulo(String designacao_Modulo) {
		Designacao_Modulo = designacao_Modulo;
	}




}
