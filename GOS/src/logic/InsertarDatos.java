package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
	

	private Conexion con = new Conexion();
	
	public boolean InsertarDato() {
		
		String insertTableSQL = "INSERT INTO CARRERA VALUES"
                + "(?,?)";

        try {
            Connection dbConnection = con.getConnection();
            PreparedStatement preparedStatement= dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Industrial");
            
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Se ha intertado con exito!");
            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;
        } 
		
		
	}
	
	public static void main(String[] args) {
		InsertarDatos cd = new InsertarDatos();
		cd.InsertarDato();
		
	}
}
