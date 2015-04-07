import DataBase.DB_Connect;


public class Main {

	public static void main(String[] args) {
		DB_Connect a = new DB_Connect();
		new GUI(a.getConnection());
		

	}

}
