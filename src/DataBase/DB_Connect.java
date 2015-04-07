package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Connect {

	private Connection connection;

	public DB_Connect() {
		startConnection();
	}

	private void startConnection(){

		try {
			connection = DriverManager.getConnection(DB_Config.DB_URL, DB_Config.DB_USER, DB_Config.DB_PASS);
//		
		} catch (Exception e) {
			System.err.println( "Problema de acesso à Base de Dados - "+ e.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	
	//TESTE
	public static void main(String[] args) {
		new DB_Connect();
	}


}
