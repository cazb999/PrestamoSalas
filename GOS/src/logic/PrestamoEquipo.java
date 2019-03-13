package logic;

import java.awt.Window.Type;
import java.sql.Connection;
import java.util.Date;
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

	public boolean crearPrestamoEquipo(Modelo_Prestamo_Equipo prestamo) {
		Connection con = null;
		boolean save = false;

		try {
			// Fecha de inicio prestamo
			int yearInicio       = prestamo.getFECHA_INICIO().get(Calendar.YEAR);
			int monthInicio     = prestamo.getFECHA_INICIO().get(Calendar.MONTH); // Jan = 0, dec = 11
			int dayOfMonthInicio = prestamo.getFECHA_INICIO().get(Calendar.DAY_OF_MONTH);
			int hourOfDayInicio  = prestamo.getFECHA_INICIO().get(Calendar.HOUR_OF_DAY); // 24 hour clock
			int minuteInicio     = prestamo.getFECHA_INICIO().get(Calendar.MINUTE);
			int secondInicio    = prestamo.getFECHA_INICIO().get(Calendar.SECOND);
			
			// Fehca de fin prestamo
			int yearFin       = prestamo.getFECHA_FIN().get(Calendar.YEAR);
			int monthFin     = prestamo.getFECHA_FIN().get(Calendar.MONTH); // Jan = 0, dec = 11
			int dayOfMonthFin = prestamo.getFECHA_FIN().get(Calendar.DAY_OF_MONTH);
			int hourOfDayFin  = prestamo.getFECHA_FIN().get(Calendar.HOUR_OF_DAY); // 24 hour clock
			int minuteFin     = prestamo.getFECHA_FIN().get(Calendar.MINUTE);
			int secondFin    = prestamo.getFECHA_FIN().get(Calendar.SECOND);
			
			con = conexion.getConnection();
			ps = con.prepareStatement("insert into prestamoequipo (IDUSUARIO, IDEQUIPO, DIAPRESTAMOEQUIPO, HORAINICIO, HORAFIN, DIADEVOLUCIONEQUIPO) values (?,?,?,?,?,?)");
			ps.setInt(1, prestamo.getIDUSUARIO());
			ps.setInt(2, prestamo.getIDEQUIPO());
			ps.setString(3, yearInicio+"-"+monthInicio+"-"+dayOfMonthInicio+"");
			ps.setString(4, hourOfDayInicio+":"+minuteInicio+":"+secondInicio);
			ps.setString(5,hourOfDayFin+":"+minuteFin+":"+secondFin);
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

	public boolean eliminarPrestamoEquipo(int idPrestamoEquipo) {
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

	public ArrayList<Modelo_Prestamo_Equipo> obtenerPrestamosEquipo() {
		ArrayList<Modelo_Prestamo_Equipo> prestamosEquipo = new ArrayList<Modelo_Prestamo_Equipo>();
		Connection con = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM prestamoequipo");

			rs = ps.executeQuery();

			while (rs.next()) {
				Date date_inicio = sdf.parse(rs.getString("DIAPRESTAMOEQUIPO")+" "+rs.getString("HORAINICIO"));
				Date date_fin = sdf.parse(rs.getString("DIADEVOLUCIONEQUIPO")+" "+rs.getString("HORAFIN"));
				
				Calendar calendar_inicio = Calendar.getInstance();
				calendar_inicio.setTime(date_inicio);
				
				Calendar calendar_fin = Calendar.getInstance();
				calendar_fin.setTime(date_fin);
				
				Modelo_Prestamo_Equipo prestamoEquipo = new Modelo_Prestamo_Equipo(
						rs.getInt("IDPRESTAMOEQUIPO"),
						rs.getInt("IDUSUARIO"),
						rs.getInt("IDEQUIPO"),
						calendar_inicio,
						calendar_fin
						);
				
				prestamosEquipo.add(prestamoEquipo);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return prestamosEquipo;
	}

	public Modelo_Prestamo_Equipo obtenerPrestamoEquipo(int idPrestamoEquipo) {
		Connection con = null;
		Modelo_Prestamo_Equipo prestamoEquipo = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM prestamoequipo WHERE IDPRESTAMOEQUIPO = ?");
			ps.setInt(1, idPrestamoEquipo);

			rs = ps.executeQuery();

			if (rs.next()) {
				Date date_inicio = sdf.parse(rs.getString("DIAPRESTAMOEQUIPO")+" "+rs.getString("HORAINICIO"));
				Date date_fin = sdf.parse(rs.getString("DIADEVOLUCIONEQUIPO")+" "+rs.getString("HORAFIN"));
				
				Calendar calendar_inicio = Calendar.getInstance();
				calendar_inicio.setTime(date_inicio);
				
				Calendar calendar_fin = Calendar.getInstance();
				calendar_fin.setTime(date_fin);
				
				prestamoEquipo = new Modelo_Prestamo_Equipo(
						rs.getInt("IDPRESTAMOEQUIPO"),
						rs.getInt("IDUSUARIO"),
						rs.getInt("IDEQUIPO"),
						calendar_inicio,
						calendar_fin
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
		// agregar prestamo equipo
		// Jan = 0, dec = 11
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd hh:mm:ss");
//		Calendar calendar_inicio = new GregorianCalendar(2019,03,12,14,0,0);
//		Calendar calendar_fin = new GregorianCalendar(2019,03,12,16,0,0);
//		
//		if (pe.crearPrestamoEquipo(new Modelo_Prestamo_Equipo(0, 2, 2, calendar_inicio, calendar_fin))) {
//			System.out.println("Se registro correctamente el prestamo");
//		} else {
//			System.out.println("Ocurrió un error");
//		}
		
//		// buscar Prestamo Equipo
//		Modelo_Prestamo_Equipo prestamo = pe.obtenerPrestamoEquipo(3);
//		System.out.println("ID "+prestamo.getIDPRESTAMOEQUIPO());
//		System.out.println("ID Usuario "+prestamo.getIDUSUARIO());
//		System.out.println("ID Equipo "+prestamo.getIDEQUIPO());
//		System.out.println("Fecha inicio "+sdf.format(prestamo.getFECHA_INICIO().getTime()));
//		System.out.println("fecha fin "+sdf.format(prestamo.getFECHA_FIN().getTime()));
		
		//obtener todos los usuarios
		ArrayList<Modelo_Prestamo_Equipo> prestamos = pe.obtenerPrestamosEquipo();
		for (int i = 0; i < prestamos.size(); i++) {
			System.out.println("ID = "+prestamos.get(i).getIDPRESTAMOEQUIPO()+" Fecha Inicio = "+sdf.format(prestamos.get(i).getFECHA_INICIO().getTime())+" Fecha Fin = "+sdf.format(prestamos.get(i).getFECHA_FIN().getTime()));
		}
//		
		//eliminar carrera
//		if (pe.eliminarPrestamoEquipo(3)) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}
}
