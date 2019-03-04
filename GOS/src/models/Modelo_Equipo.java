package models;

public class Modelo_Equipo {
	private int IDEQUIPO;
	private String NOMBREEQUIPO;
	private int IDSALA;
	
	public Modelo_Equipo(int iDEQUIPO, String nOMBREEQUIPO, int sALA) {
		IDEQUIPO = iDEQUIPO;
		NOMBREEQUIPO = nOMBREEQUIPO;
		IDSALA = sALA;
	}

	public int getIDEQUIPO() {
		return IDEQUIPO;
	}

	public void setIDEQUIPO(int iDEQUIPO) {
		IDEQUIPO = iDEQUIPO;
	}

	public String getNOMBREEQUIPO() {
		return NOMBREEQUIPO;
	}

	public void setNOMBREEQUIPO(String nOMBREEQUIPO) {
		NOMBREEQUIPO = nOMBREEQUIPO;
	}

	public int getIDSALA() {
		return IDSALA;
	}

	public void setIDSALA(int sALA) {
		IDSALA = sALA;
	}
	
}
