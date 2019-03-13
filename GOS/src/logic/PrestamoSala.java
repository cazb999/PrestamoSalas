package logic;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import models.Modelo_Prestamo_Sala;

public class PrestamoSala {
	
	private Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	
	public PrestamoSala() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean crearPrestamoSala(Modelo_Prestamo_Sala prestamo) {
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
			ps = con.prepareStatement("insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values (?,?,?,?,?,?)");
			ps.setString(1, yearInicio+"-"+monthInicio+"-"+dayOfMonthInicio+"");
			ps.setString(2, hourOfDayInicio+":"+minuteInicio+":"+secondInicio);
			ps.setString(3, yearFin+"-"+monthFin+"-"+dayOfMonthFin+"");
			ps.setString(4,hourOfDayFin+":"+minuteFin+":"+secondFin);
			ps.setInt(5, prestamo.getIDUSUARIO());
			ps.setInt(6, prestamo.getIDSALA());

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
	
	public boolean eliminarPrestamoSala(int idPrestamoSala) {
		Connection con = null;
		boolean eliminado = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("DELETE FROM prestamosala WHERE IDPRESTAMOSALA=?");
			ps.setInt(1, idPrestamoSala);

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
	
	public ArrayList<Modelo_Prestamo_Sala> obtenerPrestamosSala() {
		ArrayList<Modelo_Prestamo_Sala> prestamosSala = new ArrayList<Modelo_Prestamo_Sala>();
		Connection con = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM prestamosala");

			rs = ps.executeQuery();

			while (rs.next()) {
				Date date_inicio = sdf.parse(rs.getString("DIAPRESTAMOSALA")+" "+rs.getString("HORAINICIO"));
				Date date_fin = sdf.parse(rs.getString("DIADEVOLUCIONSALA")+" "+rs.getString("HORAFIN"));
				
				Calendar calendar_inicio = Calendar.getInstance();
				calendar_inicio.setTime(date_inicio);
				
				Calendar calendar_fin = Calendar.getInstance();
				calendar_fin.setTime(date_fin);
				
				Modelo_Prestamo_Sala prestamoSala = new Modelo_Prestamo_Sala(
						rs.getInt("IDPRESTAMOSALA"),
						calendar_inicio,
						calendar_fin,
						rs.getInt("IDUSUARIO"),
						rs.getInt("IDSALA")						
						);
				
				prestamosSala.add(prestamoSala);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return prestamosSala;
	}
	
	public Modelo_Prestamo_Sala obtenerPrestamoSala(int idPrestamo) {
		Connection con = null;
		Modelo_Prestamo_Sala prestamoSala = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM prestamosala WHERE IDPRESTAMOSALA = ?");
			ps.setInt(1, idPrestamo);

			rs = ps.executeQuery();

			if (rs.next()) {
				Date date_inicio = sdf.parse(rs.getString("DIAPRESTAMOSALA")+" "+rs.getString("HORAINICIO"));
				Date date_fin = sdf.parse(rs.getString("DIADEVOLUCIONSALA")+" "+rs.getString("HORAFIN"));
				
				Calendar calendar_inicio = Calendar.getInstance();
				calendar_inicio.setTime(date_inicio);
				
				Calendar calendar_fin = Calendar.getInstance();
				calendar_fin.setTime(date_fin);
				
				prestamoSala = new Modelo_Prestamo_Sala(
						rs.getInt("IDPRESTAMOSALA"),
						calendar_inicio,
						calendar_fin,
						rs.getInt("IDUSUARIO"),
						rs.getInt("IDSALA")						
						);
			} else {
				prestamoSala=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return prestamoSala;
	}

	public static void main(String[] args) {
		PrestamoSala ps = new PrestamoSala();
		// agregar prestamo equipo
		// Jan = 0, dec = 11
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd hh:mm:ss");
//		Calendar calendar_inicio = new GregorianCalendar(2019,03,12,18,0,0);
//		Calendar calendar_fin = new GregorianCalendar(2019,03,12,20,0,0);
//		
//		if (ps.crearPrestamoSala(new Modelo_Prestamo_Sala(0, calendar_inicio, calendar_fin, 3, 1))) {
//			System.out.println("Se registro correctamente el prestamo");
//		} else {
//			System.out.println("Ocurrió un error");
//		}
		
//		// buscar Prestamo Equipo
//		Modelo_Prestamo_Sala prestamo = ps.obtenerPrestamoSala(1);
//		System.out.println("ID "+prestamo.getIDPRESTAMOSALA());
//		System.out.println("ID Usuario "+prestamo.getIDUSUARIO());
//		System.out.println("ID Equipo "+prestamo.getIDSALA());
//		System.out.println("Fecha inicio "+sdf.format(prestamo.getFECHA_INICIO().getTime()));
//		System.out.println("fecha fin "+sdf.format(prestamo.getFECHA_FIN().getTime()));
		
		//obtener todos los usuarios
		ArrayList<Modelo_Prestamo_Sala> prestamos = ps.obtenerPrestamosSala();
		for (int i = 0; i < prestamos.size(); i++) {
			System.out.println("ID = "+prestamos.get(i).getIDPRESTAMOSALA()+" Fecha Inicio = "+sdf.format(prestamos.get(i).getFECHA_INICIO().getTime())+" Fecha Fin = "+sdf.format(prestamos.get(i).getFECHA_FIN().getTime()));
		}

		//eliminar carrera
//		if (ps.eliminarPrestamoSala(3)) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}

}
