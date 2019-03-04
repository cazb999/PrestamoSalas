package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Modelo_Usuario;

public class Usuario {

	private Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	private boolean crearUsuario(Modelo_Usuario usuario) {
		Connection con = null;
		boolean save = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("insert into usuario (IDCARRERA, IDTIPO, CODIGOUSUARIO, NOMBREUSUARIO, APELLIDOUSUARIO) values (?,?,?,?,?)");
			ps.setInt(1, usuario.getIDCARRERA());
			ps.setInt(2, usuario.getIDTIPO());
			ps.setInt(3, usuario.getCODIGOUSUARIO());
			ps.setString(4, usuario.getNOMBREUSUARIO());
			ps.setString(5, usuario.getAPELLIDOUSUARIO());

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

	private boolean eliminarUsuario(int codigoUsuario) {
		Connection con = null;
		boolean eliminado = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("DELETE FROM usuario WHERE CODIGOUSUARIO=?");
			ps.setInt(1, codigoUsuario);

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

	private ArrayList<Modelo_Usuario> obtenerUsuarios() {		
		ArrayList<Modelo_Usuario> usuarios = new ArrayList<Modelo_Usuario>();
		Connection con = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM usuario");

			rs = ps.executeQuery();

			while (rs.next()) {
				Modelo_Usuario usuario = new Modelo_Usuario(
						rs.getInt("IDUSUARIO"),
						rs.getInt("IDCARRERA"),
						rs.getInt("IDTIPO"),
						rs.getInt("CODIGOUSUARIO"),
						rs.getString("NOMBREUSUARIO"),
						rs.getString("APELLIDOUSUARIO")
						);
				
				usuarios.add(usuario);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return usuarios;
	}

	private Modelo_Usuario obtenerUsuario(int codigoUsuario) {
		Connection con = null;
		Modelo_Usuario usuario = null;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM usuario WHERE CODIGOUSUARIO = ?");
			ps.setInt(1, codigoUsuario);

			rs = ps.executeQuery();

			if (rs.next()) {
				usuario = new Modelo_Usuario(
						rs.getInt("IDUSUARIO"),
						rs.getInt("IDCARRERA"),
						rs.getInt("IDTIPO"),
						rs.getInt("CODIGOUSUARIO"),
						rs.getString("NOMBREUSUARIO"),
						rs.getString("APELLIDOUSUARIO")
						);
			} else {
				usuario=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return usuario;
	}

	public static void main(String[] args) {

		Usuario u = new Usuario();
		// agregar usuario
//		if (u.crearUsuario(new Modelo_Usuario(0, 1, 1, 201320111, "Pepito", "Perez"))) {
//			System.out.println("Se registro correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}
		
//		// buscar USUARIO
//		Modelo_Usuario usuario = u.obtenerUsuario(201322123);
//		System.out.println("ID "+usuario.getIDUSUARIO());
//		System.out.println("ID Carrera "+usuario.getIDCARRERA());
//		System.out.println("ID Tipo"+usuario.getIDTIPO());
//		System.out.println("Codigo "+usuario.getCODIGOUSUARIO());
//		System.out.println("Nombre "+usuario.getNOMBREUSUARIO());
//		System.out.println("Apellido "+usuario.getAPELLIDOUSUARIO());
		
		//obtener todos los usuarios
		ArrayList<Modelo_Usuario> usuarios = u.obtenerUsuarios();
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println("Codigo = "+usuarios.get(i).getCODIGOUSUARIO()+" Nombre = "+usuarios.get(i).getNOMBREUSUARIO());
		}
		
		//eliminar carrera
//		if (u.eliminarUsuario(201322123)) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}

}
