package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	
	private Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] obtenerAdmin(String usuario, String contrasena) {
		String[] admin = new String[2];
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM admin WHERE USUARIO = ? AND CONTRASENA = ?");
			ps.setString(1, usuario);
			ps.setString(2, contrasena);

			rs = ps.executeQuery();

			if (rs.next()) {
				admin[0]=rs.getString("USUARIO");
				admin[1]=rs.getString("CONTRASENA");
			} else {
				admin=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return admin;
	}

	public static void main(String[] args) {
		Admin a = new Admin();
		String[] admin = a.obtenerAdmin("admin","1234");
		System.out.println(admin[0]);
		System.out.println(admin[1]);
		
	}

}
