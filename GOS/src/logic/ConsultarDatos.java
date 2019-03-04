package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarDatos {
	
	Conexion con = new Conexion();
	
	public ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = con.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultado;
    }
	
	public static void main(String[] args) throws SQLException {
		ConsultarDatos consultar = new ConsultarDatos();
		
		ResultSet result = consultar.consultar("SELECT * FROM CARRERA;");
		
		while (result.next()) {
            System.out.println(""+result.getInt("idCarrera")+"       "+result.getString("nombreCarrera"));
        }
	}
}
