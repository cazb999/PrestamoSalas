package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.PanelActualizarEstudiante;
import logic.Usuario;
import models.Modelo_Usuario;

public class ActualizarUsuario_Controller implements ActionListener {

	PanelActualizarEstudiante panel;

	public ActualizarUsuario_Controller(PanelActualizarEstudiante panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.panel.getBtnBuscar() == e.getSource()) {
			Usuario usuario = new Usuario();
			if (!this.panel.getTxtBuscarCodigo().getText().equals("")) {
				int codigo = Integer.parseInt(this.panel.getTxtBuscarCodigo().getText());
				if (usuario.usuarioExiste(codigo)) {

					Modelo_Usuario user = usuario.obtenerUsuario(codigo);

					this.panel.getTxtApellido().setText(user.getAPELLIDOUSUARIO());
					this.panel.getTxtCodigo().setText("" + user.getCODIGOUSUARIO());
					this.panel.getTxtNombre().setText(user.getNOMBREUSUARIO());
					this.panel.getCbxTipo().setSelectedIndex(user.getIDTIPO());
					this.panel.getTxtCorreo().setText(user.getCORREO());
					this.panel.getTxtContrasena().setText(user.getCONTRASENA());

					if (user.getIDCARRERA() > 0) {
						this.panel.getCbxCarrera().setSelectedIndex(user.getIDCARRERA() + 1);
					} else {
						this.panel.getCbxCarrera().setSelectedIndex(1);
					}
					
					this.panel.getTxtBuscarCodigo().setEditable(false);;
					
				} else {
					JOptionPane.showMessageDialog(null, "Este usuario no existe!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese un código!");
			}
		}

		if (e.getSource() == this.panel.getBtnActualizar()) {
			
			if(!this.panel.getTxtBuscarCodigo().getText().equals("")) {
			Usuario usuario = new Usuario();			
			
			String nombre = this.panel.getTxtNombre().getText();
			String apellido = this.panel.getTxtApellido().getText();
			String codigo = this.panel.getTxtCodigo().getText();
			String contrasena = this.panel.getTxtContrasena().getText();
			String correo = this.panel.getTxtCorreo().getText();
			int tipo = this.panel.getCbxTipo().getSelectedIndex();
			int carrera = this.panel.getCbxCarrera().getSelectedIndex();
			String codigoBuscar = this.panel.getTxtBuscarCodigo().getText();
			
			Modelo_Usuario usuario_id = usuario.obtenerUsuario(Integer.parseInt(codigoBuscar));

			if (tipo > 0 && carrera > 0 && !nombre.equals("") && !apellido.equals("") && !codigo.equals("") && !correo.equals("")) {
				if (tipo >= 3 && contrasena.equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, asigne una contraseña");
				} else {
					if (tipo == 1 || tipo == 2 || tipo == 4 && carrera == 1) {
						JOptionPane.showMessageDialog(null, "Por favor asigne una carrera al usuario");
					} else {
						if ((usuario.usuarioExiste(Integer.parseInt(codigo)) && codigo.equals(codigoBuscar)) || (!usuario.usuarioExiste(Integer.parseInt(codigo)))) {
							if (usuario.actualizarUsuario(new Modelo_Usuario(usuario_id.getIDUSUARIO(), (carrera - 1), tipo, Integer.parseInt(codigo), nombre, apellido, correo, contrasena))) {
								JOptionPane.showMessageDialog(null, "Usuario actualizado satisfactoriamente!");
								this.panel.getTxtNombre().setText("");
								this.panel.getTxtApellido().setText("");
								this.panel.getTxtCodigo().setText("");
								this.panel.getTxtContrasena().setText("");
								this.panel.getTxtCorreo().setText("");
								this.panel.getCbxTipo().setSelectedIndex(0);
								this.panel.getCbxCarrera().setSelectedIndex(0);
								this.panel.getTxtBuscarCodigo().setEditable(true);
								this.panel.getTxtBuscarCodigo().setText("");
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
		}else {
			JOptionPane.showMessageDialog(null, "Por favor, primero busque el usuario ha actualizar!");
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
			this.panel.getTxtBuscarCodigo().setEditable(true);
			this.panel.getTxtBuscarCodigo().setText("");
		}
	}
}
