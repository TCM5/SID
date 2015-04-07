package DataBase;

public class DB_Config {


	private static String DB_NOME = "database";
	private static String DB_FILE_PATH = "db\\" + DB_NOME + ".db";

	public static String DB_URL = "jdbc:sqlanywhere:Tds:localhost:2638?START=dbeng12;DBF=" + DB_FILE_PATH;
	public static String DB_USER = "sida";
	public static String DB_PASS = "sida";
}
