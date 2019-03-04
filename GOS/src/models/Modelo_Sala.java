package models;

public class Modelo_Sala {
	private int IDSALA;
	private String NOMBRESALA;
	private int CAPACIDADSALA;
	
	public Modelo_Sala(int iDSALA, String nOMBRESALA, int cAPACIDADSALA) {
		super();
		IDSALA = iDSALA;
		NOMBRESALA = nOMBRESALA;
		CAPACIDADSALA = cAPACIDADSALA;
	}

	public int getIDSALA() {
		return IDSALA;
	}

	public void setIDSALA(int iDSALA) {
		IDSALA = iDSALA;
	}

	public String getNOMBRESALA() {
		return NOMBRESALA;
	}

	public void setNOMBRESALA(String nOMBRESALA) {
		NOMBRESALA = nOMBRESALA;
	}

	public int getCAPACIDADSALA() {
		return CAPACIDADSALA;
	}

	public void setCAPACIDADSALA(int cAPACIDADSALA) {
		CAPACIDADSALA = cAPACIDADSALA;
	}	
	
}
