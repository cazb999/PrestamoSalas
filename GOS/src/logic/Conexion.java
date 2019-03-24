package logic;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private static Connection connection;
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "";
	public static final String url = "jdbc:mysql://localhost:3306/db_gos";
	
	public Conexion() {
		connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			if(connection != null) {
				System.out.println("Conexion establecida...");
			}
		} catch (Exception e) {
			System.out.println("Error al conectar con la base de datos..."+e);
		}
	}
	
	// este metodo retorna la conexion
	public Connection getConnection() {
		return connection;
	}
	
	// Este metodo terminar la conexion a la base de datos
	public void Desconectar() {
		connection = null;
		if(connection == null) {
			System.out.println("Conexion terminada...");
		}
	}
	

}
