package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Nivel_Dificuldade {
	private String Designacao_Nivel;
	private int ID_Nivel;
	private ResultSet rs;
	
	public Nivel_Dificuldade(Connection con){
		select(con);
	}

	public void select(Connection con){
		Statement s;
		try {
			s = con.createStatement();
			String query = "select * from Nivel_Dificuldade;" ;
			rs = s.executeQuery(query) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Nivel_Dificuldade(String designacao_Nivel, int iD_Nivel) {
		Designacao_Nivel = designacao_Nivel;
		ID_Nivel = iD_Nivel;
	}
	public String getDesignacao_Nivel() {
		return Designacao_Nivel;
	}
	public void setDesignacao_Nivel(String designacao_Nivel) {
		Designacao_Nivel = designacao_Nivel;
	}
	public int getID_Nivel() {
		return ID_Nivel;
	}
	public void setID_Nivel(int iD_Nivel) {
		ID_Nivel = iD_Nivel;
	}

	public ArrayList<Nivel_Dificuldade> fazArrayNiveis(){
		ArrayList<Nivel_Dificuldade> array = new ArrayList<Nivel_Dificuldade>();

		try {
			while(rs.next()){
				array.add(new Nivel_Dificuldade( rs.getString("Designacao_Nivel"),rs.getInt("ID_Nivel")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro a correr a query no Nivel");

		}
		return array;

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDesignacao_Nivel();
	}

}
