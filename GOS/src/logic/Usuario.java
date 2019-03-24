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
		
	}

	public boolean crearUsuario(Modelo_Usuario usuario) {
		Connection con = null;
		boolean save = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("insert into usuario (IDCARRERA, IDTIPO, CODIGOUSUARIO, NOMBREUSUARIO, APELLIDOUSUARIO, CORREO, CONTRASENA) values (?,?,?,?,?,?,?)");
			if(usuario.getIDCARRERA() == 0) {
				ps.setString(1, null);
			}else {
				ps.setInt(1, usuario.getIDCARRERA());
			}
			ps.setInt(2, usuario.getIDTIPO());
			ps.setInt(3, usuario.getCODIGOUSUARIO());
			ps.setString(4, usuario.getNOMBREUSUARIO());
			ps.setString(5, usuario.getAPELLIDOUSUARIO());
			ps.setString(6, usuario.getCORREO());
			ps.setString(7, usuario.getCONTRASENA());

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
	
	public boolean actualizarUsuario(Modelo_Usuario usuario) {
		Connection con = null;
		boolean save = false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("update usuario set IDCARRERA=?, IDTIPO=?, CODIGOUSUARIO=?, NOMBREUSUARIO=?, APELLIDOUSUARIO=?, CORREO=?, CONTRASENA=? where IDUSUARIO=?");
			
			ps.setInt(1, usuario.getIDCARRERA());
			ps.setInt(2, usuario.getIDTIPO());
			ps.setInt(3, usuario.getCODIGOUSUARIO());
			ps.setString(4, usuario.getNOMBREUSUARIO());
			ps.setString(5, usuario.getAPELLIDOUSUARIO());
			ps.setString(6, usuario.getCORREO());
			ps.setString(7, usuario.getCONTRASENA());
			ps.setInt(8, usuario.getIDUSUARIO());

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

	public boolean eliminarUsuario(int codigoUsuario) {
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

	public ArrayList<Modelo_Usuario> obtenerUsuarios() {		
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
						rs.getString("APELLIDOUSUARIO"),
						rs.getString("CORREO"),
						rs.getString("CONTRASENA")
						);
				
				usuarios.add(usuario);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return usuarios;
	}

	public Modelo_Usuario obtenerUsuario(int codigoUsuario) {
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
						rs.getString("APELLIDOUSUARIO"),
						rs.getString("CORREO"),
						rs.getString("CONTRASENA")
						);
			} else {
				usuario=null;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return usuario;
	}
	
	public boolean usuarioExiste(int codigoUsuario) {
		Connection con = null;
		boolean usuarioExiste=false;

		try {

			con = conexion.getConnection();
			ps = con.prepareStatement("SELECT * FROM usuario WHERE CODIGOUSUARIO = ?");
			ps.setInt(1, codigoUsuario);

			rs = ps.executeQuery();

			if (rs.next()) {
				usuarioExiste=true;
			} else {
				usuarioExiste=false;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		return usuarioExiste;
	}

	public static void main(String[] args) {

		Usuario u = new Usuario();
		// agregar usuario
//		if (u.crearUsuario(new Modelo_Usuario(0, 1, 4, 201320556, "Carlos", "Zambrano","carlos.zambrano@uptc.edu.co","1234"))) {
//			System.out.println("Se registro correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}
		
		// actualizar usuario
		if (u.actualizarUsuario(new Modelo_Usuario(3, 1, 4, 201320222, "Actualizado B.", "ACtualizado","carlos.zambrano@uptc.edu.co","1234"))) {
			System.out.println("Se actualizó correctamente");
		} else {
			System.out.println("Ocurrió un error");
		}
		
//		// buscar USUARIO
//		Modelo_Usuario usuario = u.obtenerUsuario(201320333);
//		System.out.println("ID "+usuario.getIDUSUARIO());
//		System.out.println("ID Carrera "+usuario.getIDCARRERA());
//		System.out.println("ID Tipo"+usuario.getIDTIPO());
//		System.out.println("Codigo "+usuario.getCODIGOUSUARIO());
//		System.out.println("Nombre "+usuario.getNOMBREUSUARIO());
//		System.out.println("Apellido "+usuario.getAPELLIDOUSUARIO());
		
//		if(u.usuarioExiste(201320222)) {
//			System.out.println("si");
//		}else if(!u.usuarioExiste(201320222)) {
//			System.out.println("no");
//		}
		
		//obtener todos los usuarios
//		ArrayList<Modelo_Usuario> usuarios = u.obtenerUsuarios();
//		for (int i = 0; i < usuarios.size(); i++) {
//			System.out.println("Codigo = "+usuarios.get(i).getCODIGOUSUARIO()+" Nombre = "+usuarios.get(i).getNOMBREUSUARIO());
//		}
		
		//eliminar carrera
//		if (u.eliminarUsuario(201322123)) {
//			System.out.println("Se eliminó correctamente");
//		} else {
//			System.out.println("Ocurrió un error");
//		}

	}

}
