package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Modelo_Sala;

public class Sala {
	private Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;

	public Sala() {
		// TODO Auto-generated constructor stub
	}

	public boolean crearSala(Modelo_Sala sala) {
		Connection con = null;
		boolean save = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("INSERT INTO sala (NOMBRESALA, CAPACIDADSALA) values (?,?)");
			ps.setString(1, sala.getNOMBRESALA());
			ps.setInt(2, sala.getCAPACIDADSALA());

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

	public boolean eliminarSala(String nombreSala) {
		Connection con = null;
		boolean eliminado = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("DELETE FROM sala WHERE NOMBRESALA=?");
			ps.setString(1, nombreSala);

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

	public ArrayList<Modelo_Sala> obtenerSalas() {	
		ArrayList<Modelo_Sala> salas = new ArrayList<Modelo_Sala>();
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM sala");

			rs = ps.executeQuery();

			while (rs.next()) {
				Modelo_Sala sala = new Modelo_Sala(
						rs.getInt("IDSALA"),
						rs.getString("NOMBRESALA"),
						rs.getInt("CAPACIDADSALA")
						);
				
				salas.add(sala);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return salas;
	}

	public Modelo_Sala obtenerSala(String nombreSala) {
		Modelo_Sala sala = null;
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM sala WHERE NOMBRESALA = ?");
			ps.setString(1, nombreSala);

			rs = ps.executeQuery();

			if (rs.next()) {
				sala = new Modelo_Sala(
						rs.getInt("IDSALA"),
						rs.getString("NOMBRESALA"),
						rs.getInt("CAPACIDADSALA")
						);
			} else {
				sala=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return sala;
	}
	
	public Modelo_Sala obtenerSalaID(int idSala) {
		Modelo_Sala sala = null;
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM sala WHERE IDSALA = ?");
			ps.setInt(1, idSala);

			rs = ps.executeQuery();

			if (rs.next()) {
				sala = new Modelo_Sala(
						rs.getInt("IDSALA"),
						rs.getString("NOMBRESALA"),
						rs.getInt("CAPACIDADSALA")
						);
			} else {
				sala=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return sala;
	}
	
	public boolean salaExiste(String nombreSala) {
		Connection con = null;
		boolean usuarioExiste=false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM sala WHERE NOMBRESALA = ?");
			ps.setString(1, nombreSala);

			rs = ps.executeQuery();

			if (rs.next()) {
				usuarioExiste=true;
			} else {
				usuarioExiste=false;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return usuarioExiste;
	}

	public static void main(String[] args) {

		Sala s = new Sala();
		// agregar sala
//		if (s.crearSala(new Modelo_Sala(0 ,"A101", 25))) {
//			System.out.println("Se registro correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}
		
//		// buscar sala
		Modelo_Sala sala = s.obtenerSala("A401");
		System.out.println("ID: "+sala.getIDSALA());
		System.out.println("Nombre: "+sala.getNOMBRESALA());
		System.out.println("Capacidad: "+sala.getCAPACIDADSALA());
		
		//obtener todas las carreras
//		ArrayList<Modelo_Sala> salas = s.obtenerSalas();
//		for (int i = 0; i < salas.size(); i++) {
//			System.out.println("id = "+salas.get(i).getIDSALA()+" nombre = "+salas.get(i).getNOMBRESALA()+" capacidad = "+salas.get(i).getCAPACIDADSALA());
//		}
		
		//eliminar carrera
//		if (s.eliminarSala("A401")) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}

}
