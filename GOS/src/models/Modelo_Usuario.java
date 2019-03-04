package models;

public class Modelo_Usuario {
	
	private int IDUSUARIO;
	private int IDCARRERA;
	private int IDTIPO;
	private int CODIGOUSUARIO;
	private String NOMBREUSUARIO;
	private String APELLIDOUSUARIO;
	
	public Modelo_Usuario(int IDUSUARIO, int IDCARRERA, int IDTIPO, int CODIGOUSUARIO, String NOMBREUSUARIO,
			String APELLIDOUSUARIO) {
		super();
		this.IDUSUARIO = IDUSUARIO;
		this.IDCARRERA = IDCARRERA;
		this.IDTIPO = IDTIPO;
		this.CODIGOUSUARIO = CODIGOUSUARIO;
		this.NOMBREUSUARIO = NOMBREUSUARIO;
		this.APELLIDOUSUARIO = APELLIDOUSUARIO;
	}
	
	public int getIDUSUARIO() {
		return IDUSUARIO;
	}
	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}
	public int getIDCARRERA() {
		return IDCARRERA;
	}
	public void setIDCARRERA(int iDCARRERA) {
		IDCARRERA = iDCARRERA;
	}
	public int getIDTIPO() {
		return IDTIPO;
	}
	public void setIDTIPO(int iDTIPO) {
		IDTIPO = iDTIPO;
	}
	public int getCODIGOUSUARIO() {
		return CODIGOUSUARIO;
	}
	public void setCODIGOUSUARIO(int cODIGOUSUARIO) {
		CODIGOUSUARIO = cODIGOUSUARIO;
	}
	public String getNOMBREUSUARIO() {
		return NOMBREUSUARIO;
	}
	public void setNOMBREUSUARIO(String nOMBREUSUARIO) {
		NOMBREUSUARIO = nOMBREUSUARIO;
	}
	public String getAPELLIDOUSUARIO() {
		return APELLIDOUSUARIO;
	}
	public void setAPELLIDOUSUARIO(String aPELLIDOUSUARIO) {
		APELLIDOUSUARIO = aPELLIDOUSUARIO;
	}
	
	

}
