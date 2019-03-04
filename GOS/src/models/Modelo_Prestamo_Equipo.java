package models;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class Modelo_Prestamo_Equipo {
	private int IDPRESTAMOEQUIPO;
	private int IDUSUARIO;
	private int IDEQUIPO;
	private Calendar FECHA;
	
	public Modelo_Prestamo_Equipo(int iDPRESTAMOEQUIPO, int iDUSUARIO, int iDEQUIPO, Calendar fecha) {
		super();
		IDPRESTAMOEQUIPO = iDPRESTAMOEQUIPO;
		IDUSUARIO = iDUSUARIO;
		IDEQUIPO = iDEQUIPO;
		FECHA = fecha;
	}

	public int getIDPRESTAMOEQUIPO() {
		return IDPRESTAMOEQUIPO;
	}

	public void setIDPRESTAMOEQUIPO(int iDPRESTAMOEQUIPO) {
		IDPRESTAMOEQUIPO = iDPRESTAMOEQUIPO;
	}

	public int getIDUSUARIO() {
		return IDUSUARIO;
	}

	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}

	public int getIDEQUIPO() {
		return IDEQUIPO;
	}

	public void setIDEQUIPO(int iDEQUIPO) {
		IDEQUIPO = iDEQUIPO;
	}

	public Calendar getFECHA() {
		return FECHA;
	}

	public void setFECHA(Calendar fECHA) {
		FECHA = fECHA;
	}
	
	
	
	
}
