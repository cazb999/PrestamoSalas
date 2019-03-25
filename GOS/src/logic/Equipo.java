package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Modelo_Equipo;

public class Equipo {
	private Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;

	public Equipo() {
		// TODO Auto-generated constructor stub
	}

	public boolean crearEquipo(Modelo_Equipo equipo) {
		Connection con = null;
		boolean save = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("INSERT INTO equipo (NOMBREEQUIPO, IDSALA) values (?,?)");
			ps.setString(1, equipo.getNOMBREEQUIPO());
			ps.setInt(2, equipo.getIDSALA());

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

	public boolean eliminarEquipo(String nombreEquipo, int idSala) {
		Connection con = null;
		boolean eliminado = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("DELETE FROM equipo WHERE NOMBREEQUIPO=? AND IDSALA = ?");
			ps.setString(1, nombreEquipo);
			ps.setInt(2, idSala);

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

	public ArrayList<Modelo_Equipo> obtenerEquipos(int idSala) {
		ArrayList<Modelo_Equipo> equipos = new ArrayList<Modelo_Equipo>();
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM equipo WHERE IDSALA = ?");
			ps.setInt(1, idSala);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				Modelo_Equipo equipo = new Modelo_Equipo(
						rs.getInt("IDEQUIPO"),
						rs.getString("NOMBREEQUIPO"),
						rs.getInt("IDSALA")
						);
				
				equipos.add(equipo);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return equipos;
	}

	public Modelo_Equipo obtenerEquipo(String nombreEquipo, int idSala) {
		Modelo_Equipo equipo = null;
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM equipo WHERE NOMBREEQUIPO = ? AND IDSALA = ?");
			ps.setString(1, nombreEquipo);
			ps.setInt(2, idSala);

			rs = ps.executeQuery();

			if (rs.next()) {
				equipo = new Modelo_Equipo(
						rs.getInt("IDEQUIPO"),
						rs.getString("NOMBREEQUIPO"),
						rs.getInt("IDSALA")
						);
			} else {
				equipo=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return equipo;
	}
	
	public Modelo_Equipo obtenerEquipoDisponible(String nombreSala) {
		Modelo_Equipo equipo = null;
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("select e.* from equipo as e\n" + 
					"inner join SALA as s on e.IDSALA = s.IDSALA\n" + 
					"left join PRESTAMOEQUIPO as pe on pe.IDEQUIPO = e.IDEQUIPO\n" + 
					"where s.NOMBRESALA = ?\n" + 
					"and pe.IDEQUIPO is null\n" + 
					"limit 1");
			ps.setString(1, nombreSala);

			rs = ps.executeQuery();

			if (rs.next()) {
				equipo = new Modelo_Equipo(
						rs.getInt("IDEQUIPO"),
						rs.getString("NOMBREEQUIPO"),
						rs.getInt("IDSALA")
						);
			} else {
				equipo=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return equipo;
	}

	public static void main(String[] args) {

		Equipo e = new Equipo();
		// agregar equipo
//		if (e.crearEquipo(new Modelo_Equipo(0 ,"E03", 2))) {
//			System.out.println("Se registro correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}
		
//		// buscar equipo
		Modelo_Equipo equipo = e.obtenerEquipoDisponible("A101");
		System.out.println("ID: "+equipo.getIDEQUIPO());
		System.out.println("Nombre: "+equipo.getNOMBREEQUIPO());
		System.out.println("Sala: "+equipo.getIDSALA());
		
		//obtener todas las carreras
//		ArrayList<Modelo_Equipo> equipos = e.obtenerEquipos(1);
//		for (int i = 0; i < equipos.size(); i++) {
//			System.out.println("id = "+equipos.get(i).getIDEQUIPO()+" nombre = "+equipos.get(i).getNOMBREEQUIPO()+" Sala = "+equipos.get(i).getIDSALA());
//		}
		
		//eliminar carrera
//		if (e.eliminarEquipo("E03",1)) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}
}
