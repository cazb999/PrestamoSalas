package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import interfaces.Login;
import interfaces.MenuBecario;
import logic.Usuario;
import models.Modelo_Usuario;

public class Login_Controller implements ActionListener {

	private Login login;
	private Usuario usuario;

	public Login_Controller(Login login) {
		this.login = login;
		this.usuario = new Usuario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.login.getBtnLogin() == e.getSource()) {
			String usuario = this.login.getTxtUsuario().getText();
			String contrasena = new String(this.login.getTxtContrasena().getPassword());
			Modelo_Usuario user = this.usuario.obtenerUsuario(Integer.parseInt(usuario));

			int cod = Integer.parseInt(usuario);
			if (user != null) {
				if (user.getCONTRASENA() != null) {
					if (user.getCODIGOUSUARIO() == cod && user.getCONTRASENA().equals(contrasena)
							&& user.getIDTIPO() == 4) {
						MenuBecario mb = new MenuBecario();
						mb.setVisible(true);
						mb.setLocationRelativeTo(null);
						mb.setResizable(false);
						this.login.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Este usuario no es administrador");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Este usuario no existe");
			}
		}

	}
}
