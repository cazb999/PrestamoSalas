package models;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class Modelo_Prestamo_Equipo {
	private int IDPRESTAMOEQUIPO;
	private int IDUSUARIO;
	private int IDEQUIPO;
	private Calendar FECHA_INICIO;
	private Calendar FECHA_FIN;
	
	public Modelo_Prestamo_Equipo(int iDPRESTAMOEQUIPO, int iDUSUARIO, int iDEQUIPO, Calendar FECHA_INICIO, Calendar FECHA_FIN) {
		super();
		this.IDPRESTAMOEQUIPO = iDPRESTAMOEQUIPO;
		this.IDUSUARIO = iDUSUARIO;
		this.IDEQUIPO = iDEQUIPO;
		this.FECHA_INICIO = FECHA_INICIO;
		this.FECHA_FIN = FECHA_FIN;
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

	public Calendar getFECHA_INICIO() {
		return FECHA_INICIO;
	}

	public void setFECHA_INICIO(Calendar fECHA_INICIO) {
		FECHA_INICIO = fECHA_INICIO;
	}

	public Calendar getFECHA_FIN() {
		return FECHA_FIN;
	}

	public void setFECHA_FIN(Calendar fECHA_FIN) {
		FECHA_FIN = fECHA_FIN;
	}
	
	
	
	
	
	
}
