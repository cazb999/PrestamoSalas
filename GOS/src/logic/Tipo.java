package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Tipo {
	private Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;

	public Tipo() {
		
	}

	private boolean crearTipo(String nombreTipo) {
		Connection con = null;
		boolean save = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("insert into tipo (NOMBRETIPO) values (?)");
			ps.setString(1, nombreTipo);

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

	private boolean eliminarTipo(String nombreTipo) {
		Connection con = null;
		boolean eliminado = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("DELETE FROM tipo WHERE NOMBRETIPO=?");
			ps.setString(1, nombreTipo);

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

	private ArrayList<String[]> obtenerTipos() {		
		ArrayList<String[]> tipos = new ArrayList<String[]>();
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM tipo");

			rs = ps.executeQuery();

			while (rs.next()) {
				String[] tipo = new String[2];
				tipo[0]=rs.getString("IDTIPO");
				tipo[1]=rs.getString("NOMBRETIPO");
				
				tipos.add(tipo);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return tipos;
	}

	private String[] obtenerTipo(String nombreTipo) {
		String[] tipo = new String[2];
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM tipo WHERE NOMBRETIPO = ?");
			ps.setString(1, nombreTipo);

			rs = ps.executeQuery();

			if (rs.next()) {
				tipo[0]=rs.getString("IDTIPO");
				tipo[1]=rs.getString("NOMBRETIPO");
			} else {
				tipo=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return tipo;
	}

	public static void main(String[] args) {

		Tipo t = new Tipo();
		// agregar carrera
		if (t.crearTipo("Administrativo")) {
			System.out.println("Se registro correctamente");
		} else {
			System.out.println("Ocurrió un error");
		}
		
//		// buscar carrera
//		String[] tipo = t.obtenerTipo("Administrativo");
//		System.out.println(tipo[0]);
//		System.out.println(tipo[1]);
		
		//obtener todas las carreras
//		ArrayList<String[]> tipos = t.obtenerTipos();
//		for (int i = 0; i < tipos.size(); i++) {
//			System.out.println("id = "+tipos.get(i)[0]+" nombre = "+tipos.get(i)[1]);
//		}
//		
		//eliminar carrera
//		if (t.eliminarTipo("Administrativo")) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}


}
