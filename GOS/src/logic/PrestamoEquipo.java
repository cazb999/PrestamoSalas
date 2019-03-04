package logic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import models.Modelo_Prestamo_Equipo;

public class PrestamoEquipo {

	private Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;

	public PrestamoEquipo() {
		// TODO Auto-generated constructor stub
	}

	private boolean crearPrestamoEquipo(Modelo_Prestamo_Equipo prestamo) {
		Connection con = null;
		boolean save = false;

		try {
			// Fecha de inicio prestamo
			int yearInicio       = prestamo.getFECHA_INICIO().get(Calendar.YEAR);
			int monthInicio     = prestamo.getFECHA_INICIO().get(Calendar.MONTH); // Jan = 0, dec = 11
			int dayOfMonthInicio = prestamo.getFECHA_INICIO().get(Calendar.DAY_OF_MONTH);
			int hourOfDayInicio  = prestamo.getFECHA_INICIO().get(Calendar.HOUR_OF_DAY); // 24 hour clock
			int minuteInicio     = prestamo.getFECHA_INICIO().get(Calendar.MINUTE);
			
			// Fehca de fin prestamo
			int yearFin       = prestamo.getFECHA_FIN().get(Calendar.YEAR);
			int monthFin     = prestamo.getFECHA_FIN().get(Calendar.MONTH); // Jan = 0, dec = 11
			int dayOfMonthFin = prestamo.getFECHA_FIN().get(Calendar.DAY_OF_MONTH);
			int hourOfDayFin  = prestamo.getFECHA_FIN().get(Calendar.HOUR_OF_DAY); // 24 hour clock
			int minuteFin     = prestamo.getFECHA_FIN().get(Calendar.MINUTE);
			
			con = conexion.getConnection();
			ps = con.prepareStatement("insert into prestamoequipo (IDUSUARIO, IDEQUIPO, DIAPRESTAMOEQUIPO, HORAINICIO, HORAFIN, DIADEVOLUCIONEQUIPO) values (?,?,?,?,?,?)");
			ps.setInt(1, prestamo.getIDUSUARIO());
			ps.setInt(2, prestamo.getIDEQUIPO());
			ps.setString(3, yearInicio+"-"+monthInicio+"-"+dayOfMonthInicio+"");
			ps.setString(4, hourOfDayInicio+"-"+minuteInicio+"");
			ps.setString(5,hourOfDayFin+"-"+minuteFin+"");
			ps.setString(6, yearFin+"-"+monthFin+"-"+dayOfMonthFin+"");

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

	private boolean eliminarPrestamoEquipo(int idPrestamoEquipo) {
		Connection con = null;
		boolean eliminado = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("DELETE FROM prestamoequipo WHERE IDPRESTAMOEQUIPO=?");
			ps.setInt(1, idPrestamoEquipo);

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

	private ArrayList<Modelo_Prestamo_Equipo> obtenerPrestamosEquipo() {		
		ArrayList<Modelo_Prestamo_Equipo> prestamosEquipo = new ArrayList<Modelo_Prestamo_Equipo>();
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM prestamoequipo");

			rs = ps.executeQuery();

			while (rs.next()) {
				Modelo_Prestamo_Equipo prestamoEquipo = new Modelo_Prestamo_Equipo(
						rs.getInt("IDPRESTAMOEQUIPO"),
						rs.getInt("IDUSUARIO");
						rs.getInt("IDEQUIPO");
						rs.getString("DIAPRESTAMOEQUIPO");
						rs.getString("HORAINICIO");
						rs.getString("HORAFIN");
						rs.getString("DIADEVOLUCIONEQUIPO");
						);
				
				prestamosEquipo.add(prestamoEquipo);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return prestamosEquipo;
	}

	private Modelo_Prestamo_Equipo obtenerPrestamoEquipo(int idUsuario, int idEquipo) {
		Connection con = null;
		Modelo_Prestamo_Equipo prestamoEquipo = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM prestamoequipo WHERE IDUSUARIO = ? and IDEQUIPO = ?");
			ps.setInt(1, idUsuario);
			ps.setInt(2, idEquipo);

			rs = ps.executeQuery();

			if (rs.next()) {
				prestamoEquipo = new Modelo_Prestamo_Equipo(
						rs.getInt("IDPRESTAMOEQUIPO"),
						rs.getInt("IDUSUARIO"),
						rs.getInt("IDEQUIPO"),
						rs.getDate("DIAPRESTAMOSALA"),
						rs.getTime("HORAINICIO"),
						rs.getTime("HORAFIN")
						);
			} else {
				prestamoEquipo=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return prestamoEquipo;
	}

	public static void main(String[] args) {

		PrestamoEquipo pe = new PrestamoEquipo();
		// agregar usuario
		// Jan = 0, dec = 11
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");	
		Calendar calendar = new GregorianCalendar(2019,04,27);
		System.out.println(sdf.format(calendar.getTime()));
		if (pe.crearPrestamoEquipo(new Modelo_Prestamo_Equipo(0, 1, 1, calendar, new Time(12, 00, 00), new Time(14, 00, 00)))) {
			System.out.println("Se registro correctamente el prestamo");
		} else {
			System.out.println("Ocurrió un error");
		}
		
//		// buscar USUARIO
//		Modelo_Usuario usuario = u.obtenerUsuario(201322123);
//		System.out.println("ID "+usuario.getIDUSUARIO());
//		System.out.println("ID Carrera "+usuario.getIDCARRERA());
//		System.out.println("ID Tipo"+usuario.getIDTIPO());
//		System.out.println("Codigo "+usuario.getCODIGOUSUARIO());
//		System.out.println("Nombre "+usuario.getNOMBREUSUARIO());
//		System.out.println("Apellido "+usuario.getAPELLIDOUSUARIO());
		
		//obtener todos los usuarios
//		ArrayList<Modelo_Usuario> usuarios = u.obtenerUsuarios();
//		for (int i = 0; i < usuarios.size(); i++) {
//			System.out.println("Codigo = "+usuarios.get(i).getCODIGOUSUARIO()+" Nombre = "+usuarios.get(i).getNOMBREUSUARIO());
//		}
		
		//eliminar carrera
//		if (u.eliminarUsuario(201322123)) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}
}
