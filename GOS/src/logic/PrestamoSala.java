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
			ps.setString(1, yearInicio+"-"+(monthInicio+1)+"-"+dayOfMonthInicio+"");
			ps.setString(2, hourOfDayInicio+":"+minuteInicio+":"+secondInicio);
			ps.setString(3, yearFin+"-"+(monthFin+1)+"-"+dayOfMonthFin+"");
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
	
	public ArrayList<Modelo_Prestamo_Sala> obtenerPrestamosSalaPorFecha(Calendar fecha, String nombreSala) {
		ArrayList<Modelo_Prestamo_Sala> prestamosSala = new ArrayList<Modelo_Prestamo_Sala>();
		Connection con = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf_input = new SimpleDateFormat("yyyy-MM-dd");

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT ps.* FROM prestamosala as ps\n" + 
					"INNER JOIN sala as s ON ps.IDSALA = s.IDSALA\n" + 
					"WHERE ps.DIAPRESTAMOSALA = ?\n" + 
					"AND s.NOMBRESALA = ?;");
			ps.setString(1, sdf_input.format(fecha.getTime()));
			ps.setString(2, nombreSala);
			
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
	
	public boolean eliminarPrestamoSala(Modelo_Prestamo_Sala prestamo) {
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
			ps = con.prepareStatement("delete from prestamosala where DIAPRESTAMOSALA = ? and HORAINICIO=? and DIADEVOLUCIONSALA=? and HORAFIN=? and IDSALA=?");
			ps.setString(1, yearInicio+"-"+(monthInicio+1)+"-"+dayOfMonthInicio+"");
			ps.setString(2, hourOfDayInicio+":"+minuteInicio+":"+secondInicio);
			ps.setString(3, yearFin+"-"+(monthFin+1)+"-"+dayOfMonthFin+"");
			ps.setString(4,hourOfDayFin+":"+minuteFin+":"+secondFin);
			ps.setInt(5, prestamo.getIDSALA());

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
	
	public boolean eliminarPrestamoSalaConEquipo(Modelo_Prestamo_Sala prestamo) {
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
			
			con = conexion.getConnection();
			ps = con.prepareStatement("delete prestamoequipo from prestamoequipo\n" + 
					"inner join equipo on prestamoequipo.idequipo = equipo.idequipo\n" + 
					"where equipo.idsala = ?\n" + 
					"and prestamoequipo.diaprestamoequipo = ?\n" + 
					"and prestamoequipo.horainicio = ?;");
			ps.setInt(1, prestamo.getIDSALA());
			ps.setString(2, yearInicio+"-"+(monthInicio+1)+"-"+dayOfMonthInicio+"");
			ps.setString(3, hourOfDayInicio+":"+minuteInicio+":"+secondInicio);

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
	
	public int contadorPrestamosSala(Modelo_Prestamo_Sala prestamo) {
		Connection con = null;
		int contador=0;

		try {
			
			// Fecha de inicio prestamo
						int yearInicio       = prestamo.getFECHA_INICIO().get(Calendar.YEAR);
						int monthInicio     = prestamo.getFECHA_INICIO().get(Calendar.MONTH); // Jan = 0, dec = 11
						int dayOfMonthInicio = prestamo.getFECHA_INICIO().get(Calendar.DAY_OF_MONTH);
						int hourOfDayInicio  = prestamo.getFECHA_INICIO().get(Calendar.HOUR_OF_DAY); // 24 hour clock
						int minuteInicio     = prestamo.getFECHA_INICIO().get(Calendar.MINUTE);
						int secondInicio    = prestamo.getFECHA_INICIO().get(Calendar.SECOND);

			con = conexion.getConnection();
			ps = con.prepareStatement("select count(e.idequipo) as contador from equipo as e\n" + 
					"inner join SALA as s on e.IDSALA = s.IDSALA\n" + 
					"where s.idsala = ?\n" + 
					"and e.IDEQUIPO not in\n" + 
					"(select idequipo from prestamoequipo\n" + 
					"where diaprestamoequipo = ?\n" + 
					"and HORAINICIO = ?\n" + 
					"and horafin is null\n" + 
					"and diadevolucionequipo is null)");
			ps.setInt(1, prestamo.getIDSALA());
			ps.setString(2, yearInicio+"-"+(monthInicio+1)+"-"+dayOfMonthInicio+"");
			ps.setString(3, hourOfDayInicio+":"+minuteInicio+":"+secondInicio);

			rs = ps.executeQuery();

			if (rs.next()) {
				contador = rs.getInt("contador");
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return contador;
	}
	
	public int numeroCompuSalas(int idSala) {
		Connection con = null;
		int contador=0;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("select count(idequipo) as contador from equipo where idsala = ?");
			ps.setInt(1, idSala);

			rs = ps.executeQuery();

			if (rs.next()) {
				contador = rs.getInt("contador");
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return contador;
	}

	public static void main(String[] args) {
		PrestamoSala ps = new PrestamoSala();
		// agregar prestamo equipo
		// Jan = 0, dec = 11
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd hh:mm:ss");
		Calendar calendar_inicio = new GregorianCalendar(2019,03,29,8,0,0);
		Calendar calendar_fin = new GregorianCalendar(2019,03,29,8,0,0);
		
		if (ps.eliminarPrestamoSala(new Modelo_Prestamo_Sala(0, calendar_inicio, calendar_fin, 3, 1))) {
			System.out.println("Se elimino correctamente el prestamo");
		} else {
			System.out.println("Ocurrió un error");
		}
		
//		// buscar Prestamo Equipo
//		Modelo_Prestamo_Sala prestamo = ps.obtenerPrestamoSala(1);
//		System.out.println("ID "+prestamo.getIDPRESTAMOSALA());
//		System.out.println("ID Usuario "+prestamo.getIDUSUARIO());
//		System.out.println("ID Equipo "+prestamo.getIDSALA());
//		System.out.println("Fecha inicio "+sdf.format(prestamo.getFECHA_INICIO().getTime()));
//		System.out.println("fecha fin "+sdf.format(prestamo.getFECHA_FIN().getTime()));
		
		//obtener todos los usuarios
//		Calendar calendario =Calendar.getInstance();
//		calendario.add(Calendar.DAY_OF_YEAR, -6);
//		ArrayList<Modelo_Prestamo_Sala> prestamos = ps.obtenerPrestamosSalaPorFecha(calendario);
//		for (int i = 0; i < prestamos.size(); i++) {
//			System.out.println("ID = "+prestamos.get(i).getIDPRESTAMOSALA()+" Fecha Inicio = "+sdf.format(prestamos.get(i).getFECHA_INICIO().getTime())+" Fecha Fin = "+sdf.format(prestamos.get(i).getFECHA_FIN().getTime()));
//		}
		
		//Obtener todos los prestamos
//		ArrayList<Modelo_Prestamo_Sala> prestamos = ps.obtenerPrestamosSala();
//		for (int i = 0; i < prestamos.size(); i++) {
//			System.out.println("ID = "+prestamos.get(i).getIDPRESTAMOSALA()+" Fecha Inicio = "+sdf.format(prestamos.get(i).getFECHA_INICIO().getTime())+" Fecha Fin = "+sdf.format(prestamos.get(i).getFECHA_FIN().getTime()));
//		}

		//eliminar carrera
//		if (ps.eliminarPrestamoSala(3)) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}

}
