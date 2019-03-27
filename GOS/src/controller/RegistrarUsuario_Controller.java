package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import interfaces.PanelRegistrarUsuario;
import logic.Usuario;
import models.Modelo_Usuario;

public class RegistrarUsuario_Controller implements ActionListener {

	PanelRegistrarUsuario panel;
	Usuario usuario;

	public RegistrarUsuario_Controller(PanelRegistrarUsuario panel) {
		this.panel = panel;
		this.usuario = new Usuario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.panel.getBtnRegistrar()) {

			String nombre = this.panel.getTxtNombre().getText();
			String apellido = this.panel.getTxtApellido().getText();
			String codigo = this.panel.getTxtCodigo().getText();
			String contrasena = this.panel.getTxtContrasena().getText();
			String correo = this.panel.getTxtCorreo().getText();
			int tipo = this.panel.getCbxTipo().getSelectedIndex();
			int carrera = this.panel.getCbxCarrera().getSelectedIndex();

			if (tipo > 0 && carrera > 0 && !nombre.equals("") && !apellido.equals("") && !codigo.equals("") && !correo.equals("")) {
				if (tipo >= 3 && contrasena.equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, asigne una contraseña");
				} else {
					if ((tipo == 1 || tipo == 2 || tipo == 4) && carrera == 1) {
						JOptionPane.showMessageDialog(null, "Por favor asigne una carrera al usuario");
					} else {
						if (!usuario.usuarioExiste(Integer.parseInt(codigo))) {
							if (usuario.crearUsuario(new Modelo_Usuario(0, (carrera - 1), tipo,
									Integer.parseInt(codigo), nombre, apellido, correo, contrasena))) {
								JOptionPane.showMessageDialog(null, "Usuario registrado satisfactoriamente!");
								this.panel.getTxtNombre().setText("");
								this.panel.getTxtApellido().setText("");
								this.panel.getTxtCodigo().setText("");
								this.panel.getTxtContrasena().setText("");
								this.panel.getTxtCorreo().setText("");
								this.panel.getCbxTipo().setSelectedIndex(0);
								this.panel.getCbxCarrera().setSelectedIndex(0);
							} else {
								JOptionPane.showMessageDialog(null, "Ocurrió un error");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Este usuario ya existe!");
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos");
			}

		}
		
		if(e.getSource() == this.panel.getBtnLimpiar()) {
			this.panel.getTxtNombre().setText("");
			this.panel.getTxtApellido().setText("");
			this.panel.getTxtCodigo().setText("");
			this.panel.getTxtContrasena().setText("");
			this.panel.getTxtCorreo().setText("");
			this.panel.getCbxTipo().setSelectedIndex(0);
			this.panel.getCbxCarrera().setSelectedIndex(0);
		}
	}
}
