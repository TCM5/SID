package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sub_Modulo {
	private String Designacao_Modulo;
	private String Designacao_Sub_Modulo;
	private String Email_Docente;
	private int ID_Questao;
	private ResultSet rs;

	public Sub_Modulo(Connection con){
		select(con);
	}

	public void select(Connection con){
		Statement s;
		try {
			s = con.createStatement();
			String query = "select * from Sub_Modulo;" ;
			rs = s.executeQuery(query) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Sub_Modulo(String designacao_Modulo, String designacao_Sub_Modulo,
			String email_Docente, int iD_Questao) {
		Designacao_Modulo = designacao_Modulo;
		Designacao_Sub_Modulo = designacao_Sub_Modulo;
		Email_Docente = email_Docente;
		ID_Questao = iD_Questao;
	}
	public String getDesignacao_Modulo() {
		return Designacao_Modulo;
	}
	public void setDesignacao_Modulo(String designacao_Modulo) {
		Designacao_Modulo = designacao_Modulo;
	}
	public String getDesignacao_Sub_Modulo() {
		return Designacao_Sub_Modulo;
	}
	public void setDesignacao_Sub_Modulo(String designacao_Sub_Modulo) {
		Designacao_Sub_Modulo = designacao_Sub_Modulo;
	}
	public String getEmail_Docente() {
		return Email_Docente;
	}
	public void setEmail_Docente(String email_Docente) {
		Email_Docente = email_Docente;
	}
	public int getID_Questao() {
		return ID_Questao;
	}
	public void setID_Questao(int iD_Questao) {
		ID_Questao = iD_Questao;
	}

	public ArrayList<Sub_Modulo> fazArraySubModulo(){
		ArrayList<Sub_Modulo> array = new ArrayList<Sub_Modulo>();

		try {
			while(rs.next()){
				array.add(new Sub_Modulo( rs.getString("Designacao_Modulo"), rs.getString("Designacao_Sub_Modulo"),rs.getString("Email_Docente"),rs.getInt("ID_Questao")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro a correr a query no Sub Modulo");

		}
		return array;

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDesignacao_Sub_Modulo();
	}

}
