package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.PanelEliminarEstudiante;
import logic.Carrera;
import logic.Usuario;
import models.Modelo_Usuario;

public class EliminarUsuario_Controller implements ActionListener{
	
	private PanelEliminarEstudiante panel;
	private Carrera carrera;
	
	public EliminarUsuario_Controller(PanelEliminarEstudiante panel) {
		this.panel = panel;
		this.carrera = new Carrera();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.panel.getBtnBuscar()) {
			Usuario usuario = new Usuario();
			if(!this.panel.getTxtBuscarEstudiante().getText().equals("")) {
				if(usuario.usuarioExiste(Integer.parseInt(this.panel.getTxtBuscarEstudiante().getText()))) {
					Modelo_Usuario usuarioEliminar = usuario.obtenerUsuario(Integer.parseInt(this.panel.getTxtBuscarEstudiante().getText()));
					this.panel.getTxtApellido().setText(usuarioEliminar.getAPELLIDOUSUARIO());
					this.panel.getTxtCodigo().setText(usuarioEliminar.getCODIGOUSUARIO()+"");
					this.panel.getTxtNombre().setText(usuarioEliminar.getNOMBREUSUARIO());
					
					switch (usuarioEliminar.getIDTIPO()) {
					case 1:
						this.panel.getTxtTipo().setText("Estudiante");
						break;
					case 2:
						this.panel.getTxtTipo().setText("Docente");
						break;
					case 3:
						this.panel.getTxtTipo().setText("Administrativo");
						break;
					case 4:
						this.panel.getTxtTipo().setText("Becario");
						break;
					case 5:
						this.panel.getTxtTipo().setText("Administrador");
						break;
					default:
						break;
					}
					
					if(usuarioEliminar.getIDCARRERA() != 0) {
						ArrayList<String[]> carreras = carrera.obtenerCarreras();
						for (int i = 0; i < carreras.size(); i++) {
							if(Integer.parseInt(carreras.get(i)[0]) == usuarioEliminar.getIDCARRERA()) {
								this.panel.getTxtCarrera().setText(carreras.get(i)[1]);
							}
						}
					}else {
						this.panel.getTxtCarrera().setText("No Aplica");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Este usuario no existe");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese un codigo para buscar");
			}
		}
		
		if(e.getSource() == this.panel.getBtnEliminar()) {
			Usuario usuario = new Usuario();
			if(!this.panel.getTxtCodigo().getText().equals("")) {
				if(usuario.eliminarUsuario(Integer.parseInt(this.panel.getTxtCodigo().getText()))) {
					JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente!");
					this.panel.getTxtApellido().setText("");
					this.panel.getTxtCodigo().setText("");
					this.panel.getTxtNombre().setText("");
					this.panel.getTxtBuscarEstudiante().setText("");
					this.panel.getTxtCarrera().setText("");
					this.panel.getTxtTipo().setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor, primero debe buscar al usuario!");
			}
		}
		
		if(e.getSource() == this.panel.getBtnLimpiar()) {
			this.panel.getTxtApellido().setText("");
			this.panel.getTxtCodigo().setText("");
			this.panel.getTxtNombre().setText("");
			this.panel.getTxtBuscarEstudiante().setText("");
			this.panel.getTxtCarrera().setText("");
			this.panel.getTxtTipo().setText("");
		}
		
	}
}
