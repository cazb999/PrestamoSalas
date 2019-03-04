package logic;

import java.sql.*;
import java.util.ArrayList;

public class Carrera {

	private Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;

	public Carrera() {
		// TODO Auto-generated constructor stub
	}

	private boolean crearCarrera(String nombreCarrera) {
		Connection con = null;
		boolean save = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("insert into carrera (NOMBRECARRERA) values (?)");
			ps.setString(1, nombreCarrera);

			int res = ps.executeUpdate();

			if (res > 0) {
				save = true;
			} else {
				save = false;
			}

			con.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		return save;
	}

	private boolean eliminarCarrera(String nombreCarrera) {
		Connection con = null;
		boolean eliminado = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("DELETE FROM carrera WHERE NOMBRECARRERA=?");
			ps.setString(1, nombreCarrera);

			int res = ps.executeUpdate();

			if (res > 0) {
				eliminado = true;
			} else {
				eliminado = false;
			}

			con.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		return eliminado;
	}

	private ArrayList<String[]> obtenerCarreras() {		
		ArrayList<String[]> carreras = new ArrayList<String[]>();
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM carrera");

			rs = ps.executeQuery();

			while (rs.next()) {
				String[] carrera = new String[2];
				carrera[0]=rs.getString("IDCARRERA");
				carrera[1]=rs.getString("NOMBRECARRERA");
				
				carreras.add(carrera);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return carreras;
	}

	private String[] obtenerCarrera(String nombreCarrera) {
		String[] carrera = new String[2];
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM carrera WHERE NOMBRECARRERA = ?");
			ps.setString(1, nombreCarrera);

			rs = ps.executeQuery();

			if (rs.next()) {
				carrera[0]=rs.getString("IDCARRERA");
				carrera[1]=rs.getString("NOMBRECARRERA");
			} else {
				carrera=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return carrera;
	}

	public static void main(String[] args) {

		Carrera c = new Carrera();
		// agregar carrera
//		if (c.crearCarrera("Ing Industrial")) {
//			System.out.println("Se registro correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}
		
//		// buscar carrera
//		String[] carrera = c.obtenerCarrera("Ing Minas");
//		System.out.println(carrera[0]);
//		System.out.println(carrera[1]);
		
		//obtener todas las carreras
		ArrayList<String[]> carreras = c.obtenerCarreras();
		for (int i = 0; i < carreras.size(); i++) {
			System.out.println("id = "+carreras.get(i)[0]+" nombre = "+carreras.get(i)[1]);
		}
		
		//eliminar carrera
//		if (c.eliminarCarrera("Ing Industrial")) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}

}
