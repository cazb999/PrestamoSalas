package models;

import java.util.Calendar;

public class Modelo_Prestamo_Sala {
	
	private int IDPRESTAMOSALA;
	private Calendar FECHA_INICIO;
	private Calendar FECHA_FIN;
	private int IDUSUARIO;
	private int IDSALA;
	
	
	
	public Modelo_Prestamo_Sala(int iDPRESTAMOSALA, Calendar fECHA_INICIO, Calendar fECHA_FIN, int iDUSUARIO,
			int iDSALA) {
		IDPRESTAMOSALA = iDPRESTAMOSALA;
		FECHA_INICIO = fECHA_INICIO;
		FECHA_FIN = fECHA_FIN;
		IDUSUARIO = iDUSUARIO;
		IDSALA = iDSALA;
	}
	public int getIDPRESTAMOSALA() {
		return IDPRESTAMOSALA;
	}
	public void setIDPRESTAMOSALA(int iDPRESTAMOSALA) {
		IDPRESTAMOSALA = iDPRESTAMOSALA;
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
	public int getIDUSUARIO() {
		return IDUSUARIO;
	}
	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}
	public int getIDSALA() {
		return IDSALA;
	}
	public void setIDSALA(int iDSALA) {
		IDSALA = iDSALA;
	}
	
	

}
